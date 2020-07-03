package code;

import wsdlservice.*;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CmdSoapMsg {

    CCMovelDigitalSignature service = new CCMovelDigitalSignature();
    CCMovelSignature connector = service.getBasicHttpBindingCCMovelSignature();

    public String getWsdl(int wsdl) {

        String[] wsdlURL = new String[] {
                "https://preprod.cmd.autenticacao.gov.pt/Ama.Authentication.Frontend/CCMovelDigitalSignature.svc?wsdl",
                "https://cmd.autenticacao.gov.pt/Ama.Authentication.Frontend/CCMovelDigitalSignature.svc?wsdl"
        };
        try {
            return wsdlURL[wsdl];
        } catch(ArrayIndexOutOfBoundsException exception) {
            return "No valid WSDL.";
        }
    }

    public byte[] hashPrefix(byte[] hash, String hashType) {

        byte[] prefixSha256 = new byte[] {
                (byte)0x30, (byte)0x31, (byte)0x30, (byte)0x0d, (byte)0x06, (byte)0x09,
                (byte)0x60, (byte)0x86, (byte)0x48, (byte)0x01, (byte)0x65, (byte)0x03,
                (byte)0x04, (byte)0x02, (byte)0x01, (byte)0x05, (byte)0x00, (byte)0x04, (byte)0x20};

        // Concatenar o Prefixo à Hash dada como parâmetro
        byte[] hashWithPrefix = new byte[prefixSha256.length + hash.length];
        System.arraycopy(prefixSha256   , 0, hashWithPrefix, 0, prefixSha256.length);
        System.arraycopy(hash, 0, hashWithPrefix, prefixSha256.length, hash.length);

        return hashWithPrefix;
    }

    public String getCertificate(byte[] applicationId, String userId) {
        return connector.getCertificate(applicationId, userId);
    }

    public String ccMovelSign(byte[] applicationId, String docName, byte[] hash, String userId, String userPin) throws NoSuchAlgorithmException {

        // Criar a Instância do Pedido
        SignRequest request = new SignRequest();

        // Definir o Application Id
        request.setApplicationId(applicationId);

        // Definir o Document Name
        if(docName == null) request.setDocName("Docname Teste");
        else request.setDocName(docName);

        // Definir a Hash
        if(hash == null) {
            String message = "Nobody inspects the spammish repetition";
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] encodedHash = digest.digest(message.getBytes());
            byte[] hashWithPrefix = hashPrefix(encodedHash, "SHA256");
            request.setHash(hashWithPrefix);
        }
        else {
            byte[] hashWithPrefix = hashPrefix(hash, "SHA256");
            request.setHash(hashWithPrefix);
        }

        // Definir o Id e o Pin do User
        request.setUserId(userId);
        request.setPin(userPin);

        // Efetuar o pedido ao serviço AMA
        SignStatus status = connector.ccMovelSign(request);

        // Imprimir o resultado do pedido
        System.out.println(status.getMessage());

        // Retornar apenas o processID para mostrar no menu CLI
        return status.getProcessId();
    }

    public String validateOTP(byte[] applicationId, String processId, String otpCode) {

        SignResponse response = connector.validateOtp(otpCode, processId, applicationId);

        // Imprimir o resultado da validação da assinatura
        System.out.println(response.getStatus().getMessage());

        // Retornar a assinatura para o menu CLI
        return response.getSignature().toString();
    }
}
