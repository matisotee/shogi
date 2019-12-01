package services.strategies.moveStrategy;

import exceptions.userExceptions.InvalidSelectedDestinationException;
import exceptions.userExceptions.ObstructedPathException;
import model.Piece;
import model.Player;
import model.PlayerColor;
import model.Position;

public class KingMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateDestination(Piece piece, Position position) throws InvalidSelectedDestinationException {
        int rowFrom = piece.getCurrentPosition().getRow();
        int columnFrom = piece.getCurrentPosition().getColumn();
        int rowTo = position.getRow();
        int columnTo = position.getColumn();

        boolean straightCondition1 = (Math.abs(rowTo-rowFrom)==1) && (Math.abs(columnTo-columnFrom) ==0);
        boolean straightCondition2 = (Math.abs(rowTo-rowFrom)==0) && (Math.abs(columnTo-columnFrom) ==1);
        boolean diagonalCondition = (Math.abs(rowTo-rowFrom)==1) && (Math.abs(columnTo-columnFrom) ==1);



        if((! straightCondition1)&&(! straightCondition2)&&(! diagonalCondition)){
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
