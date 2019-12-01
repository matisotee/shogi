package services.strategies.moveStrategy;

import exceptions.userExceptions.InvalidSelectedDestinationException;
import exceptions.userExceptions.ObstructedPathException;
import model.Piece;
import model.Player;
import model.Position;
import repositories.PositionRepository;

public class RookMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateDestination(Piece piece, Position position) throws InvalidSelectedDestinationException {
        int rowFrom = piece.getCurrentPosition().getRow();
        int columnFrom = piece.getCurrentPosition().getColumn();
        int rowTo = position.getRow();
        int columnTo = position.getColumn();

        boolean rowCondition = (Math.abs(rowTo-rowFrom) > 0) && (Math.abs(columnTo-columnFrom) == 0);
        boolean columnCondition = (Math.abs(rowTo-rowFrom) == 0) && (Math.abs(columnTo-columnFrom) > 0);

        if((! rowCondition) && (! columnCondition)){
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
        int rowFrom = positionFrom.getRow();
        int columnFrom = positionFrom.getColumn();
        int rowTo = positionTo.getRow();
        int columnTo = positionTo.getColumn();

        PositionRepository positionRepository = PositionRepository.getInstance();

        int path = 0;
        if(Math.abs(rowTo-rowFrom) > 0){
            path = Math.abs(rowTo-rowFrom) - 1;
        }

        if(Math.abs(columnTo-columnFrom) > 0){
            path = Math.abs(columnTo-columnFrom) - 1;
        }

        while (path > 0){

            if((rowTo-rowFrom) > 0){
                rowFrom++;
            }

            if((rowTo-rowFrom) < 0){
                rowFrom--;
            }

            if((columnTo-columnFrom) > 0){
                columnFrom++;
            }

            if ((columnTo-columnFrom) < 0){
                columnFrom--;
            }

            Position currentPosition = positionRepository.getPositionById(rowFrom,columnFrom);
            if(currentPosition.isFull()){
                throw new ObstructedPathException();
            }
            path--;
        }

        return true;
    }
}
