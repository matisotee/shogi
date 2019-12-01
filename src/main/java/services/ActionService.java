package services;

import dtos.DTOMovementInfo;
import exceptions.backendExceptions.InvalidPieceToPromoteException;
import exceptions.userExceptions.*;
import model.*;
import repositories.MovementRepository;
import repositories.PieceRepository;
import repositories.PositionRepository;
import repositories.TurnRepository;

public class ActionService {

    public DTOMovementInfo movePiece(int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{

        if( (rowFrom < 0) || (rowFrom > Settings.ROWS) ){
            throw new PositionOutOfBoardException("Row : "+rowFrom);
        }

        if( (rowTo< 0) || (rowTo > Settings.ROWS) ){
            throw new PositionOutOfBoardException("Row : "+rowTo);
        }

        if( (columnFrom < 0) || (columnFrom > Settings.COLUMNS) ){
            throw new PositionOutOfBoardException("Column : "+columnFrom);
        }

        if( (columnTo < 0) || (columnTo > Settings.COLUMNS) ){
            throw new PositionOutOfBoardException("Column : "+columnTo);
        }

        TurnRepository turnRepository = TurnRepository.getInstance();
        Turn lastTurn = turnRepository.getLastTurn();

        PositionRepository positionRepository = PositionRepository.getInstance();
        Position positionFrom = positionRepository.getPositionById(rowFrom,columnFrom);

        if( ! positionFrom.isFull()){
            throw new EmptyPositionSelectedException();
        }

        Player currentPlayer = lastTurn.getPlayer();

        if(! positionFrom.isOccupiedBy(currentPlayer)){
            throw new RivalPositionSelectedException();
        }

        Piece movedPiece = positionFrom.getPiece();

        Position positionTo = positionRepository.getPositionById(rowTo,columnTo);

        Movement movement = movedPiece.moveTo(positionTo);

        movedPiece.checkIfCanPromote();

        boolean wasPromotion = movedPiece.promoteIfShould();

        if(wasPromotion){
            movement.setPromotion(true);
        }

        lastTurn.setMovement(movement);
        movement.setTurn(lastTurn);

        MovementRepository movementRepository = MovementRepository.getInstance();
        movementRepository.saveMovement(movement);


        DTOMovementInfo dto = new DTOMovementInfo();

        dto.setPieceMovedId(movedPiece.getId());

        dto.setCapture(movement.isCapture());
        PieceType pieceCaptured = movement.getPieceCaptured();

        if(pieceCaptured != null){
            dto.setPieceCaptured(pieceCaptured.getName());
        }

        if((pieceCaptured != null) && (pieceCaptured.equals(PieceType.KING)) ){
            dto.setCheckMate(true);
        }


        dto.setCanPromote(movedPiece.getCanPromote());


        return dto;


    }

    public void promote(int pieceID) throws Exception{

        PieceRepository pieceRepository = PieceRepository.getInstance();
        Piece piece = pieceRepository.getPieceById(pieceID);

        if(piece == null){
            throw new InvalidSelectedPiece();
        }

        MovementRepository movementRepository = MovementRepository.getInstance();
        Movement lastMovement = movementRepository.getLastMovement();
        Position lastMovementPosition = lastMovement.getPositionTo();

        Position piecePosition = piece.getCurrentPosition();

        if(! lastMovementPosition.equals(piecePosition)){
            throw new InvalidPieceToPromoteException();
        }

        piece.promote();
    }

}
