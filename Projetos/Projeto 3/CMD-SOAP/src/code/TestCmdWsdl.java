package code;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class TestCmdWsdl {

    static Scanner myScanner;
    static CmdSoapMsg testClass = new CmdSoapMsg();

    static byte[] applicationID = new CmdConfig().getApplicationId();
    static String programVersion = "Version 1.0";

    public static String menuGetCertificate() {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################ Get Certificate ############################################\n");
        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN)...");
        String userId = myScanner.nextLine();

        return testClass.getCertificate(applicationID, userId);
    }

    public static String menuCCMovelSign() throws NoSuchAlgorithmException {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################# CC Movel Sign #############################################\n");
        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN)...");
        String userId = myScanner.nextLine();
        System.out.println("Insert Your CMD Signature Pin...");
        String userPin = myScanner.nextLine();

        return testClass.ccMovelSign(applicationID, userId, userPin).toString();
    }

    public static String menuValidateOTP() {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################# CC Movel Sign #############################################\n");
        System.out.println("Insert your ProcessID received in the answer of the CCMovel(Multiple)Sign command");
        String processId = myScanner.nextLine();
        System.out.println("Insert Your OTP received in your device");
        String otpCode = myScanner.nextLine();

        return testClass.validateOTP(applicationID, processId, otpCode).toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        int cmdOption = 0;
        int auxCmdOption;

        myScanner = new Scanner(System.in);

        do {
            System.out.println("\n########################### Command Line Program (Preprod/Prod Signature CMD) ###########################\n");
            System.out.println( "   1  Get Certificate - Devolve o Certificado do Cidadão e a Hierarquia de Certificação\n" +
                                "   2  CC Movel Sign - Devolve a inf. do estado da CMD Signature com a resposta do CCMovelSign\n" +
                                "   3  CC Multiple Sign - Devolve a inf. do estado da CMD Signature com a resposta do CCMovelMultipleSign\n" +
                                "   4  Validate OTP - Devolve a inf. do estado da Validação da OTP com a resposta do CCMovelMultipleSign\n" +
                                "   6  Run All Commands - Executa sequencialmente todos os comandos anteriores\n\n" +
                                "   7  Show Program Version - Mostra a Versão atual do Command Line Program\n" +
                                "   8  Show Help - Mostra ajuda relativamente ao uso do Commmand Line Program\n\n" +
                                "   0  Exit/Close the program"
                            );
            System.out.println("\n#########################################################################################################\n");
            System.out.println("Insert Your Option...");
            cmdOption = myScanner.nextInt();

            switch (cmdOption) {
                case 1:
                    String certificate = menuGetCertificate();
                    System.out.println(certificate);
                    System.out.println("\nInsert 0 to Back Main Menu...");

                    auxCmdOption = myScanner.nextInt();

                    if(auxCmdOption == 0) break;
                    else System.out.println("Invalid Option!");
                case 2:
                    String status = menuCCMovelSign();
                    System.out.println(status);
                    break;
                case 3:
                    break;
                case 4:
                    String validateOTP = menuValidateOTP();
                    System.out.println(validateOTP);
                    System.out.println("\nInsert 0 to Back Main Menu...");
                    auxCmdOption = myScanner.nextInt();

                    if(auxCmdOption == 0) break;
                    else System.out.println("Invalid Option!");
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Program Version: " + programVersion);
                case 8:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        } while (cmdOption != 0);
    }
}
