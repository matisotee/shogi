package model;

public class Movement {

    private boolean isCapture;
    private boolean isPromotion;
    private Position positionFrom;
    private Position positionTo;
    private Turn turn;
    private PieceType pieceMoved;
    private PieceType pieceCaptured;


    public Movement(Position positionFrom, Position positionTo, PieceType pieceMoved) {
        this.positionFrom = positionFrom;
        this.positionTo = positionTo;
        this.pieceMoved = pieceMoved;
    }

    public Position getPositionFrom() {
        return positionFrom;
    }

    public Position getPositionTo() {
        return positionTo;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public int getOrder(){
        return turn.getOrder();
    }

    public String getPieceMovedName(){
        return pieceMoved.getName();
    }

    public String getPiecePromotedName(){
        if(isPromotion && (pieceMoved.getPromoteTo() != null)){
            return pieceMoved.getPromoteTo().getName();
        }else{
            return "";
        }
    }

    public String getPlayerName(){
        return turn.getPlayerName();
    }

    public void setPieceCaptured(PieceType pieceCaptured) {
        this.pieceCaptured = pieceCaptured;
        isCapture = true;
    }

    public PieceType getPieceCaptured() {
        return pieceCaptured;
    }

    public boolean isCapture() {
        return isCapture;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
}
