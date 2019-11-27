package repositories;

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
}
