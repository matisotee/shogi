package model;

public enum PlayerColor {

    COLOR_FIRST_PLAYER(1,"White",6),
    COLOR_SECOND_PLAYER(2,"Black",2);

    private final int order;
    private final String color;
    private final int minimumRowToPromote;

    private PlayerColor(int order, String color, int minimumRowToPromote) {
        this.order = order;
        this.color = color;
        this.minimumRowToPromote = minimumRowToPromote;
    }

    public int getOrder() {
        return order;
    }

    public String getColor() {
        return color;
    }

    public int getMinimumRowToPromote() {
        return minimumRowToPromote;
    }
}
