import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public int RESPONSE_STATUS_CODE_200 = 200;
    public int RESPONSE_STATUS_CODE_500 = 500;
    public int RESPONSE_STATUS_CODE_400 = 400;
    public int RESPONSE_STATUS_CODE_401 = 401;
    public int RESPONSE_STATUS_CODE_201 = 201;

    public Properties prop;


    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/ig.config/config.properties");

            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String envDecider(String env) {
        String selectedEnv;
        if (env.contains("Prod"))
            selectedEnv = "Prod.json";
        else if (env.contains("qa3"))
            selectedEnv = "qa3.json";
        else if(env.contains("qa5"))
            selectedEnv = "qa5.json";
        else
            selectedEnv = "qa1.json";
        return selectedEnv;
    }
}
