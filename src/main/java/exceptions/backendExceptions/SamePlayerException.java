package exceptions.backendExceptions;

import exceptions.BackendException;

public class SamePlayerException extends BackendException {

    public SamePlayerException(){
        super();
    }

    public SamePlayerException(String detail){
        super(detail);
    }

    @Override
    protected String getDefaultDescription() {
        return "Ambos jugadores son identicos";
    }
}
