package exceptions.userExceptions;

import exceptions.UserException;

public class PlayerColorException extends UserException {

    public PlayerColorException(){
        super();
    }

    public PlayerColorException(String detail){
        super(detail);
    }


    @Override
    protected String getDefaultDescription() {
        return "El color que desea configurar es invalido";
    }
}
