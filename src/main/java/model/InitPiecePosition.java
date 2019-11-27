package model;

public class InitPiecePosition {
    PieceType pieceType;
    PlayerColor playerColor;

    public InitPiecePosition(PieceType pieceType, PlayerColor playerColor) {
        this.pieceType = pieceType;
        this.playerColor = playerColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }
}
