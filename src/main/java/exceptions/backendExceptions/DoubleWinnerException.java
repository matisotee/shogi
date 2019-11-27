package exceptions.backendExceptions;

import exceptions.BackendException;

public class DoubleWinnerException extends BackendException {

    public DoubleWinnerException(){
        super();
    }

    public DoubleWinnerException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "There are 2 winners";
    }
}
