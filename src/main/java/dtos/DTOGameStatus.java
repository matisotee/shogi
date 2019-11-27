package dtos;

import model.Settings;

import java.util.ArrayList;


public class DTOGameStatus {

    private boolean checkMate;
    private String winner;
    private DTOPosition positions[][] = new DTOPosition[Settings.ROWS][Settings.COLUMNS];
    private ArrayList<DTOPlayerStatus> players = new ArrayList<DTOPlayerStatus>();
    private ArrayList<DTOMovementStatus> movements = new ArrayList<>();

    public DTOGameStatus(){
        winner = null;
        checkMate = false;
    }


    public boolean isCheckMate() {
        return checkMate;
    }


    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
        checkMate=true;
    }

    public DTOPosition[][] getPositions() {
        return positions;
    }

    public void setPositions(DTOPosition[][] positions) {
        this.positions = positions;
    }

    public void addPlayer(DTOPlayerStatus dto){
        players.add(dto);
    }

    public ArrayList<DTOPlayerStatus> getPlayers() {
        return players;
    }

    public void setMovements(ArrayList<DTOMovementStatus> movements) {
        this.movements = movements;
    }

    public ArrayList<DTOMovementStatus> getMovements() {
        return movements;
    }

    public void addMovement(DTOMovementStatus dto){
        movements.add(dto);
    }
}
