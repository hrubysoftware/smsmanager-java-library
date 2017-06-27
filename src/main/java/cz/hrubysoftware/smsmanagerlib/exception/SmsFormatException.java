package cz.hrubysoftware.smsmanagerlib.exception;

public class SmsFormatException extends Exception {
    public SmsFormatException(String message) {
        super(message);
    }

    public SmsFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
