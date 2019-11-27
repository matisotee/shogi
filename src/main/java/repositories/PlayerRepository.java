package repositories;

import model.Player;

public class PlayerRepository {

    private static PlayerRepository instance;
    private Player player1;
    private Player player2;

    private PlayerRepository(){}

    public static PlayerRepository getInstance(){

        if(instance == null){
            instance = new PlayerRepository();
        }

        return instance;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void savePlayer1(Player p) throws Exception{

        if(p == null){
            throw new NullPointerException();
        }

        player1 = p;
    }

    public void savePlayer2(Player p){

        if(p == null){
            throw new NullPointerException();
        }
        player2 = p;
    }
}
