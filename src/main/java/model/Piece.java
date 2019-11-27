package model;

public class Piece {

    private int id;
    private boolean canPromote;
    private boolean isPromoted;
    private static int lastID =0;
    private PieceType pieceType;
    private Position currentPosition;
    private Player player;
    private PieceStatus pieceStatus;

    public Piece(PieceType pieceType, Player player) {
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
}
