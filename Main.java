import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean isRunning = true;
        String[][] table = new String[3][3];
        String playerOne = "[X]";
        String playerTwo = "[O]";

        boolean playerTurn = true;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = "[ ]";
            }
        }

        while (isRunning) {
            showTable(table);

            if (playerTurn) {
                boolean validMove = false;
                while (!validMove) {
                    System.out.print("Player 1 turn\nEnter position (1-9): ");
                    int pos = input.nextInt();
                    validMove = playerSelect(table, playerOne, pos);
                    if (!validMove) {
                        System.out.println("Cell is already occupied!");
                        showTable(table);
                    }
                }
                playerTurn = false;
            } else {
                boolean validMove = false;
                while (!validMove) {
                    System.out.print("Player 2 turn\nEnter position (1-9): ");
                    int pos = input.nextInt();
                    validMove = playerSelect(table, playerTwo, pos);
                    if (!validMove) {
                        System.out.println("Cell is already occupied!");
                        showTable(table);
                    }
                }
                playerTurn = true;
            }
        }
    }

    static void showTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    static boolean playerSelect(String[][] table, String player, int pos) {
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;

        String playerSelection = table[row][col];
        if (!playerSelection.equals("[X]") && !playerSelection.equals("[O]")) {
            table[row][col] = player;
            return true;
        } else {
            return false;
        }
    }
}
