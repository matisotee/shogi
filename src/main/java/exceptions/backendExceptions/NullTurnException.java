package exceptions.backendExceptions;

import exceptions.BackendException;

public class NullTurnException extends BackendException {

    public NullTurnException(){
        super();
    }

    public NullTurnException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "null turn created";
    }
}
