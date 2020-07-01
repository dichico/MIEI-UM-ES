import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class CmdSoapMsg {

    // Variável global para albergar a ligação SOAP
    SOAPConnection connection;

    public CmdSoapMsg() throws SOAPException {
        SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
        connection = factory.createConnection();
    }

    public static String getWSDL(int wsdl) {

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
}

