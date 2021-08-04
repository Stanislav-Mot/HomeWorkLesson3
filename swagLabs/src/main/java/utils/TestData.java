package utils;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    public static String welcomeMessage = "THANK YOU FOR YOUR ORDER";
    public static String standardUser = "standard_user";
    public static String lockedOutUser = "locked_out_user";
    public static String problemUser = "problem_user";
    public static String performanceGlitchUser = "performance_glitch_user";
    public static String password = "secret_sauce";

    public static Map<String, String> map = new HashMap<String, String>() {
        {
            put("First_Name", "Stanislav");
            put("Last_Name", "Motoryn");
            put("Zip_Code", "258147");
        }
    };
}
