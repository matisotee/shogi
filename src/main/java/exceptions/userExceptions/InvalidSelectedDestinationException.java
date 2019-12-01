package exceptions.userExceptions;

import exceptions.UserException;

public class InvalidSelectedDestinationException extends UserException {

    public InvalidSelectedDestinationException(){
        super();
    }

    public InvalidSelectedDestinationException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "The selected destination is invalid";
    }
}
