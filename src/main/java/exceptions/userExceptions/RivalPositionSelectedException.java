package exceptions.userExceptions;

import exceptions.UserException;

public class RivalPositionSelectedException extends UserException {

    public RivalPositionSelectedException(){
        super();
    }

    public RivalPositionSelectedException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "There is a rival piece in the position selected";
    }
}
