package repositories;

import exceptions.userExceptions.InvalidSelectedPiece;
import model.Piece;

import java.util.ArrayList;

public class PieceRepository {

    private static PieceRepository instance;
    private ArrayList<Piece> pieces = new ArrayList<>();

    private PieceRepository(){}

    public static PieceRepository getInstance(){

        if(instance == null){
            instance = new PieceRepository();
        }

        return instance;
    }

    public void savePiece(Piece p){
        pieces.add(p);
    }

    public Piece getPieceById(int id){

        Piece chosenPiece = null;

        for(Piece p : pieces){
            if(p.getId() == id){
                chosenPiece = p;
                break;
            }
        }

        return chosenPiece;
    }
}
