package services.strategies.moveStrategy;

import exceptions.userExceptions.InvalidSelectedDestinationException;
import exceptions.userExceptions.ObstructedPathException;
import model.Piece;
import model.Position;

public interface MoveStrategy {

    boolean validateDestination(Piece piece, Position position) throws InvalidSelectedDestinationException;

    boolean validatePath(Position positionFrom, Position positionTo)throws ObstructedPathException,Exception ;
}
