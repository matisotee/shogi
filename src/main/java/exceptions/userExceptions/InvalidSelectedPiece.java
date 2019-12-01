package exceptions.userExceptions;

import exceptions.UserException;

public class InvalidSelectedPiece extends UserException {

    public InvalidSelectedPiece(){
        super();
    }

    public InvalidSelectedPiece(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "YOU DON'T HAVE ANY PIECE WITH THE ID SELECTED";
    }
}
