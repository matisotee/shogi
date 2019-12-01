package exceptions.userExceptions;

import exceptions.UserException;

public class InvalidPromotionException extends UserException {

    public InvalidPromotionException(){
        super();
    }

    public InvalidPromotionException(String detail){
        super(detail);
    }


    @Override
    protected String getDefaultDescription() {
        return "This piece can't be promoted";
    }
}
