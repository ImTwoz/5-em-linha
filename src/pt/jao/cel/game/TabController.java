package pt.jao.cel.game;

public class TabController {
    String[][] tab = new String[5][5];

    public void displayTab() {
        System.out.print("  ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clearTab() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tab[i][j] = "#";
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tab[i][j].equals("#")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean move(int column, String player) {
        if (column < 0 || column > 4) {
            // Verifica se o valor da coluna é inválido.
            return false;
        }

        int row = 0;
        while (row < 5 && tab[row][column].equals("#")) {
            row++;
        }

        if (row == 0 || !tab[row - 1][column].equals("#")) {
            // Verifica se a coluna está cheia ou se o valor é inválido
            return false;
        }

        tab[row - 1][column] = player;
        return true;
    }
}
