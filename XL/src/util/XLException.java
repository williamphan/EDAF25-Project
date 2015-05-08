package util;

public class XLException extends RuntimeException {
    private String message;

    public XLException(String message) {
        super(message);
        this.message = message;
    }

    public String getLocalizedMessage(){
        return message.substring(0, message.indexOf(" "));
    }
}