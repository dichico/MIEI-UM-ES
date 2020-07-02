package code;

public class MiniTeste {


    static byte[] applicationID = new CmdConfig().getApplicationID();
    static String meuTelemovel = "+351 914215212";

    public static void main(String[] args) {

        CmdSoapMsg teste = new CmdSoapMsg();

        String certificate = teste.getCertificate(applicationID, meuTelemovel);

        System.out.println(certificate);
    }
}
