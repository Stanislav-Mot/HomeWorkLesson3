import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final String URL = "http://a.testaddressbook.com/sign_in";
    public static final String EMAIL = "stasmotorin199407@gmail.com";
    public static final String PASSWORD = "qwerty";
    public static final String COUNTRY = "Canada";
    private static final String PICTURE = new File("src/main/resources/bmw_x6_promo1.jpg").getAbsolutePath();

    public static Map<String, String> map = new HashMap<String, String>() {
        {
            put("FIRST_NAME", "Stanislav");
            put("LAST_NAME", "Motoryn");
            put("ADDRESS1", "Belarus");
            put("ADDRESS2", "Poland");
            put("CITY", "Minsk");
            put("ZIP_CODE", "200200");
            put("BIRTHDAY", "07.10.1994");
            put("COLOR", "#FF0000");
            put("AGE", "26");
            put("WEBSITE", "https://senlainc.com/");
            put("PICTURE", PICTURE);
            put("PHONE", "123456789");
            put("NOTE", "are you ok?");
        }
    };

}
