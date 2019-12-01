package dtos;

public class DTOMovementInfo {

    private boolean canPromote;
    private boolean isCapture;
    private String pieceCaptured;
    private boolean isCheckMate;
    private int pieceMovedId;



    public boolean isCanPromote() {
        return canPromote;
    }

    public void setCanPromote(boolean canPromote) {
        this.canPromote = canPromote;
    }

    public boolean isCapture() {
        return isCapture;
    }

    public void setCapture(boolean capture) {
        isCapture = capture;
    }

    public String getPieceCaptured() {
        return pieceCaptured;
    }

    public void setPieceCaptured(String pieceCaptured) {
        this.pieceCaptured = pieceCaptured;
    }

    public boolean isCheckMate() {
        return isCheckMate;
    }

    public void setCheckMate(boolean checkMate) {
        isCheckMate = checkMate;
    }

    public int getPieceMovedId() {
        return pieceMovedId;
    }

    public void setPieceMovedId(int pieceMovedId) {
        this.pieceMovedId = pieceMovedId;
    }
}
