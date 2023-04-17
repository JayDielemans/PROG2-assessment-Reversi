import java.util.Scanner;

public class Match {

    static int currentMatch = 0;

    Player player1;
    Player player2;

    static int matchAmount;

    public void Play() {

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("―――――――――――――――――――――――――");
        System.out.println("Welcome to Reversi. By Jay Dielemans (c)");

        while (true) {
            System.out.print("Victories needed to win the match (1-9): ");
            input = scanner.nextLine();
            if (input.matches("[1-9]")) {
                matchAmount = Integer.parseInt(input);
                break;
            }
        }

        while (true) {
            System.out.print("Enter name player 1: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                player1 = new Player(input, Mark.BLACK);
                break;
            }
        }

        while (true) {
            System.out.print("Enter name player 2: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                player2 = new Player(input, Mark.WHITE);
                break;
            }
        }

        while (true) {
            if (currentMatch < matchAmount) {
                currentMatch++;
                System.out.println("―――――――――――――――――――――――――");
                System.out.println("(Match " + currentMatch + " starts)");
                new Game(player1, player2, currentMatch);
            } else {
                if (player1.getScore() == player2.getScore()) {
                    currentMatch++;
                    System.out.println("The score is tied, another game will be played to determine the winner");
                    System.out.println("―――――――――――――――――――――――――");
                    System.out.println("(Match " + currentMatch + " starts)");
                    new Game(player1, player2, 1);
                } else {
                    if (player1.getScore() > player2.getScore()) {
                        System.out.println("And the winner is ... " + player1.getName());
                        break;
                    } else if (player2.getScore() > player1.getScore()) {
                        System.out.println("And the winner is ... " + player2.getName());
                        break;
                    }
                }
            }
        }
    }

    public void endMatch(Player player1, Player player2, int resultBlack, int resultWhite) {

        Mark winningColor;

        if (resultBlack == resultWhite) {
            winningColor = Mark.EMPTY;
        } else if (resultBlack > resultWhite) {
            winningColor = Mark.BLACK;
        } else {
            winningColor = Mark.WHITE;
        }

        int winner;

        if (player1.getMarkColor() == winningColor) {
            winner = 1;
            player1.registerWin();
        } else if (player2.getMarkColor() == winningColor) {
            winner = 2;
            player2.registerWin();
        } else {
            winner = 0;
        }
        String winningText;
        String scoreText = "The score is now: " + player1.getName() + "(" + player1.getScore() + ")" + " - " + player2.getName() + "(" + player2.getScore() + ")";
        String StringResultBlack = String.valueOf(resultBlack);
        String StringResultWhite = String.valueOf(resultWhite);

        switch (winner) {
            case 1:
                winningText = player1.getName();
                if (player1.getMarkColor() == Mark.BLACK) {
                    winningText += "(X)";
                } else if (player1.getMarkColor() == Mark.WHITE) {
                    winningText += ("O");
                }
                winningText += " has won by ";

                if (player1.getMarkColor() == Mark.BLACK) {
                    winningText += StringResultBlack + " - " + StringResultWhite;
                } else if (player1.getMarkColor() == Mark.WHITE) {
                    winningText += StringResultWhite + " - " + StringResultBlack;
                }

                System.out.println(winningText);
                System.out.println(scoreText);
                break;
            case 2:
                winningText = player2.getName();
                if (player2.getMarkColor() == Mark.BLACK) {
                    winningText += "(X)";
                } else if (player2.getMarkColor() == Mark.WHITE) {
                    winningText += "(O)";
                }
                winningText += " has won by ";

                if (player2.getMarkColor() == Mark.BLACK) {
                    winningText += StringResultBlack + " - " + StringResultWhite;
                } else if (player2.getMarkColor() == Mark.WHITE) {
                    winningText += StringResultWhite + " - " + StringResultBlack;
                }

                System.out.println(winningText);
                System.out.println(scoreText);
                break;
            case 0:
                Match.currentMatch--;
                System.out.println("The game ended in a tie and will now be replayed");
                break;
        }
        player1.changeMarkColor();
        player2.changeMarkColor();
    }

}
