package model;

import dtos.DTOPlayer;
import exceptions.backendExceptions.SamePlayerException;
import exceptions.userExceptions.PlayerColorException;

import java.util.ArrayList;

public class Player {

    private boolean isWinner;
    private String name;
    private PlayerColor color;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Player(DTOPlayer dto) throws PlayerColorException {

        PlayerColor firstPlayer = PlayerColor.COLOR_FIRST_PLAYER;
        PlayerColor secondPlayer = PlayerColor.COLOR_SECOND_PLAYER;

        if( ( ! dto.getColor().equals( firstPlayer.getColor()) ) && (! dto.getColor().equals( secondPlayer.getColor()) ) ){
            throw new PlayerColorException(dto.getColor());
        }

        if( dto.getColor().equals( firstPlayer.getColor()) ){
            this.name = dto.getName();
            color = firstPlayer;
        }

        if( dto.getColor().equals( secondPlayer.getColor()) ){
            this.name = dto.getName();
            color = secondPlayer;
        }
    }

    public ArrayList<Piece> getInactivePieces(){
        ArrayList<Piece> inactivePieces = new ArrayList<>();
        for (Piece p : pieces){
            if(p.getPieceStatus().equals(PieceStatus.INACTIVE)){
                inactivePieces.add(p);
            }
        }
        return inactivePieces;
    }

    public static void validatePlayers(Player p1, Player p2) throws Exception{

        if( (p1.color.equals(PlayerColor.COLOR_FIRST_PLAYER)) && (p2.color.equals(PlayerColor.COLOR_FIRST_PLAYER)) ){
            throw new SamePlayerException();
        }

        if( (p1.color.equals(PlayerColor.COLOR_SECOND_PLAYER)) && (p2.color.equals(PlayerColor.COLOR_SECOND_PLAYER)) ){
            throw new SamePlayerException();
        }

    }

    public boolean isWinner(){
        return isWinner;
    }

    public void setWinner(){
        isWinner = true;
    }

    public String getName(){
        return name;
    }
    public PlayerColor getColor() {
        return color;
    }

    public void addPiece(Piece piece){
        pieces.add(piece);
    }

    public void removePiece(Piece piece){
        pieces.remove(piece);
    }

    public String getColorName(){
        return color.getColor();
    }

    public int getPlayerOrder(){
        return color.getOrder();
    }

}
