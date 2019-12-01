package services.strategies.moveStrategy;

import exceptions.userExceptions.InvalidSelectedDestinationException;
import exceptions.userExceptions.ObstructedPathException;
import model.*;

public class KnightMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateDestination(Piece piece, Position position) throws InvalidSelectedDestinationException {
        int rowFrom = piece.getCurrentPosition().getRow();
        int columnFrom = piece.getCurrentPosition().getColumn();
        int rowTo = position.getRow();
        int columnTo = position.getColumn();

        boolean straightCondition = false;

        if(piece.getPlayer().getColor().getOrientation().equals(PlayerOrientation.DOWN)){
            straightCondition = (rowTo == rowFrom+2) && (Math.abs(columnTo-columnFrom)==1);
        }

        if(piece.getPlayer().getColor().getOrientation().equals(PlayerOrientation.UP)){
            straightCondition = (rowTo == rowFrom-2) && (Math.abs(columnTo-columnFrom)==1);
        }

        if(! straightCondition){
            throw new InvalidSelectedDestinationException();
        }

        Player player = piece.getPlayer();

        if( position.isOccupiedBy(player)){
            throw  new InvalidSelectedDestinationException();
        }

        return true;
    }

    @Override
    public boolean validatePath(Position positionFrom, Position positionTo) throws ObstructedPathException, Exception {
        return true;
    }
}
