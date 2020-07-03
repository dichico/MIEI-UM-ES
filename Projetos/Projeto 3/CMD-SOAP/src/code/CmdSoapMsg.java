package code;

import wsdlservice.*;

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

        byte[] Sha256 = new byte[] {
                (byte)0x30, (byte)0x31, (byte)0x30, (byte)0x0d, (byte)0x06, (byte)0x09,
                (byte)0x60, (byte)0x86, (byte)0x48, (byte)0x01, (byte)0x65, (byte)0x03,
                (byte)0x04, (byte)0x02, (byte)0x01, (byte)0x05, (byte)0x00, (byte)0x04, (byte)0x20};

        // Concatenar o Prefixo à Hash dada como parâmetro
        byte[] hashWithPrefix = new byte[Sha256.length + hash.length];
        System.arraycopy(Sha256   , 0, hashWithPrefix, 0, Sha256.length);
        System.arraycopy(hash, 0, hashWithPrefix, Sha256.length, hash.length);

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
            byte[] hashWithPrefix = hashPrefix(encodedHash, "Sha256");
            request.setHash(hashWithPrefix);
        }
        else {
            byte[] hashWithPrefix = hashPrefix(hash, "Sha256");
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

    public String ccMovelMultipleSign(byte[] applicationId, String docName, byte[] hash, String userId, String userPin) throws NoSuchAlgorithmException {

        // Criar a Instância do Pedido
        MultipleSignRequest request = new MultipleSignRequest();

        // Definir o Application Id
        request.setApplicationId(applicationId);

        // Definir o Id e o Pin do User
        request.setUserId(userId);
        request.setPin(userPin);

        // Definir o Array de Documentos a Assinar
        ArrayOfHashStructure documents = new ArrayOfHashStructure();

        // Documento 1
        HashStructure firstDocument = new HashStructure();

        String firstMessage = "Nobody inspects the spammish repetition";
        MessageDigest firstDigest = MessageDigest.getInstance("SHA-256");
        byte[] firstHash = firstDigest.digest(firstMessage.getBytes());

        firstDocument.setHash(firstHash);
        firstDocument.setName("Docname Test 1");
        firstDocument.setId("1234");

        documents.getHashStructure().add(firstDocument);

        // Documento 2
        HashStructure secondDocument = new HashStructure();

        String secondMessage = "Nobody inspects the spammish repetition";
        MessageDigest secondDigest = MessageDigest.getInstance("SHA-256");
        byte[] secondHash = secondDigest.digest(secondMessage.getBytes());

        secondDocument.setHash(secondHash);
        secondDocument.setName("Docname Test 2");
        secondDocument.setId("1235");

        documents.getHashStructure().add(secondDocument);

        // Efetuar o pedido ao serviço AMA
        SignStatus status = connector.ccMovelMultipleSign(request, documents);

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
