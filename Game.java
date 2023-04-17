import java.util.Scanner;

public class Game {

    Match game = new Match();
    Player player1;
    Player player2;
    Player currentPlayer;
    String input;
    Board board;

    private boolean gameOngoing = true;

    public Game(Player player1, Player player2, int currentMatch) {

        this.player1 = player1;
        this.player2 = player2;

        board = new Board();
        Scanner scanner = new Scanner(System.in);
        board.drawBoard();

        if (currentMatch > 1) {
            if ((currentMatch - 1) % 2 == 0) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
        } else {
            currentPlayer = player1;
        }

        while (gameOngoing) {

            String moveText;
            moveText = currentPlayer.getName();

            if (currentPlayer.getMarkColor() == Mark.BLACK) {
                moveText += "(X)";
            } else {
                moveText += "(0)";
            }

            moveText += ", please enter your move: ";

            System.out.print(moveText);
            input = scanner.nextLine();

            if (input == "") {
                System.out.println("Input can't be empty");
            } else {
                if (board.checkIfTileExists(input) != true) {
                    System.out.println("This square does not exist");
                } else {
                    if (board.getTileStatus(input) != Mark.EMPTY) {
                        System.out.println("This square is not empty");
                    } else {
                        if (checkMove(input) != true) {
                            System.out.println("This move is not valid");
                        } else {
                            if (checkStreaks(input, currentPlayer) == false) {
                                System.out.println("This move is not legal");
                            } else {
                                board.changeTileStatus(input, currentPlayer.getMarkColor());
                                if (board.checkIfBoardIsFull() == true) {
                                    if (board.getCurrentScore(Mark.BLACK) == board.getCurrentScore(Mark.WHITE)) {
                                        board.drawBoard();
                                        endMatch(player1, player2);
                                    } else {
                                        board.drawBoard();
                                        endMatch(player1, player2);
                                    }
                                } else {
                                    if (board.checkNoMoreMoves(currentPlayer) == true) {
                                        board.drawBoard();
                                        endMatch(player1, player2);
                                    } else {
                                        board.drawBoard();
                                    }
                                }
                                if (currentPlayer == player1) {
                                    currentPlayer = player2;
                                } else {
                                    currentPlayer = player1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void endMatch(Player player1, Player player2) {

        int resultBlack = board.getCurrentScore(Mark.BLACK);
        int resultWhite = board.getCurrentScore(Mark.WHITE);

        gameOngoing = false;

        game.endMatch(player1, player2, resultBlack, resultWhite);

    }

    private boolean checkStreaks(String tile, Player currentPlayer) {

        char letter = tile.charAt(0); //b
        int number = Integer.parseInt(tile.substring(1)); //3

        Mark ownColor;
        Mark oppositePlayerColor;

        if (currentPlayer.getMarkColor() == Mark.BLACK) {
            ownColor = Mark.BLACK;
            oppositePlayerColor = Mark.WHITE;
        } else {
            ownColor = Mark.WHITE;
            oppositePlayerColor = Mark.BLACK;
        }

        int teller = 0;
        int streakTeller = 0;

        //LeftUp
        while (true) {
            if (board.getTileStatus(Character.toString(letter - (teller + 1)) + (number - (teller + 1))) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter - (teller + 1)) + (number - (teller + 1))) == ownColor) {

                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter - (i + 1)) + (number - (i + 1)), ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //Up
        while (true) {
            if (board.getTileStatus(Character.toString(letter - (teller + 1)) + number) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter - (teller + 1)) + number) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter - (i + 1)) + number, ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //RightUp
        while (true) {
            if (board.getTileStatus(Character.toString(letter - (teller + 1)) + (number + (teller + 1))) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter - (teller + 1)) + (number + (teller + 1))) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter - (i + 1)) + (number + (i + 1)), ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //Right
        while (true) {
            if (board.getTileStatus(Character.toString(letter) + (number + (teller + 1))) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter) + (number + (teller + 1))) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter) + (number + (i + 1)), ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //RightDown
        while (true) {
            if (board.getTileStatus(Character.toString(letter + (teller + 1)) + (number + (teller + 1))) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter + (teller + 1)) + (number + (teller + 1))) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter + (i + 1)) + (number + (i + 1)), ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //Down
        while (true) {
            if (board.getTileStatus(Character.toString(letter + (teller + 1)) + number) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter + (teller + 1)) + number) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter + (i + 1)) + number, ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //LeftDown
        while (true) {
            if (board.getTileStatus(Character.toString(letter + (teller + 1)) + (number - (teller + 1))) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter + (teller + 1)) + (number - (teller + 1))) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter + (i + 1)) + (number - (i + 1)), ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        teller = 0;

        //Left
        while (true) {
            if (board.getTileStatus(Character.toString(letter) + (number - (teller + 1))) == oppositePlayerColor) {
                teller++;

            } else if (board.getTileStatus(Character.toString(letter) + (number - (teller + 1))) == ownColor) {
                if (teller > 0) {
                    streakTeller++;
                    for (int i = 0; i < teller; i++) {
                        board.changeTileStatus(Character.toString(letter) + (number - (i + 1)), ownColor);
                    }
                }
                break;
            } else {
                break;
            }
        }

        if (streakTeller == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkMove(String tile) {

        char letter = tile.charAt(0);
        int number = Integer.parseInt(tile.substring(1));

        int filledFields = 0;

        //LeftUp
        if (letter != 'a' && number != 1) {
            if (board.getTileStatus(Character.toString(letter - 1) + (number - 1)) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //Up
        if (letter != 'a') {
            if (board.getTileStatus(Character.toString(letter - 1) + number) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //RightUp
        if (letter != 'a' && number != 8) {
            if (board.getTileStatus(Character.toString(letter - 1) + (number + 1)) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //Right
        if (number != 8) {
            if (board.getTileStatus(Character.toString(letter) + (number + 1)) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //RightDown
        if (number != 8 && letter != 'h') {
            if (board.getTileStatus(Character.toString(letter + 1) + (number + 1)) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //Down
        if (letter != 'h') {
            if (board.getTileStatus(Character.toString(letter + 1) + number) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //LeftDown
        if (letter != 'h' && number != 1) {
            if (board.getTileStatus(Character.toString(letter + 1) + number) == Mark.EMPTY) {
                filledFields++;
            }
        }

        //Left
        if (number != 1) {
            if (board.getTileStatus(Character.toString(letter) + (number - 1)) == Mark.EMPTY) {
                filledFields++;
            }
        }

        if (filledFields == 8) {
            return false;
        } else {
            return true;
        }
    }

}
