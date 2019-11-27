package exceptions.backendExceptions;

import exceptions.BackendException;

public class PositionCreationInvalidException extends BackendException {

    public PositionCreationInvalidException(){
        super();
    }

    public PositionCreationInvalidException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "Se intento crear una posicion invalida";
    }
}
