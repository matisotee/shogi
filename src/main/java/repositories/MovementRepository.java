package repositories;

import model.Movement;

import java.util.ArrayList;

public class MovementRepository {

    private static MovementRepository instance;
    private ArrayList<Movement> movements= new ArrayList<>();

    private MovementRepository(){}

    public static MovementRepository getInstance(){

        if(instance == null){
            instance = new MovementRepository();
        }

        return instance;
    }

    public ArrayList<Movement> getAllMovements(){
        return movements;
    }

    public void saveMovement(Movement mov){
        movements.add(mov);
    }

    public Movement getLastMovement(){

        int index = movements.size() -1;
        return movements.get(index);
    }
}
