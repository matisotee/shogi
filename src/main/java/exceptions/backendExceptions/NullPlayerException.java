package exceptions.backendExceptions;

import exceptions.BackendException;

public class NullPlayerException extends BackendException {

    public NullPlayerException(){
        super();
    }

    public NullPlayerException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "Un jugador no fue creado";
    }
}
