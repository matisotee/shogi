package model;

public class Piece {

    private int id;
    private boolean canPromote;
    private boolean isPromoted;
    private static Integer lastID ;
    private PieceType pieceType;
    private Position currentPosition;
    private Player player;
    private PieceStatus pieceStatus;

    public Piece(PieceType pieceType, Player player) {
        if(lastID == null){
            lastID=0;
        }
        this.pieceType = pieceType;
        this.player = player;
        id=lastID;
        lastID++;
        pieceStatus = PieceStatus.ACTIVE;
        canPromote = false;
        isPromoted = false;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public PieceStatus getPieceStatus() {
        return pieceStatus;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        if(isPromoted){
            return pieceType.getPromoteTo().getName() +"*";
        }else{
            return pieceType.getName();
        }
    }


    public Player getPlayer() {
        return player;
    }
}
