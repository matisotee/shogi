package dtos;

public class DTOTurn {

    private String playerColor;
    private String playerName;
    private String direction;
    private int order;

    public DTOTurn(String playerColor, String playerName,String direction, int order) {
        this.playerColor = playerColor;
        this.playerName = playerName;
        this.order = order;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "#"+order+" "+playerName + " ("+playerColor+" "+direction+")";
    }
}
