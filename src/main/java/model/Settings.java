package model;

public class Settings {

    public static final int ROWS = 9;
    public static final int COLUMNS = 9;
    private static final InitPiecePosition piecePositions[][] = new InitPiecePosition[ROWS][COLUMNS];

    public static InitPiecePosition[][] getPiecePositions(){
        if(piecePositions == null){
            //Player1 positions
            piecePositions[0][0] = new InitPiecePosition(PieceType.LANCE,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][1] = new InitPiecePosition(PieceType.KNIGHT,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][2] = new InitPiecePosition(PieceType.SILVER_GENERAL,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][3] = new InitPiecePosition(PieceType.GOLD_GENERAL,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][4] = new InitPiecePosition(PieceType.KING,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][5] = new InitPiecePosition(PieceType.GOLD_GENERAL,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][6] = new InitPiecePosition(PieceType.SILVER_GENERAL,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[0][7] = new InitPiecePosition(PieceType.KNIGHT,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[1][8] = new InitPiecePosition(PieceType.LANCE,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[1][1] = new InitPiecePosition(PieceType.BISHOP,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[1][7] = new InitPiecePosition(PieceType.ROOK,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][0] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][1] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][2] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][3] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][4] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][5] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][6] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][7] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);
            piecePositions[2][8] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_FIRST_PLAYER);

            //Player1 positions
            piecePositions[8][0] = new InitPiecePosition(PieceType.LANCE,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][1] = new InitPiecePosition(PieceType.KNIGHT,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][2] = new InitPiecePosition(PieceType.SILVER_GENERAL,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][3] = new InitPiecePosition(PieceType.GOLD_GENERAL,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][4] = new InitPiecePosition(PieceType.KING,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][5] = new InitPiecePosition(PieceType.GOLD_GENERAL,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][6] = new InitPiecePosition(PieceType.SILVER_GENERAL,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][7] = new InitPiecePosition(PieceType.KNIGHT,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[8][8] = new InitPiecePosition(PieceType.LANCE,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[7][1] = new InitPiecePosition(PieceType.ROOK,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[7][7] = new InitPiecePosition(PieceType.BISHOP,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][0] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][1] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][2] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][3] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][4] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][5] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][6] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][7] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);
            piecePositions[6][8] = new InitPiecePosition(PieceType.PAWN,PlayerColor.COLOR_SECOND_PLAYER);

        }

        return piecePositions;
    }
}
