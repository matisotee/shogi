package services;

import dtos.DTOPlayerColor;
import model.PlayerColor;

public class InitializerService {

    public DTOPlayerColor configPlayers(){

        //obtaining colors
        String color1 = PlayerColor.COLOR_FIRST_PLAYER.getColor();
        String color2 = PlayerColor.COLOR_SECOND_PLAYER.getColor();

        //configuring DTO
        DTOPlayerColor dto = new DTOPlayerColor();
        dto.setPlayer1(color1);
        dto.setPlayer2(color2);

        //returning DTO
        return dto;
    }
}
