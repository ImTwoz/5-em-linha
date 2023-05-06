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

    public boolean move(int row, int column, String player) {
        if(!tab[row][column].equals("#")) {
            return false;
        }

        tab[row][column] = player;
        return true;
    }
}
