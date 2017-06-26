package cz.hrubysoftware.smsmanagerlib;


import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

@Data
public class SmsManager {
    public static final String VERSION = "1.0";
    public static final String JAVA_VERSION = System.getProperty("java.version");

    private String username;
    private String sha1password;

    public SmsManager(String username, String password) {
        this.username = username;
        this.sha1password = DigestUtils.sha1Hex(password.getBytes());
    }


}
