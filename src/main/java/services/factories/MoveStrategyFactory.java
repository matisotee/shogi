package services.factories;

import model.Piece;
import services.strategies.moveStrategy.*;

public class MoveStrategyFactory {

    private static MoveStrategyFactory instance;

    private MoveStrategyFactory(){}

    public static MoveStrategyFactory getInstance(){

        if(instance == null){
            instance = new MoveStrategyFactory();
        }

        return instance;
    }

    public MoveStrategy getMoveStrategy(Piece piece){

        MoveStrategy strategy;

        switch (piece.getType()){

            case PAWN:
                strategy = new PawnMoveStrategy();
                break;
            case BISHOP:
                strategy = new BishopMoveStrategy();
                break;
            case PROMOTED_BISHOP:
                strategy = new PromotedBishopMoveStrategy();
                break;
            case ROOK:
                strategy = new RookMoveStrategy();
                break;
            case PROMOTED_ROOK:
                strategy = new PromotedRookMoveStrategy();
                break;
            case LANCE:
                strategy = new LanceMoveStrategy();
                break;
            case KNIGHT:
                strategy = new KnightMoveStrategy();
                break;
            case SILVER_GENERAL:
                strategy = new SilverGeneralMoveStrategy();
                break;
            case GOLD_GENERAL:
                strategy = new GoldGeneralMoveStrategy();
                break;
            case KING:
                strategy = new KingMoveStrategy();
                break;
            default:
                strategy = null;
        }
        return strategy;
    }
}
