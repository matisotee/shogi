package exceptions;

public abstract class UserException extends Exception {


    private String description ;

    public UserException() {
        super();
        description = getDefaultDescription();

    }

    public UserException(String detail) {
        super();
        description = getDefaultDescription() + ". "+ detail;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected abstract String getDefaultDescription();

}
