package repositories;

import model.Turn;

import java.util.ArrayList;

public class TurnRepository {

    private ArrayList<Turn> turns = new ArrayList<>();

    private static TurnRepository instance;


    private TurnRepository (){}

    public static TurnRepository getInstance(){

        if(instance == null){
            instance = new TurnRepository();
        }

        return instance;
    }

    public Turn getLastTurn(){
        if(turns.size() == 0){
            return null;
        }

        int index = turns.size() - 1 ;

        return turns.get(index);
    }

    public void addTurn(Turn turn){
        turns.add(turn);
    }
}
