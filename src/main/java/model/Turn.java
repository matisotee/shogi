package model;

import exceptions.backendExceptions.NullPlayerException;

public class Turn {

    private static Integer lastOrder;
    private int order;
    private Movement movement;
    private Player player;


    public Turn(Player p) throws Exception{

        if(p.equals(null)){
            throw new NullPlayerException();
        }
        player = p;
        if (lastOrder == null){
            lastOrder=0;
        }
        lastOrder++;
        order = lastOrder;
    }

    public int getOrder() {
        return order;
    }

    public Player getPlayer() {
        return player;
    }

    public String getPlayerName(){
        return player.getName();
    }

    public boolean turnBelongTo(Player player){
        if(this.player.equals(player)){
            return true;
        }else{
            return false;
        }
    }
}
