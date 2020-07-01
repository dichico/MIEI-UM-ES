/**
 * Classe usada para testar todas as operações do serviço CMD (Chave Móvel Digital).
 * @author Diogo Araújo
 * @author Diogo Nogueira
 * @version 1.0
 */
public class TestCmdWsdl {

    static CmdConfig cmdConfig = new CmdConfig();
    static String applicationID = cmdConfig.getApplicationID();

    public static void argParse(String[] args) {

        switch (args[0]){
            case "GetCertificate":
                System.out.println(args[0]);
                break;

            case "CCMovelSign":
                break;

            case "CCMovelMultipleSign":
                break;

            case "ValidateOtp":
                break;

            case "TestAll":
                break;

        }
    }

    /**
     * Função Main que corre o programa.
     * @param args Argumentos dados na linha de comandos.
     */
    public static void main(String[] args) {

        if(applicationID == null) {
            System.out.println("Falta configurar o Application ID");
        }

        argParse(args);

        if(args.length > 0) {
            System.out.println("Falta Implementar");
        }
        else {
            String cmdUsage = "Use -h for Usage:\n\t" +
                    args[0] +
                    " -h for all Operations\n\t" +
                    args[0] +
                    " <oper1> -h for usage of operation <oper1>";
            System.out.println(cmdUsage);
        }

    }
}
