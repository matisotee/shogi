package model;

public class Turn {

    private static Integer lastOrder;
    private int order;
    private Movement movement;
    private Player player;

    public int getOrder() {
        return order;
    }

    public String getPlayerName(){
        return player.getName();
    }
}
