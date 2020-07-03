package code;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class TestCmdWsdl {

    static Scanner myScanner;
    static CmdSoapMsg testClass = new CmdSoapMsg();

    static byte[] applicationID = new CmdConfig().getApplicationId();
    static String programVersion = "Version 1.0";

    static final String regexPhone = "\\+351\\ [0-9]{9}";
    static final String regexPIN = "[0-9]{4,8}";
    static final String regexOTP = "[0-9]{6}";

    public static String menuGetCertificate() {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################ Get Certificate ############################################\n");
        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN): ");
        String userId = myScanner.nextLine();

        while(!userId.matches(regexPhone)){
            System.out.println("Your User Phone Number doesn't follow the parameters. (+XXX NNNNNNNNN)");
            System.out.println("Insert Your User Phone Number again: ");
            userId = myScanner.nextLine();
        }

        return testClass.getCertificate(applicationID, userId);
    }

    public static String menuCCMovelSign() throws NoSuchAlgorithmException {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################# CC Movel Sign #############################################\n");

        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN): ");
        String userId = myScanner.nextLine();

        while(!userId.matches(regexPhone)){
            System.out.println("Your User Phone Number doesn't follow the parameters (+XXX NNNNNNNNN).");
            System.out.println("Insert Your User Phone Number again: ");
            userId = myScanner.nextLine();
        }

        System.out.println("Insert Your CMD Signature Pin: ");
        String userPin = myScanner.nextLine();

        while(!userPin.matches(regexPIN)){
            System.out.println("Your CMD Signature Pin doesn't follow the parameters (Maximum 8 Digits).");
            System.out.println("Insert Your CMD Signature Pin again: ");
            userPin = myScanner.nextLine();
        }

        return testClass.ccMovelSign(applicationID, null, null, userId, userPin);
    }

    public static String menuValidateOTP() {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################# CC Movel Sign #############################################\n");
        System.out.println("Insert your ProcessID received in the answer of the CCMovel(Multiple)Sign command: ");
        String processId = myScanner.nextLine();
        System.out.println("Insert Your OTP received in your device: ");
        String otpCode = myScanner.nextLine();

        while(!otpCode.matches(regexPIN)){
            System.out.println("Your One Time Password doesn't follow the parameters. (6 digits)");
            System.out.println("Insert Your OTP received in your device again: ");
            otpCode = myScanner.nextLine();
        }

        return testClass.validateOTP(applicationID, processId, otpCode);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {

        int cmdOption = 0;
        int auxCmdOption;

        myScanner = new Scanner(System.in);

        do {
            System.out.println("\n########################### Command Line Program (Preprod/Prod Signature CMD) ###########################\n");
            System.out.println( "   1  Get Certificate - Devolve o Certificado do Cidadão e a Hierarquia de Certificação\n" +
                                "   2  CC Movel Sign - Devolve a inf. do estado da CMD Signature com a resposta do CCMovelSign\n" +
                                "   3  CC Multiple Sign - Devolve a inf. do estado da CMD Signature com a resposta do CCMovelMultipleSign\n" +
                                "   4  Validate OTP - Devolve a inf. do estado da Validação da OTP com a resposta do CCMovelMultipleSign\n" +
                                "   5  Run All Commands - Executa sequencialmente todos os comandos anteriores\n\n" +
                                "   6  Show Program Version - Mostra a Versão atual do Command Line Program\n" +
                                "   7  Show Help - Mostra ajuda relativamente ao uso do Commmand Line Program\n\n" +
                                "   0  Exit/Close the program"
                            );
            System.out.println("\n#########################################################################################################\n");
            System.out.println("Insert Your Option:");
            cmdOption = myScanner.nextInt();

            switch (cmdOption) {
                case 1:
                    String certificate = menuGetCertificate();
                    System.out.println(certificate);
                    Thread.sleep(2000);
                    break;
                case 2:
                    String processID = menuCCMovelSign();
                    System.out.println("Your Process Id is: " + processID);
                    Thread.sleep(2000);
                    break;
                case 3:
                    break;
                case 4:
                    String assinatura = menuValidateOTP();
                    System.out.println("The Document Signature is: " + assinatura);
                    Thread.sleep(2000);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Program Version: " + programVersion);
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        } while (cmdOption != 0);
    }
}
