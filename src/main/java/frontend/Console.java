package frontend;

import dtos.*;
import exceptions.ErrorMessage;
import exceptions.ExceptionHandler;
import services.InitializerService;
import services.StatusService;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    //create scanner instance to read from the console
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        initializeGame();
        checkGameStatus();
        nextTurn();

    }


    private static void initializeGame() throws Exception{



        //welcome text
        System.out.println(Text.INTRODUCIONG_TEXT);

        //create service instace
        InitializerService initializerService = new InitializerService();

        //get player names
        DTOPlayerColor dtoPlayerColor = initializerService.configPlayers();

        String colorPlayer1 = dtoPlayerColor.getPlayer1();
        String colorPlayer2 = dtoPlayerColor.getPlayer2();

        System.out.print(Text.PLAYER_TEXT + colorPlayer1 + Text.NAME_TEXT+": ");
        String namePlayer1 = scanner.nextLine();

        System.out.print(Text.PLAYER_TEXT + colorPlayer2 + Text.NAME_TEXT+": ");
        String namePlayer2 = scanner.nextLine();

        DTOPlayer dtoPlayer1 = new DTOPlayer(colorPlayer1,namePlayer1);
        DTOPlayer dtoPlayer2 = new DTOPlayer(colorPlayer2,namePlayer2);

        try {
            initializerService.startGame(dtoPlayer1,dtoPlayer2);
        }catch (Exception e){
            ExceptionHandler handler = new ExceptionHandler();
            ErrorMessage msg = handler.handleException(e);
            System.out.println(msg);
            System.out.println(Text.RESTART_MESSAGE);
            initializeGame();
        }
    }

    private static void checkGameStatus() throws Exception{

        StatusService statusService = new StatusService();

        DTOGameStatus dtoGameStatus = statusService.getGameStatus();

        if(dtoGameStatus.isCheckMate()){
            System.out.println(Text.WINNER_TEXT + dtoGameStatus.getWinner());
            return;
        }

        DTOPosition positions[][] = dtoGameStatus.getPositions();

        System.out.println("    0     1     2     3     4     5     6     7     8  ");
        System.out.println(" +-----|-----|-----|-----|-----|-----|-----|-----|-----+");
        for (int i = 0; i < 9; i++) {
            System.out.print(""+i+"|");
            for (int j = 0; j < 9; j++) {
                String pos = positions[i][j].getPiece();
                pos = " "+pos;
                while (pos.length() < 5){
                    pos=pos+" ";
                }
                System.out.print(pos+"|");
            }
            System.out.println("");
            System.out.println(" |-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
        System.out.println();

        ArrayList<DTOPlayerStatus> dtosPlayerStatus = dtoGameStatus.getPlayers();
        for(DTOPlayerStatus dtoPlayer : dtosPlayerStatus){
            System.out.println(dtoPlayer.toString());
            System.out.println(dtoPlayer.getPiecesOut());
            System.out.println();

        }

    }

    private static void nextTurn() throws Exception{


        StatusService statusService = new StatusService();

        DTOTurn dto = statusService.getNextTurn();

        System.out.println(Text.TURN_TEXT + dto.toString() + Text.TURN_TEXT2);
    }


}
