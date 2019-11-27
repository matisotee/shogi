package model;

public enum PlayerColor {

    COLOR_FIRST_PLAYER(1,"White", "V",6),
    COLOR_SECOND_PLAYER(2,"Black", "Λ",2);

    private final int order;
    private final String color;
    private final String direction;
    private final int minimumRowToPromote;

    private PlayerColor(int order, String color,String direction, int minimumRowToPromote) {
        this.order = order;
        this.color = color;
        this.direction= direction;
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

    public String getDirection() {
        return direction;
    }
}
