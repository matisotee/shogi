package frontend;

import dtos.DTOPlayer;
import dtos.DTOPlayerColor;
import exceptions.ErrorMessage;
import exceptions.ExceptionHandler;
import services.InitializerService;

import java.util.Scanner;

public class Console {
    //create scanner instance to read from the console
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        initializeGame();

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
}
