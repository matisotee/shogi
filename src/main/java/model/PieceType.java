package model;

public enum PieceType {
    KING("K",false,null),
    PROMOTED_BISHOP("B",false,null),
    PROMOTED_ROOK("R",false,null),
    GOLD_GENERAL("GG",false,null),
    LANCE("L",true,GOLD_GENERAL),
    KNIGHT("KN",true,GOLD_GENERAL),
    SILVER_GENERAL("SG",false,GOLD_GENERAL),
    BISHOP("B",false,PROMOTED_BISHOP),
    ROOK("R",false,PROMOTED_ROOK),
    PAWN("P",false,GOLD_GENERAL);

    private String name;
    private boolean rowLimited;
    private PieceType promoteTo;

    PieceType(String name, boolean rowLimited, PieceType promoteTo) {
        this.name = name;
        this.rowLimited = rowLimited;
        this.promoteTo = promoteTo;
    }

    public String getName() {
        return name;
    }

    public boolean isRowLimited() {
        return rowLimited;
    }

    public PieceType getPromoteTo() {
        return promoteTo;
    }

}
