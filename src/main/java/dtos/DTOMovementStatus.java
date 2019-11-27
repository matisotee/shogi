package dtos;

public class DTOMovementStatus {

    private int columnFrom;
    private int rowFrom;
    private int columnTo;
    private int rowTo;
    private boolean isPromote;
    private int order;
    private String piece;
    private String player;
    private String promotedPiece;

    public int getColumnFrom() {
        return columnFrom;
    }

    public void setColumnFrom(int columnFrom) {
        this.columnFrom = columnFrom;
    }

    public int getRowFrom() {
        return rowFrom;
    }

    public void setRowFrom(int rowFrom) {
        this.rowFrom = rowFrom;
    }

    public int getColumnTo() {
        return columnTo;
    }

    public void setColumnTo(int columnTo) {
        this.columnTo = columnTo;
    }

    public int getRowTo() {
        return rowTo;
    }

    public void setRowTo(int rowTo) {
        this.rowTo = rowTo;
    }

    public boolean isPromote() {
        return isPromote;
    }

    public void setPromote(boolean promote) {
        isPromote = promote;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPromotedPiece() {
        return promotedPiece;
    }

    public void setPromotedPiece(String promotedPiece) {
        this.promotedPiece = promotedPiece;
    }
}
