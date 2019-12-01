package model;

import exceptions.userExceptions.InvalidPromotionException;
import services.factories.MoveStrategyFactory;
import services.strategies.moveStrategy.MoveStrategy;

public class Piece {

    private int id;
    private boolean canPromote;
    private boolean isPromoted;
    private static Integer lastID ;
    private PieceType pieceType;
    private Position currentPosition;
    private Player player;
    private PieceStatus pieceStatus;

    public Piece(PieceType pieceType, Player player) {
        if(lastID == null){
            lastID=0;
        }
        this.pieceType = pieceType;
        this.player = player;
        id=lastID;
        lastID++;
        pieceStatus = PieceStatus.ACTIVE;
        canPromote = false;
        isPromoted = false;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public PieceStatus getPieceStatus() {
        return pieceStatus;
    }

    public boolean getCanPromote(){
        return canPromote;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        if(isPromoted){
            return pieceType.getPromoteTo().getName() +"*";
        }else{
            return pieceType.getName();
        }
    }

    public PieceType getType(){
        if(isPromoted){
            return pieceType.getPromoteTo();
        }else{
            return pieceType;
        }
    }


    public Player getPlayer() {
        return player;
    }

    public Movement moveTo(Position position) throws Exception{

        MoveStrategyFactory factory = MoveStrategyFactory.getInstance();
        MoveStrategy strategy = factory.getMoveStrategy(this);

        strategy.validateDestination(this,position);
        strategy.validatePath(this.currentPosition,position);

        Movement movement = new Movement(currentPosition,position,this.pieceType);

        if(position.isFull()){
            Piece enemyPiece = position.getPiece();
            enemyPiece.currentPosition = null;
            enemyPiece.canPromote = false;
            enemyPiece.isPromoted = false;
            enemyPiece.player.removePiece(enemyPiece);
            enemyPiece.player = this.player;
            this.player.addPiece(enemyPiece);
            enemyPiece.pieceStatus = PieceStatus.INACTIVE;
            movement.setPieceCaptured(enemyPiece.getType());
            if(position.getPiece().getType().equals(PieceType.KING)){
                player.setWinner();
            }

        }

        currentPosition.setPiece(null);
        currentPosition.setEmptyStatus();
        currentPosition = position;
        position.setPiece(this);


        return movement;
    }

    public boolean promoteIfShould() throws Exception{

        if(! pieceType.isRowLimited()){
            return false;
        }

        if(! canPromote){
            return false;
        }

        int row = currentPosition.getRow();
        PlayerOrientation orientation = player.getColor().getOrientation();

        if((row == 0) && (orientation.equals(PlayerOrientation.UP))){
            promote();
            return true;
        }

        if((row == 8) && (orientation.equals(PlayerOrientation.DOWN))){
            promote();
            return true;
        }

        return false;
    }

    public boolean checkIfCanPromote() {

        if (isPromoted){
            return  false;
        }

        if(canPromote){
            return true;
        }


        int row = currentPosition.getRow();

        PlayerOrientation orientation = player.getColor().getOrientation();
        int minimumRow = player.getColor().getMinimumRowToPromote();

        if ( (orientation.equals(PlayerOrientation.UP)) && (row > minimumRow )){
            return false;
        }

        if ( (orientation.equals(PlayerOrientation.DOWN)) && (row < minimumRow )){
            return false;
        }

        canPromote = true;
        return  true;
    }

    public void promote() throws Exception{
        if(canPromote == false){
            throw new InvalidPromotionException();
        }

        canPromote = false;
        isPromoted = true;
    }
}
