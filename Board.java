import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {

    private HashMap<String, Square> squares;
    private char letter = 'a';
    private int index = 1;
    private Mark status;

    public Board() {
        squares = new HashMap<>();
        createBoard();

        squares.get("d4").setStatus(Mark.WHITE);
        squares.get("e4").setStatus(Mark.BLACK);
        squares.get("d5").setStatus(Mark.BLACK);
        squares.get("e5").setStatus(Mark.WHITE);

    }

    private void createBoard() {
        for (int counter = 0; counter < 64; counter++) {
            squares.put(Character.toString(letter) + index, new Square());
            if (index % 8 == 0) {
                index = 0;
                letter++;
            }
            index++;
        }
    }

    public void drawBoard() {

        letter = 'a';
        index = 1;

        System.out.println("➕―――――――――――――➕");
        System.out.println("|   1 2 3 4 5 6 7 8    |");

        int row = 1;

        for (int counter = 0; counter < squares.size(); counter++) {
            status = squares.get(Character.toString(letter) + index).getStatus();

            if (index == 1) {
                System.out.print("| " + letter + " ");
            }

            if (status == Mark.EMPTY) {
                System.out.print("." + " ");
            } else if (status == Mark.WHITE) {
                System.out.print("O" + " ");
            } else {
                System.out.print("X" + " ");
            }

            if (index % 8 == 0) {
                System.out.print(" " + letter + " |\n");
                index = 0;
                letter++;
                row++;
            }
            index++;
        }
        System.out.println("|   1 2 3 4 5 6 7 8    |");
        System.out.println("➕―――――――――――――➕");
    }

    public void changeTileStatus(String key, Mark newStatus) {
        squares.get(key).setStatus(newStatus);
    }

    public Mark getTileStatus(String key) {
        try {
            return squares.get(key).getStatus();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean checkIfTileExists(String key) {
        return squares.containsKey(key);
    }

    public boolean checkNoMoreMoves(Player currentPlayer) {


        Mark currentPlayerColor = currentPlayer.getMarkColor();

        Mark oppositePlayerColor;

        if (currentPlayerColor == Mark.BLACK) {
            oppositePlayerColor = Mark.WHITE;
        } else {
            oppositePlayerColor = Mark.BLACK;
        }

        Set<Map.Entry<String, Square>> entrySet = squares.entrySet();
        for (Map.Entry<String, Square> entry : entrySet) {
            Mark value = entry.getValue().getStatus();
            if (value == oppositePlayerColor) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfBoardIsFull() {
        Set<Map.Entry<String, Square>> entrySet = squares.entrySet();
        for (Map.Entry<String, Square> entry : entrySet) {
            Mark value = entry.getValue().getStatus();
            if (value == Mark.EMPTY) {
                return false;
            }
        }
        return true;
    }

    public int getCurrentScore(Mark winningPlayerColor) {
        Set<Map.Entry<String, Square>> entrySet = squares.entrySet();
        int finalScore = 0;
        for (Map.Entry<String, Square> entry : entrySet) {
            Mark value = entry.getValue().getStatus();
            if (value == winningPlayerColor) {
                finalScore++;
            }
        }
        return finalScore;
    }

    //Testmethods for filling the board

    public void fillBoard() {
        squares.get("a1").setStatus(Mark.BLACK);
        squares.get("a2").setStatus(Mark.BLACK);
        squares.get("a3").setStatus(Mark.BLACK);
        squares.get("a4").setStatus(Mark.BLACK);
        squares.get("a5").setStatus(Mark.BLACK);
        squares.get("a6").setStatus(Mark.BLACK);
        squares.get("a7").setStatus(Mark.BLACK);
        squares.get("a8").setStatus(Mark.BLACK);
        squares.get("b1").setStatus(Mark.BLACK);
        squares.get("b2").setStatus(Mark.BLACK);
        squares.get("b3").setStatus(Mark.BLACK);
        squares.get("b4").setStatus(Mark.BLACK);
        squares.get("b5").setStatus(Mark.BLACK);
        squares.get("b6").setStatus(Mark.BLACK);
        squares.get("b7").setStatus(Mark.BLACK);
        squares.get("b8").setStatus(Mark.BLACK);
        squares.get("c1").setStatus(Mark.BLACK);
        squares.get("c2").setStatus(Mark.BLACK);
        squares.get("c3").setStatus(Mark.BLACK);
        squares.get("c4").setStatus(Mark.BLACK);
        squares.get("c5").setStatus(Mark.BLACK);
        squares.get("c6").setStatus(Mark.BLACK);
        squares.get("c7").setStatus(Mark.BLACK);
        squares.get("c8").setStatus(Mark.BLACK);
        squares.get("d1").setStatus(Mark.BLACK);
        squares.get("d2").setStatus(Mark.BLACK);
        squares.get("d3").setStatus(Mark.BLACK);
        squares.get("d4").setStatus(Mark.BLACK);
        squares.get("d5").setStatus(Mark.BLACK);
        squares.get("d6").setStatus(Mark.BLACK);
        squares.get("d7").setStatus(Mark.BLACK);
        squares.get("d8").setStatus(Mark.BLACK);
        squares.get("e1").setStatus(Mark.BLACK);
        squares.get("e2").setStatus(Mark.BLACK);
        squares.get("e3").setStatus(Mark.BLACK);
        squares.get("e4").setStatus(Mark.BLACK);
        squares.get("e5").setStatus(Mark.BLACK);
        squares.get("e6").setStatus(Mark.BLACK);
        squares.get("e7").setStatus(Mark.BLACK);
        squares.get("e8").setStatus(Mark.BLACK);
        squares.get("f1").setStatus(Mark.BLACK);
        squares.get("f2").setStatus(Mark.BLACK);
        squares.get("f3").setStatus(Mark.BLACK);
        squares.get("f4").setStatus(Mark.BLACK);
        squares.get("f5").setStatus(Mark.BLACK);
        squares.get("f6").setStatus(Mark.BLACK);
        squares.get("f7").setStatus(Mark.BLACK);
        squares.get("f8").setStatus(Mark.BLACK);
        squares.get("g1").setStatus(Mark.BLACK);
        squares.get("g2").setStatus(Mark.BLACK);
        squares.get("g3").setStatus(Mark.BLACK);
        squares.get("g4").setStatus(Mark.BLACK);
        squares.get("g5").setStatus(Mark.BLACK);
        squares.get("g6").setStatus(Mark.BLACK);
        squares.get("g7").setStatus(Mark.BLACK);
        squares.get("g8").setStatus(Mark.BLACK);
        squares.get("h1").setStatus(Mark.BLACK);
        squares.get("h2").setStatus(Mark.BLACK);
        squares.get("h3").setStatus(Mark.BLACK);
        squares.get("h4").setStatus(Mark.BLACK);
        squares.get("h5").setStatus(Mark.BLACK);
        squares.get("h6").setStatus(Mark.BLACK);
        squares.get("h7").setStatus(Mark.BLACK);
        squares.get("h8").setStatus(Mark.BLACK);
    }

    public void fillBoardDraw() {
        squares.get("a1").setStatus(Mark.BLACK);
        squares.get("a2").setStatus(Mark.BLACK);
        squares.get("a3").setStatus(Mark.BLACK);
        squares.get("a4").setStatus(Mark.BLACK);
        squares.get("a5").setStatus(Mark.BLACK);
        squares.get("a6").setStatus(Mark.BLACK);
        squares.get("a7").setStatus(Mark.BLACK);
        squares.get("a8").setStatus(Mark.BLACK);
        squares.get("b1").setStatus(Mark.BLACK);
        squares.get("b2").setStatus(Mark.BLACK);
        squares.get("b3").setStatus(Mark.BLACK);
        squares.get("b4").setStatus(Mark.BLACK);
        squares.get("b5").setStatus(Mark.BLACK);
        squares.get("b6").setStatus(Mark.BLACK);
        squares.get("b7").setStatus(Mark.BLACK);
        squares.get("b8").setStatus(Mark.BLACK);
        squares.get("c1").setStatus(Mark.BLACK);
        squares.get("c2").setStatus(Mark.BLACK);
        squares.get("c3").setStatus(Mark.BLACK);
        squares.get("c4").setStatus(Mark.BLACK);
        squares.get("c5").setStatus(Mark.BLACK);
        squares.get("c6").setStatus(Mark.BLACK);
        squares.get("c7").setStatus(Mark.BLACK);
        squares.get("c8").setStatus(Mark.BLACK);
        squares.get("d1").setStatus(Mark.BLACK);
        squares.get("d2").setStatus(Mark.BLACK);
        squares.get("d3").setStatus(Mark.BLACK);
        squares.get("d4").setStatus(Mark.BLACK);
        squares.get("d5").setStatus(Mark.BLACK);
        squares.get("d6").setStatus(Mark.BLACK);
        squares.get("d7").setStatus(Mark.BLACK);
        squares.get("d8").setStatus(Mark.BLACK);

        squares.get("e1").setStatus(Mark.WHITE);
        squares.get("e2").setStatus(Mark.WHITE);
        squares.get("e3").setStatus(Mark.WHITE);
        squares.get("e4").setStatus(Mark.WHITE);
        squares.get("e5").setStatus(Mark.WHITE);
        squares.get("e6").setStatus(Mark.WHITE);
        squares.get("e7").setStatus(Mark.WHITE);
        squares.get("e8").setStatus(Mark.WHITE);
        squares.get("f1").setStatus(Mark.WHITE);
        squares.get("f2").setStatus(Mark.WHITE);
        squares.get("f3").setStatus(Mark.WHITE);
        squares.get("f4").setStatus(Mark.WHITE);
        squares.get("f5").setStatus(Mark.WHITE);
        squares.get("f6").setStatus(Mark.WHITE);
        squares.get("f7").setStatus(Mark.WHITE);
        squares.get("f8").setStatus(Mark.WHITE);
        squares.get("g1").setStatus(Mark.WHITE);
        squares.get("g2").setStatus(Mark.WHITE);
        squares.get("g3").setStatus(Mark.WHITE);
        squares.get("g4").setStatus(Mark.WHITE);
        squares.get("g5").setStatus(Mark.WHITE);
        squares.get("g6").setStatus(Mark.WHITE);
        squares.get("g7").setStatus(Mark.WHITE);
        squares.get("g8").setStatus(Mark.WHITE);
        squares.get("h1").setStatus(Mark.WHITE);
        squares.get("h2").setStatus(Mark.WHITE);
        squares.get("h3").setStatus(Mark.WHITE);
        squares.get("h4").setStatus(Mark.WHITE);
        squares.get("h5").setStatus(Mark.WHITE);
        squares.get("h6").setStatus(Mark.WHITE);
        squares.get("h7").setStatus(Mark.WHITE);
        squares.get("h8").setStatus(Mark.WHITE);
    }

    public void fillBoardWhiteWins() {
        squares.get("a1").setStatus(Mark.WHITE);
        squares.get("a2").setStatus(Mark.WHITE);
        squares.get("a3").setStatus(Mark.WHITE);
        squares.get("a4").setStatus(Mark.WHITE);
        squares.get("a5").setStatus(Mark.WHITE);
        squares.get("a6").setStatus(Mark.WHITE);
        squares.get("a7").setStatus(Mark.WHITE);
        squares.get("a8").setStatus(Mark.WHITE);
        squares.get("b1").setStatus(Mark.WHITE);
        squares.get("b2").setStatus(Mark.WHITE);
        squares.get("b3").setStatus(Mark.WHITE);
        squares.get("b4").setStatus(Mark.WHITE);
        squares.get("b5").setStatus(Mark.WHITE);
        squares.get("b6").setStatus(Mark.WHITE);
        squares.get("b7").setStatus(Mark.WHITE);
        squares.get("b8").setStatus(Mark.WHITE);
        squares.get("c1").setStatus(Mark.WHITE);
        squares.get("c2").setStatus(Mark.WHITE);
        squares.get("c3").setStatus(Mark.WHITE);
        squares.get("c4").setStatus(Mark.WHITE);
        squares.get("c5").setStatus(Mark.WHITE);
        squares.get("c6").setStatus(Mark.WHITE);
        squares.get("c7").setStatus(Mark.WHITE);
        squares.get("c8").setStatus(Mark.WHITE);
        squares.get("d1").setStatus(Mark.WHITE);
        squares.get("d2").setStatus(Mark.WHITE);
        squares.get("d3").setStatus(Mark.WHITE);
        squares.get("d4").setStatus(Mark.WHITE);
        squares.get("d5").setStatus(Mark.WHITE);
        squares.get("d6").setStatus(Mark.WHITE);
        squares.get("d7").setStatus(Mark.WHITE);
        squares.get("d8").setStatus(Mark.WHITE);
        squares.get("e1").setStatus(Mark.WHITE);
        squares.get("e2").setStatus(Mark.WHITE);
        squares.get("e3").setStatus(Mark.WHITE);
        squares.get("e4").setStatus(Mark.WHITE);
        squares.get("e5").setStatus(Mark.WHITE);
        squares.get("e6").setStatus(Mark.WHITE);
        squares.get("e7").setStatus(Mark.WHITE);
        squares.get("e8").setStatus(Mark.BLACK);
        squares.get("f1").setStatus(Mark.BLACK);
        squares.get("f2").setStatus(Mark.BLACK);
        squares.get("f3").setStatus(Mark.BLACK);
        squares.get("f4").setStatus(Mark.BLACK);
        squares.get("f5").setStatus(Mark.BLACK);
        squares.get("f6").setStatus(Mark.BLACK);
        squares.get("f7").setStatus(Mark.BLACK);
        squares.get("f8").setStatus(Mark.BLACK);
        squares.get("g1").setStatus(Mark.BLACK);
        squares.get("g2").setStatus(Mark.BLACK);
        squares.get("g3").setStatus(Mark.BLACK);
        squares.get("g4").setStatus(Mark.BLACK);
        squares.get("g5").setStatus(Mark.BLACK);
        squares.get("g6").setStatus(Mark.BLACK);
        squares.get("g7").setStatus(Mark.BLACK);
        squares.get("g8").setStatus(Mark.BLACK);
        squares.get("h1").setStatus(Mark.BLACK);
        squares.get("h2").setStatus(Mark.BLACK);
        squares.get("h3").setStatus(Mark.BLACK);
        squares.get("h4").setStatus(Mark.BLACK);
        squares.get("h5").setStatus(Mark.BLACK);
        squares.get("h6").setStatus(Mark.BLACK);
        squares.get("h7").setStatus(Mark.BLACK);
        squares.get("h8").setStatus(Mark.BLACK);

    }

    public void fillBoardBlackWins() {
        squares.get("a1").setStatus(Mark.WHITE);
        squares.get("a2").setStatus(Mark.WHITE);
        squares.get("a3").setStatus(Mark.WHITE);
        squares.get("a4").setStatus(Mark.WHITE);
        squares.get("a5").setStatus(Mark.WHITE);
        squares.get("a6").setStatus(Mark.WHITE);
        squares.get("a7").setStatus(Mark.WHITE);
        squares.get("a8").setStatus(Mark.WHITE);
        squares.get("b1").setStatus(Mark.WHITE);
        squares.get("b2").setStatus(Mark.WHITE);
        squares.get("b3").setStatus(Mark.WHITE);
        squares.get("b4").setStatus(Mark.WHITE);
        squares.get("b5").setStatus(Mark.WHITE);
        squares.get("b6").setStatus(Mark.WHITE);
        squares.get("b7").setStatus(Mark.WHITE);
        squares.get("b8").setStatus(Mark.WHITE);
        squares.get("c1").setStatus(Mark.WHITE);
        squares.get("c2").setStatus(Mark.WHITE);
        squares.get("c3").setStatus(Mark.WHITE);
        squares.get("c4").setStatus(Mark.WHITE);
        squares.get("c5").setStatus(Mark.WHITE);
        squares.get("c6").setStatus(Mark.WHITE);
        squares.get("c7").setStatus(Mark.WHITE);
        squares.get("c8").setStatus(Mark.BLACK);
        squares.get("d1").setStatus(Mark.BLACK);
        squares.get("d2").setStatus(Mark.BLACK);
        squares.get("d3").setStatus(Mark.BLACK);
        squares.get("d4").setStatus(Mark.BLACK);
        squares.get("d5").setStatus(Mark.BLACK);
        squares.get("d6").setStatus(Mark.BLACK);
        squares.get("d7").setStatus(Mark.BLACK);
        squares.get("d8").setStatus(Mark.BLACK);
        squares.get("e1").setStatus(Mark.BLACK);
        squares.get("e2").setStatus(Mark.BLACK);
        squares.get("e3").setStatus(Mark.BLACK);
        squares.get("e4").setStatus(Mark.BLACK);
        squares.get("e5").setStatus(Mark.BLACK);
        squares.get("e6").setStatus(Mark.BLACK);
        squares.get("e7").setStatus(Mark.BLACK);
        squares.get("e8").setStatus(Mark.BLACK);
        squares.get("f1").setStatus(Mark.BLACK);
        squares.get("f2").setStatus(Mark.BLACK);
        squares.get("f3").setStatus(Mark.BLACK);
        squares.get("f4").setStatus(Mark.BLACK);
        squares.get("f5").setStatus(Mark.BLACK);
        squares.get("f6").setStatus(Mark.BLACK);
        squares.get("f7").setStatus(Mark.BLACK);
        squares.get("f8").setStatus(Mark.BLACK);
        squares.get("g1").setStatus(Mark.BLACK);
        squares.get("g2").setStatus(Mark.BLACK);
        squares.get("g3").setStatus(Mark.BLACK);
        squares.get("g4").setStatus(Mark.BLACK);
        squares.get("g5").setStatus(Mark.BLACK);
        squares.get("g6").setStatus(Mark.BLACK);
        squares.get("g7").setStatus(Mark.BLACK);
        squares.get("g8").setStatus(Mark.BLACK);
        squares.get("h1").setStatus(Mark.BLACK);
        squares.get("h2").setStatus(Mark.BLACK);
        squares.get("h3").setStatus(Mark.BLACK);
        squares.get("h4").setStatus(Mark.BLACK);
        squares.get("h5").setStatus(Mark.BLACK);
        squares.get("h6").setStatus(Mark.BLACK);
        squares.get("h7").setStatus(Mark.BLACK);
        squares.get("h8").setStatus(Mark.BLACK);
    }
}
