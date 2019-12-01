package repositories;

import model.Position;
import model.Settings;

public class PositionRepository {

    private static Position positions[][] = new Position[Settings.ROWS][Settings.COLUMNS];
    private static PositionRepository instance;


    private PositionRepository(){}

    public static PositionRepository getInstance(){

        if(instance == null){
            instance = new PositionRepository();
        }

        return instance;
    }

    public void saveAllPositions(Position positions[][]){
        this.positions = positions;
    }

    public Position[][] getPositions(){
        return positions;
    }

    public Position getPositionById(int row, int column){
        return positions[row][column];
    }
}
