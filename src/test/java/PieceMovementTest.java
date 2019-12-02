import exceptions.userExceptions.InvalidSelectedDestinationException;
import model.Piece;
import model.PieceType;
import model.Player;
import model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import services.factories.MoveStrategyFactory;
import services.strategies.moveStrategy.MoveStrategy;

public class PieceMovementTest {

    public static MoveStrategyFactory factory;

    @BeforeAll
    public static void initializeFactory(){
        factory = MoveStrategyFactory.getInstance();
    }

    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 6, 3",
            "White, 4, 5, 7, 5",
            "White, 3, 3, 3, 7",
            "White, 5, 5, 5, 0",
            "White, 4, 4, 6, 6",
            "White, 6, 2, 7, 1",
            "White, 6, 2, 7, 3",
            "Black, 0, 3, 6, 3",
            "Black, 4, 5, 2, 5",
            "Black, 3, 3, 3, 7",
            "Black, 5, 5, 5, 0",
            "Black, 3, 3, 5, 5",
            "Black, 2, 2, 0, 0",
            "Black, 3, 4, 2, 3",
            "Black, 3, 4, 2, 5"
    })
    public void goldGeneralValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.GOLD_GENERAL;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 7, 3",
            "White, 4, 5, 5, 5",
            "White, 3, 3, 3, 4",
            "White, 5, 5, 5, 4",
            "White, 5, 5, 4, 4",
            "White, 5, 5, 4, 6",
            "Black, 8, 3, 7, 3",
            "Black, 4, 5, 5, 5",
            "Black, 3, 3, 3, 4",
            "Black, 5, 5, 5, 4",
            "Black, 5, 5, 6, 6",
            "Black, 5, 5, 6, 4",
    })

    public void goldGeneralValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.GOLD_GENERAL;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 7, 3",
            "White, 4, 5, 3, 5",
            "White, 3, 3, 3, 7",
            "White, 5, 5, 5, 0",
            "Black, 8, 3, 7, 3",
            "Black, 4, 5, 3, 5",
            "Black, 3, 3, 3, 7",
            "Black, 5, 5, 5, 0",
    })

    public void bishopValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.BISHOP;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 4",
            "White, 5, 5, 3, 7",
            "White, 3, 3, 4, 4",
            "White, 5, 5, 8, 2",
            "Black, 5, 3, 4, 2",
            "Black, 5, 3, 4, 4",
            "Black, 3, 3, 6, 6",
            "Black, 5, 5, 6, 4",
    })
    public void bishopValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.BISHOP;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 6, 3",
            "White, 4, 5, 7, 5",
            "White, 3, 3, 3, 7",
            "White, 5, 5, 5, 0",
            "White, 2, 2, 4, 4",
            "White, 7, 7, 0, 0",
            "Black, 8, 3, 6, 3",
            "Black, 4, 5, 0, 5",
            "Black, 3, 3, 3, 7",
            "Black, 5, 5, 5, 0",
            "Black, 2, 2, 4, 4",
            "Black, 7, 7, 0, 0",
    })

    public void kingValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.KING;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 4",
            "White, 5, 5, 4, 6",
            "White, 3, 3, 4, 4",
            "White, 5, 5, 6, 4",
            "White, 2, 2, 3, 2",
            "White, 2, 2, 1, 2",
            "White, 7, 6, 7, 7",
            "White, 7, 6, 7, 5",
            "Black, 5, 5, 4, 4",
            "Black, 5, 5, 4, 6",
            "Black, 3, 3, 4, 4",
            "Black, 5, 5, 6, 4",
            "Black, 2, 2, 3, 2",
            "Black, 2, 2, 1, 2",
            "Black, 7, 6, 7, 7",
            "Black, 7, 6, 7, 5",
    })

    public void kingValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.KING;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 7, 3",
            "White, 3, 5, 6, 5",
            "White, 3, 5, 5, 7",
            "White, 3, 3, 3, 7",
            "White, 5, 5, 5, 0",
            "White, 5, 5, 4, 4",
            "White, 5, 5, 4, 6",
            "Black, 8, 3, 7, 3",
            "Black, 4, 5, 0, 5",
            "Black, 3, 3, 3, 7",
            "Black, 5, 5, 5, 0",
            "Black, 5, 5, 6, 6",
            "Black, 5, 5, 6, 4",
    })

    public void knightValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.KNIGHT;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 3, 4",
            "White, 5, 5, 3, 6",
            "Black, 5, 5, 7, 6",
            "Black, 5, 5, 7, 4",

    })

    public void knightValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.KNIGHT;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }


    @ParameterizedTest
    @CsvSource({
            "White, 4, 3, 7, 3",
            "White, 3, 3, 3, 7",
            "White, 5, 5, 5, 0",
            "White, 5, 5, 6, 6",
            "White, 4, 4, 0, 0",
            "Black, 8, 3, 7, 3",
            "Black, 3, 3, 3, 7",
            "Black, 5, 5, 5, 0",
            "Black, 5, 5, 6, 6",
            "Black, 4, 4, 0, 0",
    })

    public void lanceValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.LANCE;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 0, 5",
            "White, 3, 2, 2, 2",
            "Black, 5, 5, 8, 5",
            "Black, 3, 2, 4, 2",

    })

    public void lanceValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.LANCE;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }


    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 6, 3",
            "White, 2, 5, 3, 5",
            "White, 3, 3, 3, 4",
            "White, 5, 5, 5, 0",
            "White, 5, 5, 4, 4",
            "White, 5, 5, 4, 6",
            "Black, 8, 3, 7, 3",
            "Black, 4, 5, 2, 5",
            "Black, 3, 3, 3, 4",
            "Black, 5, 5, 5, 0",
            "Black, 5, 5, 4, 4",
            "Black, 5, 5, 4, 6",
    })

    public void pawnValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.PAWN;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 5",
            "White, 3, 2, 2, 2",
            "Black, 5, 5, 6, 5",
            "Black, 3, 2, 4, 2",

    })

    public void pawnValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.PAWN;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }


    @ParameterizedTest
    @CsvSource({
            "White, 3, 3, 2, 2",
            "White, 5, 5, 3, 7",
            "White, 2, 2, 3, 3",
            "White, 3, 7, 5, 5",
            "Black, 3, 3, 2, 2",
            "Black, 5, 5, 3, 7",
            "Black, 2, 2, 3, 3",
            "Black, 3, 7, 5, 5",
    })

    public void rookValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.ROOK;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }


    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 5",
            "White, 3, 2, 8, 2",
            "White, 7, 4, 7, 0",
            "White, 5, 2, 5, 7",
            "Black, 5, 5, 4, 5",
            "Black, 3, 2, 8, 2",
            "Black, 7, 4, 7, 0",
            "Black, 5, 2, 5, 7",

    })

    public void rookValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.ROOK;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }


    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 6, 3",
            "White, 5, 5, 6, 5",
            "White, 3, 3, 3, 4",
            "White, 5, 5, 5, 4",
            "White, 5, 5, 3, 3",
            "White, 5, 5, 3, 7",
            "Black, 8, 3, 7, 3",
            "Black, 2, 5, 4, 5",
            "Black, 3, 3, 3, 4",
            "Black, 5, 5, 5, 4",
            "Black, 5, 5, 7, 7",
            "Black, 5, 5, 7, 3",
    })

    public void silverGeneralValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.SILVER_GENERAL;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 5",
            "White, 3, 2, 2, 1",
            "White, 3, 2, 2, 3",
            "White, 5, 2, 6, 3",
            "White, 5, 2, 6, 1",
            "Black, 5, 5, 6, 5",
            "Black, 3, 2, 2, 1",
            "Black, 3, 2, 2, 3",
            "Black, 5, 2, 6, 3",
            "Black, 5, 2, 6, 1",

    })

    public void silverGeneralValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.SILVER_GENERAL;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }


    @ParameterizedTest
    @CsvSource({
            "White, 8, 3, 6, 3",
            "White, 4, 5, 6, 5",
            "White, 3, 3, 3, 7",
            "White, 5, 5, 5, 3",
            "Black, 8, 3, 6, 3",
            "Black, 4, 5, 6, 5",
            "Black, 3, 3, 3, 7",
            "Black, 5, 5, 5, 3",
    })

    public void promotedBishopValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.PROMOTED_BISHOP;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 4",
            "White, 5, 5, 3, 7",
            "White, 3, 3, 4, 4",
            "White, 5, 5, 8, 2",
            "White, 5, 5, 4, 5",
            "White, 5, 5, 6, 5",
            "White, 3, 3, 3, 4",
            "White, 3, 3, 3, 2",
            "Black, 5, 5, 4, 4",
            "Black, 5, 5, 3, 7",
            "Black, 3, 3, 4, 4",
            "Black, 5, 5, 8, 2",
            "Black, 5, 5, 4, 5",
            "Black, 5, 5, 6, 5",
            "Black, 3, 3, 3, 4",
            "Black, 3, 3, 3, 2",
    })

    public void promotedBishopValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.PROMOTED_BISHOP;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }



    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 3, 3",
            "White, 5, 5, 3, 7",
            "White, 3, 3, 5, 5",
            "White, 3, 3, 5, 1",
            "Black, 5, 5, 3, 3",
            "Black, 5, 5, 3, 7",
            "Black, 3, 3, 5, 5",
            "Black, 3, 3, 5, 1",
    })

    public void promotedRookValidateDestinationWrongTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.PROMOTED_ROOK;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertThrows(InvalidSelectedDestinationException.class, () -> strategy.validateDestination(piece,positionTo));
    }

    @ParameterizedTest
    @CsvSource({
            "White, 5, 5, 4, 5",
            "White, 3, 2, 8, 2",
            "White, 7, 4, 7, 0",
            "White, 5, 2, 5, 7",
            "White, 5, 2, 4, 3",
            "White, 5, 2, 4, 1",
            "White, 6, 5, 7, 4",
            "White, 6, 5, 7, 6",
            "Black, 5, 5, 4, 5",
            "Black, 3, 2, 8, 2",
            "Black, 7, 4, 7, 0",
            "Black, 5, 2, 5, 7",
            "Black, 5, 2, 4, 3",
            "Black, 5, 2, 4, 1",
            "Black, 6, 5, 7, 4",
            "Black, 6, 5, 7, 6",

    })

    public void promotedRookValidateCorrectDestinationTest(String color,int rowFrom, int columnFrom, int rowTo, int columnTo) throws Exception{
        PieceType pieceType = PieceType.PROMOTED_ROOK;
        Player player = new Player(color,"player");
        Position positionFrom = new Position(rowFrom, columnFrom);
        Piece piece = new Piece(pieceType,player);
        piece.setCurrentPosition(positionFrom);
        Position positionTo = new Position(rowTo,columnTo);
        MoveStrategy strategy = factory.getMoveStrategy(piece);
        Assertions.assertTrue(strategy.validateDestination(piece,positionTo));
    }



}
