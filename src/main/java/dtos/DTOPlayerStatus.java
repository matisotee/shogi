package dtos;

import java.util.ArrayList;

public class DTOPlayerStatus {

    private String color;
    private String name;
    private int order;
    private ArrayList<DTOPieceOut> piecesOut = new ArrayList<>();

    public DTOPlayerStatus(String color, String name, int order) {
        this.color = color;
        this.name = name;
        this.order = order;
    }

    public void addPieceOut(DTOPieceOut dto){
        piecesOut.add(dto);
    }

    public String getColor() {
        if(order == 1){
            color = color + " V";
        }
        if(order == 2){
            color = color + " Λ";
        }
        return color;
    }

    public String getName() {
        return name;
    }

    public String getPiecesOut() {
        String listOfPieces = null;
        for(DTOPieceOut dto : piecesOut){

            if (listOfPieces == null){
                listOfPieces = dto.getPiece() +" ("+dto.getId()+")";
            }else {
                listOfPieces = ", "+dto.getPiece() +" ("+dto.getId()+")";
            }


        }
        if(listOfPieces == null){
            listOfPieces="0";
        }
        return listOfPieces;
    }

    @Override
    public String toString() {
        return getName() + " ("+getColor()+") pieces to insert:";
    }
}
