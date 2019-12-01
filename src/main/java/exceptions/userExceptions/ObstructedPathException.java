package exceptions.userExceptions;

import exceptions.UserException;

public class ObstructedPathException extends UserException {

    public ObstructedPathException(){
        super();
    }

    public ObstructedPathException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "The path selected is obstructed by other piece";
    }
}
