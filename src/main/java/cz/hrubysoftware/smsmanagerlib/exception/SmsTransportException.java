package cz.hrubysoftware.smsmanagerlib.exception;

public class SmsTransportException extends Exception {
    public SmsTransportException(String message) {
        super(message);
    }

    public SmsTransportException(String message, Throwable cause) {
        super(message, cause);
    }
}
