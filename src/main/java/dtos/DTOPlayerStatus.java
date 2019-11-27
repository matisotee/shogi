package dtos;

import java.util.ArrayList;

public class DTOPlayerStatus {

    private String color;
    private String name;
    private String direction;
    private ArrayList<DTOPieceOut> piecesOut = new ArrayList<>();

    public DTOPlayerStatus(String color, String name,String direction) {
        this.color = color;
        this.name = name;
        this.direction = direction;
    }

    public void addPieceOut(DTOPieceOut dto){
        piecesOut.add(dto);
    }

    public String getColor() {

        return color;
    }

    public String getDirection() {
        return direction;
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
        return getName() + " ("+getColor()+" "+getDirection() +") pieces to insert:";
    }
}
