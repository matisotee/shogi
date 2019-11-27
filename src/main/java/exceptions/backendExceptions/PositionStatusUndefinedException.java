package exceptions.backendExceptions;

import exceptions.BackendException;

public class PositionStatusUndefinedException extends BackendException {

    public PositionStatusUndefinedException(){
        super();
    }

    public PositionStatusUndefinedException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "The position status is undefined";
    }
}
