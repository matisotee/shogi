package services.factories;

import exceptions.backendExceptions.NoPlayerException;
import model.*;

public class PieceFactory {

    private static PieceFactory instance;

    private PieceFactory(){}

    public static PieceFactory getInstance(){

        if(instance == null){
            instance = new PieceFactory();
        }

        return instance;
    }

    public Piece createPiece(int row, int column, Player player1, Player player2) throws Exception{

        Position.checkIfValidPosition(row,column);
        Player.validatePlayers(player1,player2);


        InitPiecePosition initPiecePosition[][] = Settings.getPiecePositions();


        if(initPiecePosition[row][column] == null){
           return null;
        }

        PieceType pieceType = initPiecePosition[row][column].getPieceType();

        Piece piece;

        if(player1.getColor().equals(initPiecePosition[row][column].getPlayerColor())){
            piece = new Piece(pieceType,player1);
            player1.addPiece(piece);
        }else if(player2.getColor().equals(initPiecePosition[row][column].getPlayerColor())){
            piece = new Piece(pieceType,player2);
            player2.addPiece(piece);
        }else if(initPiecePosition[row][column].getPlayerColor() == null){
            piece = null;
        }else {
            throw new NoPlayerException();
        }

        return piece;
    }
}
