package model;
public enum PlayerColor {

    COLOR_FIRST_PLAYER(1,"White", "Λ",2,PlayerOrientation.UP),
    COLOR_SECOND_PLAYER(2,"Black", "V",6,PlayerOrientation.DOWN);

    private final int order;
    private final String color;
    private final String direction;
    private final int minimumRowToPromote;
    private final PlayerOrientation orientation;

    private PlayerColor(int order, String color,String direction, int minimumRowToPromote, PlayerOrientation orientation) {
        this.order = order;
        this.color = color;
        this.direction= direction;
        this.minimumRowToPromote = minimumRowToPromote;
        this.orientation = orientation;
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

    public PlayerOrientation getOrientation() {
        return orientation;
    }
}
