package frontend;

import dtos.DTOPlayerColor;
import services.InitializerService;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //create scanner instance to read from the console


        initializeGame();

    }


    private static void initializeGame(){



        //welcome text
        System.out.println(Text.INTRODUCIONG_TEXT);

        //create service instace
        InitializerService service = new InitializerService();

        //get player names
        DTOPlayerColor dtoPlayerColor = service.configPlayers();

        System.out.print(Text.PLAYER_CONFIG_TEXT + dtoPlayerColor.getPlayer1() +": ");
        String namePlayer1 = scanner.nextLine();

        System.out.print(Text.PLAYER_CONFIG_TEXT + dtoPlayerColor.getPlayer2() +": ");
        String namePlayer2 = scanner.nextLine();



    }
}
