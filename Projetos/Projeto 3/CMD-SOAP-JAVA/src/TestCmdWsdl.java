public class TestCmdWsdl {

    static CmdConfig cmdConfig = new CmdConfig();
    static String applicationID = cmdConfig.getApplicationID();

    public void argParse() {

    }

    public static void main(String[] args) {

        if(applicationID == null) {
            System.out.println("Falta configurar o Application ID");
        }

        if(args.length > 1) {
            System.out.println("Falta Implementar");
        }
        else {
            System.out.println("Use -h for Usage:\n" + "-h for all Operations\n");
            System.out.println(args[0]);
        }

    }
}
