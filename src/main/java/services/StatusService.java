package services;

import dtos.*;
import exceptions.backendExceptions.DoubleWinnerException;
import exceptions.backendExceptions.NullTurnException;
import exceptions.backendExceptions.SamePlayerException;
import model.*;
import repositories.MovementRepository;
import repositories.PlayerRepository;
import repositories.PositionRepository;
import repositories.TurnRepository;

import java.util.ArrayList;

public class StatusService {

    public DTOGameStatus getGameStatus() throws Exception{


        PlayerRepository playerRepository = PlayerRepository.getInstance();

        Player player1 = playerRepository.getPlayer1();
        Player player2 = playerRepository.getPlayer2();

        if(player1.isWinner() && player2.isWinner()){
            throw new DoubleWinnerException();
        }

        //obtaining general game status
        DTOGameStatus dtoGameStatus = new DTOGameStatus();

        if(player1.isWinner()){
            dtoGameStatus.setWinner(player1.getName());
        }
        if(player2.isWinner()){
            dtoGameStatus.setWinner(player2.getName());
        }

        //obtaining player status
        ArrayList<Player> players = new ArrayList<Player>(){
            {
                add(player1);
                add(player2);
            }
        };

        for (Player p : players) {

            DTOPlayerStatus dtoPlayerStatus = new DTOPlayerStatus(p.getColorName(),p.getName(),p.getColor().getDirection());
            ArrayList<Piece> inactivePieces = p.getInactivePieces();
            for(Piece piece : inactivePieces){
                DTOPieceOut dtoPieceOut = new DTOPieceOut(piece.getId(),piece.getName());
                dtoPlayerStatus.addPieceOut(dtoPieceOut);
            }

            dtoGameStatus.addPlayer(dtoPlayerStatus);
        }

        //obtaining positions status
        PositionRepository positionRepository = PositionRepository.getInstance();

        Position positions[][] = positionRepository.getPositions();

        DTOPosition dtosPosition[][] = new DTOPosition[Settings.ROWS][Settings.COLUMNS];

        for (int i = 0; i < Settings.ROWS; i++) {
            for (int j = 0; j < Settings.COLUMNS; j++) {

                dtosPosition[i][j] = new DTOPosition(i,j);
                dtosPosition[i][j].setFull(positions[i][j].isFull());
                if(positions[i][j].isFull()){
                    Piece piecePosition = positions[i][j].getPiece();
                    dtosPosition[i][j].setPiece(piecePosition.getName());
                    Player piecePlayer = piecePosition.getPlayer();
                    dtosPosition[i][j].setPlayerOrder(piecePlayer.getPlayerOrder());
                }
            }
        }

        dtoGameStatus.setPositions(dtosPosition);

        //obtaining movements status
        MovementRepository movementRepository = MovementRepository.getInstance();
        ArrayList<Movement> movements = movementRepository.getAllMovements();

        for(Movement m : movements) {
            DTOMovementStatus dtoMovementStatus = new DTOMovementStatus();
            dtoMovementStatus.setRowFrom(m.getPositionFrom().getRow());
            dtoMovementStatus.setColumnFrom(m.getPositionFrom().getColumn());
            dtoMovementStatus.setRowTo(m.getPositionTo().getRow());
            dtoMovementStatus.setColumnTo(m.getPositionTo().getColumn());
            dtoMovementStatus.setPromote(m.isPromotion());
            dtoMovementStatus.setOrder(m.getOrder());
            dtoMovementStatus.setPiece(m.getPieceMovedName());
            dtoMovementStatus.setPlayer(m.getPlayerName());
            dtoMovementStatus.setPromotedPiece(m.getPiecePromotedName());

            dtoGameStatus.addMovement(dtoMovementStatus);
        }

        return dtoGameStatus;
    }

    public DTOTurn getNextTurn ()throws Exception{

        TurnRepository turnRepository = TurnRepository.getInstance();
        Turn lastTurn = turnRepository.getLastTurn();

        PlayerRepository playerRepository = PlayerRepository.getInstance();
        Player player1 = playerRepository.getPlayer1();
        Player player2 = playerRepository.getPlayer2();

        if( player1.getColor().equals(player2.getColor()) ){
            throw new SamePlayerException();
        }

        Turn nextTurn =null;
        if(lastTurn == null && player1.getColor().equals(PlayerColor.COLOR_FIRST_PLAYER)){
            nextTurn = new Turn(player1);
        }

        if(lastTurn == null && player2.getColor().equals(PlayerColor.COLOR_FIRST_PLAYER)){
            nextTurn = new Turn(player2);
        }

        if(lastTurn != null && lastTurn.turnBelongTo(player1)){
            nextTurn = new Turn(player2);
        }

        if(lastTurn != null && lastTurn.turnBelongTo(player2)){
            nextTurn = new Turn(player1);
        }

        if(nextTurn == null){
            throw new NullTurnException();
        }

        turnRepository.addTurn(nextTurn);

        Player nextPlayer = nextTurn.getPlayer();

        DTOTurn dto = new DTOTurn(nextPlayer.getColorName(),nextPlayer.getName(),nextPlayer.getColor().getDirection(),nextTurn.getOrder());

        return dto;

    }


}
