package exceptions.backendExceptions;

import exceptions.BackendException;

public class InvalidPieceToPromoteException extends BackendException {

    public InvalidPieceToPromoteException(){
        super();
    }

    public InvalidPieceToPromoteException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "the selected position does not correspond to the last piece that was moved";
    }
}
