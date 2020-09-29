import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CommonUtils {
    public static ValidateJsonData getValidateJsonData() {
        return validateJsonData;
    }

    public static void setValidateJsonData(String  env) {
        Gson gson = new Gson();
        try {
            ValidateJsonData json = gson.fromJson(new FileReader("" + System.getProperty("user.dir") + "/src/main/ig.config/"  + envDecider(env) + ""), ValidateJsonData.class);
            CommonUtils.validateJsonData = json;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ValidateJsonData validateJsonData;


    private static String envDecider(String env) {
        String selectedEnv = null;
        if (env.contains("validate")) {
            selectedEnv = "validate.json";
        }
        return selectedEnv;
    }
}

