package dtos;

public class DTOPieceOut {

    private int id;
    private String piece;

    public DTOPieceOut(int id, String piece) {
        this.id = id;
        this.piece = piece;
    }

    public int getId() {
        return id;
    }

    public String getPiece() {
        return piece;
    }
}
