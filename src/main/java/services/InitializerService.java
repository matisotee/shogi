package services;

import dtos.DTOPlayer;
import dtos.DTOPlayerColor;
import model.*;
import repositories.PieceRepository;
import repositories.PlayerRepository;
import repositories.PositionRepository;
import services.factories.PieceFactory;

import java.util.Set;

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

    public void startGame(DTOPlayer dtoPlayer1, DTOPlayer dtoPlayer2) throws Exception{

        //Players creation
        Player player1 = new Player(dtoPlayer1);
        Player player2 = new Player(dtoPlayer2);

        PlayerRepository playerRepository = PlayerRepository.getInstance();
        playerRepository.savePlayer1(player1);
        playerRepository.savePlayer2(player2);

        Position positions[][] = new Position[Settings.ROWS][Settings.COLUMNS];

        for (int i = 0; i < Settings.ROWS ; i++) {
            for (int j = 0; j < Settings.COLUMNS; j++) {

                positions[i][j] = new Position(i,j);

                PieceFactory pieceFactory = PieceFactory.getInstance();
                Piece currentPiece = pieceFactory.createPiece(i,j,player1,player2);

                if(currentPiece != null){
                    positions[i][j].setPiece(currentPiece);
                    currentPiece.setCurrentPosition(positions[i][j]);
                    PieceRepository pieceRepository = PieceRepository.getInstance();
                    pieceRepository.savePiece(currentPiece);
                }
            }
        }

        PositionRepository positionRepository = PositionRepository.getInstance();
        positionRepository.saveAllPositions(positions);
    }

}
