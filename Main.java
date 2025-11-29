import java.util.Scanner;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean isRunning = true;
        String[][] table = new String[3][3];
        String playerOne = "[" + BLUE + "X" + RESET + "]";
        String playerTwo = "[" + GREEN + "O" + RESET + "]";
        boolean playerTurn = true;

        int n = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = String.format("[%d]", n);
                n++;
            }
        }

        while (isRunning) {
            showTable(table);

            if (playerTurn) {
                boolean validMove = false;
                while (!validMove) {
                    System.out.print(BLUE + "Player 1 turn\nEnter position (1-9): " + RESET);
                    int pos = input.nextInt();
                    validMove = playerSelect(table, playerOne, pos);

                    if (!validMove) {
                        System.out.println("Cell is already occupied!");
                        showTable(table);
                    }
                    if (checkWinner(playerOne, table)) {
                        showTable(table);
                        System.out.println("\nPlayer 1 Wins!");
                        isRunning = false;
                    }
                    if (isDraw(table)) {
                        showTable(table);
                        System.out.println("It's a draw!");
                        isRunning = false;
                    }
                }
                playerTurn = false;
            } else {
                boolean validMove = false;
                while (!validMove) {
                    System.out.print(GREEN + "Player 2 turn\nEnter position (1-9): " + RESET);
                    int pos = input.nextInt();
                    validMove = playerSelect(table, playerTwo, pos);
                    if (!validMove) {
                        System.out.println("Cell is already occupied!");
                        showTable(table);
                    }
                    if (checkWinner(playerTwo, table)) {
                        showTable(table);
                        System.out.println("\nPlayer 2 Wins");
                        isRunning = false;
                    }
                    if (isDraw(table)) {
                        showTable(table);
                        System.out.println("\nIt's a draw!");
                        isRunning = false;
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

    static boolean checkWinner(String player, String[][] table) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][0].equals(player) && table[i][1].equals(player) && table[i][2].equals(player)) {
                return true;
            }
        }
        for (int j = 0; j < table.length; j++) {
            if (table[0][j].equals(player) && table[1][j].equals(player) && table[2][j].equals(player)) {
                return true;
            }
            if (table[0][0].equals(player) && table[1][1].equals(player) && table[2][2].equals(player)) {
                return true;
            }
            if (table[0][2].equals(player) && table[1][1].equals(player) && table[2][0].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDraw(String[][] table) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // If a cell is NOT X and NOT O → still empty
                if (!table[i][j].equals("[X]") && !table[i][j].equals("[O]")) {
                    return false;
                }
            }
        }
        // If we reach here, all cells are filled → draw
        return true;
    }
}
