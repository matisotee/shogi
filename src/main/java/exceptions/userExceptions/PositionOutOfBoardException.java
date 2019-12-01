package exceptions.userExceptions;

import exceptions.UserException;

public class PositionOutOfBoardException extends UserException {

    public PositionOutOfBoardException(){
        super();
    }

    public PositionOutOfBoardException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "THE POSITION SELECTED IS OUT OF THE BOARD";
    }
}
