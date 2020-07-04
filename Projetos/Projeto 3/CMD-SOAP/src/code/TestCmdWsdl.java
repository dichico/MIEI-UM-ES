package code;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Scanner;

public class TestCmdWsdl {

    static Scanner myScanner;
    static CmdSoapMsg testClass = new CmdSoapMsg();

    static byte[] applicationId = new CmdConfig().getApplicationId();
    static String programVersion = "Version 1.0";

    // Expressões Regulares para garantir os inputs dados no Command Line Program
    static final String regexPhone = "\\+351\\ [0-9]{9}";
    static final String regexPIN = "[0-9]{4,8}";
    static final String regexOTP = "[0-9]{6}";

    public static String menuGetCertificate() {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################ Get Certificate ############################################\n");
        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN):");
        String userId = myScanner.nextLine();

        while(!userId.matches(regexPhone)){
            System.out.println("Your User Phone Number doesn't follow the parameters. (+XXX NNNNNNNNN)");
            System.out.println("Insert Your User Phone Number again:");
            userId = myScanner.nextLine();
        }

        System.out.println("Insert Your Application Id (Enter to Ignore):");
        String myApplicationID = myScanner.nextLine();

        if(myApplicationID.isEmpty() && applicationId.length == 0) {
            return "Set your Application ID in the cmd_config.py file or provide it as a parameter.";
        }
        else if (myApplicationID.isEmpty()) return testClass.getCertificate(applicationId, userId);
        else return testClass.getCertificate(myApplicationID.getBytes(), userId);
    }

    public static String menuCCMovelSign() throws NoSuchAlgorithmException {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################# CC Movel Sign #############################################\n");

        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN):");
        String userId = myScanner.nextLine();

        while(!userId.matches(regexPhone)){
            System.out.println("Your User Phone Number doesn't follow the parameters (+XXX NNNNNNNNN).");
            System.out.println("Insert Your User Phone Number again:");
            userId = myScanner.nextLine();
        }

        System.out.println("Insert Your CMD Signature Pin:");
        String userPin = myScanner.nextLine();

        while(!userPin.matches(regexPIN)){
            System.out.println("Your CMD Signature Pin doesn't follow the parameters (Minimum 4, Maximum 8 Digits).");
            System.out.println("Insert Your CMD Signature Pin again:");
            userPin = myScanner.nextLine();
        }

        System.out.println("Insert Your Application Id (Enter to Ignore):");
        String myApplicationId = myScanner.nextLine();

        if(myApplicationId.isEmpty() && applicationId.length == 0) {
            return "Set your Application ID in the cmd_config.py file or provide it as a parameter.";
        }
        else if (myApplicationId.isEmpty()) return testClass.ccMovelSign(applicationId, null, null, userId, userPin);
        else return testClass.ccMovelSign(myApplicationId.getBytes(), null, null, userId, userPin);
    }

    public static String menuCCMovelMultipleSign() throws NoSuchAlgorithmException {
        myScanner = new Scanner(System.in);

        System.out.println("\n######################################## CC Movel Multiple Sign #########################################\n");

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
            System.out.println("Your CMD Signature Pin doesn't follow the parameters (Minimum 4, Maximum 8 Digits).");
            System.out.println("Insert Your CMD Signature Pin again: ");
            userPin = myScanner.nextLine();
        }

        System.out.println("Insert Your Application Id (Enter to Ignore): ");
        String myApplicationId = myScanner.nextLine();

        if(myApplicationId.isEmpty() && applicationId.length == 0) {
            return "Set your Application ID in the cmd_config.py file or provide it as a parameter.";
        }
        else if (myApplicationId.isEmpty()) return testClass.ccMovelMultipleSign(applicationId, null, null, userId, userPin);
        else return testClass.ccMovelMultipleSign(myApplicationId.getBytes(), null, null, userId, userPin);
    }

    public static String menuValidateOtp() {
        myScanner = new Scanner(System.in);

        System.out.println("\n############################################# Validate OTP ##############################################\n");

        System.out.println("Insert your ProcessID received in the answer of the CCMovel(Multiple)Sign command:");
        String processId = myScanner.nextLine();
        System.out.println("Insert Your OTP received in your device:");
        String otpCode = myScanner.nextLine();

        while(!otpCode.matches(regexPIN)){
            System.out.println("Your One Time Password doesn't follow the parameters (6 digits).");
            System.out.println("Insert Your OTP received in your device again:");
            otpCode = myScanner.nextLine();
        }

        System.out.println("Insert Your Application Id (Enter to Ignore):");
        String myApplicationId = myScanner.nextLine();

        if(myApplicationId.isEmpty() && applicationId.length == 0) {
            return "Set your Application ID in the cmd_config.py file or provide it as a parameter.";
        }
        else if (myApplicationId.isEmpty()) return testClass.validateOtp(applicationId, processId, otpCode);
        else return testClass.validateOtp(myApplicationId.getBytes(), processId, otpCode);
    }

    public static String menuTestAll() throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException {
        myScanner = new Scanner(System.in);

        System.out.println("\n########################################## Test All Commands ############################################\n");

        System.out.println("Insert the Path of the File you want to Sign:");
        String pathFile = myScanner.nextLine();

        System.out.println("Insert Your User Phone Number (+XXX NNNNNNNNN):");
        String userId = myScanner.nextLine();

        while(!userId.matches(regexPhone)){
            System.out.println("Your User Phone Number doesn't follow the parameters (+XXX NNNNNNNNN).");
            System.out.println("Insert Your User Phone Number again:");
            userId = myScanner.nextLine();
        }

        System.out.println("Insert Your CMD Signature Pin:");
        String userPin = myScanner.nextLine();

        while(!userPin.matches(regexPIN)){
            System.out.println("Your CMD Signature Pin doesn't follow the parameters (Minimum 4, Maximum 8 Digits).");
            System.out.println("Insert Your CMD Signature Pin again:");
            userPin = myScanner.nextLine();
        }

        System.out.println("Insert Your Application Id (Enter to Ignore):");
        String myApplicationId = myScanner.nextLine();

        if(myApplicationId.isEmpty() && applicationId.length == 0) {
            return "Set your Application ID in the cmd_config.py file or provide it as a parameter.";
        }
        else if (myApplicationId.isEmpty()) return testClass.testAll(applicationId, pathFile, userId, userPin);
        else return testClass.testAll(myApplicationId.getBytes(), pathFile, userId, userPin);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException, IOException, CertificateException, KeyStoreException {

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
                    String processID1 = menuCCMovelSign();
                    System.out.println("Your Process Id is: " + processID1);
                    Thread.sleep(2000);
                    break;
                case 3:
                    String processID2 = menuCCMovelMultipleSign();
                    System.out.println("Your Process Id is: " + processID2);
                    Thread.sleep(2000);
                    break;
                case 4:
                    String assinatura = menuValidateOtp();
                    System.out.println("The Document Signature is: " + assinatura);
                    Thread.sleep(2000);
                    break;
                case 5:
                    String teste = menuTestAll();
                    System.out.println(teste);
                    Thread.sleep(2000);
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
