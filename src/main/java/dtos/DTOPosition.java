package dtos;

public class DTOPosition {

    private int row;
    private int column;
    private boolean isFull;
    private String piece;
    private int playerOrder;
    private String direction;

    public DTOPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public String getPiece() {
        if (piece == null && (!isFull)){
            return "";
        }
        if(playerOrder == 1){
            return piece+direction;
        }else if(playerOrder == 2){
            return piece+direction;
        }else {
            return piece;
        }
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public int getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
