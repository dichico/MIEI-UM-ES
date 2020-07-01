import javax.xml.soap.SOAPException;

public class MiniTeste {

    public static void main(String[] args) {

        try {
            CmdSoapMsg cmd = new CmdSoapMsg();
            String url = cmd.getWSDL(1);

            String xml = cmd.connection.get(url).toString();
            System.out.println(xml);
        } catch (SOAPException e) {
            System.out.println("Não funciona");
        }


    }
}
