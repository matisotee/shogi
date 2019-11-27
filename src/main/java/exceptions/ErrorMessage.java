package exceptions;

public class ErrorMessage {

    private String exception;
    private String message;

    public ErrorMessage(UserException exception){
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getDescription();
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

}
