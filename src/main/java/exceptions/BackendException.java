package exceptions;

public abstract class BackendException extends Exception {
    private String description ;

    public BackendException() {
        super();
        description = getDefaultDescription();

    }

    public BackendException(String detail) {
        super();
        description = description + ". "+ detail;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected abstract String getDefaultDescription();

}
