package frontend;

import dtos.*;
import exceptions.ErrorMessage;
import exceptions.ExceptionHandler;
import services.ActionService;
import services.InitializerService;
import services.StatusService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    //create scanner instance to read from the console
    static Scanner scanner = new Scanner(System.in);
    static boolean wasCheckMate = false;

    public static void main(String[] args) throws Exception {

        while (true) {
            try {
                initializeGame();
                break;
            }catch (Exception e){
                ExceptionHandler handler = new ExceptionHandler();
                ErrorMessage msg = handler.handleException(e);
                System.out.println(msg.getMessage());
            }
        }


        boolean wasCheckMate = false;

        do {
            wasCheckMate = checkGameStatus();
            if(wasCheckMate){
                break;
            }
            nextTurn();
            while (true) {
                try {
                    move();
                    break;
                } catch (Exception e) {
                    ExceptionHandler handler = new ExceptionHandler();
                    ErrorMessage msg = handler.handleException(e);
                    System.out.println(msg.getMessage());

                }
            }

        }while (! wasCheckMate );


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

        initializerService.startGame(dtoPlayer1,dtoPlayer2);

    }

    private static boolean checkGameStatus() throws Exception{

        StatusService statusService = new StatusService();

        DTOGameStatus dtoGameStatus = statusService.getGameStatus();

        boolean isCheckMate = false;

        if(dtoGameStatus.isCheckMate()){
            System.out.println(Text.WINNER_TEXT + dtoGameStatus.getWinner());
            isCheckMate = true;
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
        return isCheckMate;
    }

    private static void nextTurn() throws Exception{


        StatusService statusService = new StatusService();

        DTOTurn dto = statusService.getNextTurn();

        System.out.println(Text.TURN_TEXT + dto.toString() + Text.TURN_TEXT2);


    }

    private static void move()throws Exception{

        System.out.println(Text.MOVE_TEXT_FROM);

        int rowFrom = 0;
        int columnFrom= 0;
        int rowTo= 0;
        int columnTo= 0;



        while (true){
            try {
                System.out.print(Text.MOVE_TEXT1);
                rowFrom = Integer.parseInt(scanner.nextLine());
                System.out.print(Text.MOVE_TEXT2);
                columnFrom = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println(Text.INPUT_MISMATCH);
            }
        }

        System.out.println(Text.MOVE_TEXT_TO);

        while (true){
            try {
                System.out.print(Text.MOVE_TEXT1);
                rowTo = Integer.parseInt(scanner.nextLine());
                System.out.print(Text.MOVE_TEXT2);
                columnTo = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println(Text.INPUT_MISMATCH);
            }
        }


        ActionService actionService = new ActionService();

        DTOMovementInfo dto = actionService.movePiece(rowFrom,columnFrom,rowTo,columnTo);

        if (dto.isCapture()){
            System.out.println(Text.CAPTURE_TEXT + dto.getPieceCaptured());
        }

        if(dto.isCheckMate()){
            return;
        }

        if(dto.isCanPromote()){
            while (true){
                System.out.println(Text.PROMOTE_TEXT);
                String decision= scanner.nextLine();

                if(decision.equals("Y") || decision.equals("y")){
                    actionService.promote(dto.getPieceMovedId());
                    break;
                }

                if(decision.equals("N") || decision.equals("n")){
                    break;
                }

                System.out.println(Text.INVALID_PROMOTE_DECISION);
            }
        }
    }




}
