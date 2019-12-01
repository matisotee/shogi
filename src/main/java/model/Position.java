package model;

import exceptions.backendExceptions.PositionCreationInvalidException;
import exceptions.backendExceptions.PositionStatusUndefinedException;

public class Position {

    private int row;
    private int column;
    private PositionStatus status;
    private Piece piece;

    public Position(int row, int column) throws Exception{

        checkIfValidPosition(row,column);

        this.row = row;
        this.column = column;
        status = PositionStatus.EMPTY;
        piece = null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        status = PositionStatus.FULL;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setEmptyStatus(){
        status = PositionStatus.EMPTY;
    }

    public boolean isFull() throws Exception{
        if(status.equals(PositionStatus.EMPTY)){
            return false;
        }else if (status.equals(PositionStatus.FULL)){
            return true;
        }else{
            throw new PositionStatusUndefinedException();
        }
    }


    public boolean isOccupiedBy(Player player){
        if(piece == null){
            return false;
        }

        if (player.equals(piece.getPlayer())){
            return true;
        }else {
            return false;
        }
    }

    public static void checkIfValidPosition(int row, int column) throws Exception{

        if( row < 0 || column < 0 || row > Settings.ROWS || column > Settings.COLUMNS){
            throw new PositionCreationInvalidException();
        }

    }
}
