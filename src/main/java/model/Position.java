package model;

import exceptions.backendExceptions.PositionCreationInvalidException;

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
    }

    public static void checkIfValidPosition(int row, int column) throws Exception{

        if( row < 0 || column < 0 || row > Settings.ROWS || column > Settings.COLUMNS){
            throw new PositionCreationInvalidException();
        }

    }
}
