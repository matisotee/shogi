package exceptions;

public class ExceptionHandler {

    public ErrorMessage handleException(Exception e) throws Exception{

        if(e instanceof UserException){
            return new ErrorMessage((UserException) e);
        }else{
            throw e;
        }
    }
}
