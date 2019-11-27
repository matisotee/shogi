package exceptions.backendExceptions;

import exceptions.BackendException;

public class NoPlayerException extends BackendException {

    public NoPlayerException(){
        super();
    }

    public NoPlayerException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "Un jugador no fue creado";
    }
}
