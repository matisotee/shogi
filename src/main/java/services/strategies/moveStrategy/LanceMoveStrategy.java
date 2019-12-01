package services.strategies.moveStrategy;

import exceptions.userExceptions.InvalidSelectedDestinationException;
import exceptions.userExceptions.ObstructedPathException;
import model.*;
import repositories.PositionRepository;

public class LanceMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateDestination(Piece piece, Position position) throws InvalidSelectedDestinationException {
        int rowFrom = piece.getCurrentPosition().getRow();
        int columnFrom = piece.getCurrentPosition().getColumn();
        int rowTo = position.getRow();
        int columnTo = position.getColumn();

        boolean straightCondition = false;

        if(piece.getPlayer().getColor().getOrientation().equals(PlayerOrientation.UP)){
            straightCondition = ((rowTo-rowFrom)<0) && ((columnTo-columnFrom) == 0);
        }

        if(piece.getPlayer().getColor().getOrientation().equals(PlayerOrientation.DOWN)){
            straightCondition = ((rowTo-rowFrom)>0) && ((columnTo-columnFrom) == 0);
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
        int rowFrom = positionFrom.getRow();
        int columnFrom = positionFrom.getColumn();
        int rowTo = positionTo.getRow();
        int columnTo = positionTo.getColumn();

        PositionRepository positionRepository = PositionRepository.getInstance();

        int path = 0;

        if(Math.abs(rowTo-rowFrom) > 0){
            path = Math.abs(rowTo-rowFrom) - 1;
        }


        while (path > 0){

            if((rowTo-rowFrom) > 0){
                rowFrom++;
            }

            if((rowTo-rowFrom) < 0){
                rowFrom--;
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
