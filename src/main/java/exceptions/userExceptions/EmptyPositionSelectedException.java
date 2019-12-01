package exceptions.userExceptions;

import exceptions.UserException;

public class EmptyPositionSelectedException  extends UserException{

    public EmptyPositionSelectedException(){
        super();
    }

    public EmptyPositionSelectedException(String detail){
        super(detail);
    }



    @Override
    protected String getDefaultDescription() {
        return "There are no pieces in that position";
    }
}
