package env;

import java.util.Map;

public class JavaEnvVariables {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.err.println("Please input env variable name, eg: java env.JavaEnvVariables JAVA_HOME");
            Runtime.getRuntime().exit(-1);
        }
        String envName = args[0];
        Map<String, String> envVariables = System.getenv();
        String envVariableValue = envVariables.get(envName);
        System.out.println("env variable "+ envName +" value is:");
        System.out.println(envVariableValue);
    }
}
