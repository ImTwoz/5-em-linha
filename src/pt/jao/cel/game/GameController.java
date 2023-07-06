package pt.jao.cel.game;

import pt.jao.cel.util.ClearConsole;
import pt.jao.cel.util.ConsoleColors;

import java.io.IOException;
import java.util.Scanner;

public class GameController {
    TabController tabController = new TabController();
    public static String currentPlayer = "X";

    public void play() {
        Scanner scanner = new Scanner(System.in);

        tabController.clearTab();
        tabController.displayTab();

        while (!tabController.isFull() && !checkWin(currentPlayer)) {
            try {
                ClearConsole.start();
            } catch (IOException | InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("[" + currentPlayer + "] Escolha uma coluna: ");
            int column = scanner.nextInt();

            if (!tabController.move(column, currentPlayer)) {
                System.out.println("Posição inválida, escolha outra.");
            } else {
                tabController.displayTab();

                if (checkWin(currentPlayer)) {
                    System.out.println(ConsoleColors.brightGreen + "O jogador " + currentPlayer + " ganhou!");
                } else if (tabController.isFull()) {
                    System.out.println(ConsoleColors.brightYellow + "Empate!");
                } else {
                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                }
            }
        }

        System.out.println(ConsoleColors.reset + "Deseja jogar novamente? ");
        String next = scanner.next();

        if (next.equals("sim") || next.equals("s") || next.equals("y") || next.equals("yes")) {
            play();
        } else {
            System.exit(0);
        }
    }

    public boolean checkWin(String currentPlayer) {
        String[][] tab = tabController.tab;

        // Verificar linhas
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 4; j++) {
                if (    tab[i][j].equals(currentPlayer) &&
                        tab[i][j + 1].equals(currentPlayer) &&
                        tab[i][j + 2].equals(currentPlayer) &&
                        tab[i][j + 3].equals(currentPlayer) &&
                        tab[i][j + 4].equals(currentPlayer)) {

                    tabController.clearTab();
                    tab[i][j] = currentPlayer;
                    tab[i][j + 1] = currentPlayer;
                    tab[i][j + 2] = currentPlayer;
                    tab[i][j + 3] = currentPlayer;
                    tab[i][j + 4] = currentPlayer;
                    tabController.displayTab();
                    return true;
                }
            }
        }

        // Verificar Colunas
        for (int i = 0; i < 5 - 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (    tab[i][j].equals(currentPlayer) &&
                        tab[i + 1][j].equals(currentPlayer) &&
                        tab[i + 2][j].equals(currentPlayer) &&
                        tab[i + 3][j].equals(currentPlayer) &&
                        tab[i + 4][j].equals(currentPlayer)) {

                    tabController.clearTab();
                    tab[i][j] = currentPlayer;
                    tab[i + 1][j] = currentPlayer;
                    tab[i + 2][j] = currentPlayer;
                    tab[i + 3][j] = currentPlayer;
                    tab[i + 4][j] = currentPlayer;
                    tabController.displayTab();
                    return true;
                }
            }
        }

        // Verificar Diagonais
        for (int i = 0; i < 5 - 4; i++) {
            for (int j = 0; j < 5 - 4; j++) {
                if (    tab[i][j].equals(currentPlayer) &&
                        tab[i + 1][j + 1].equals(currentPlayer)&&
                        tab[i + 2][j + 2].equals(currentPlayer) &&
                        tab[i + 3][j + 3].equals(currentPlayer) &&
                        tab[i + 4][j + 4].equals(currentPlayer)) {

                    tabController.clearTab();
                    tab[i][j] = currentPlayer;
                    tab[i + 1][j + 1] = currentPlayer;
                    tab[i + 2][j + 2] = currentPlayer;
                    tab[i + 3][j + 3] = currentPlayer;
                    tab[i + 4][j + 4] = currentPlayer;
                    tabController.displayTab();
                    return true;
                }
            }
        }

        for (int i = 4; i < 5; i++) {
            for (int j = 0; j < 5 - 4; j++) {
                if (    tab[i][j].equals(currentPlayer) &&
                        tab[i - 1][j + 1].equals(currentPlayer) &&
                        tab[i - 2][j + 2].equals(currentPlayer) &&
                        tab[i - 3][j + 3].equals(currentPlayer) &&
                        tab[i - 4][j + 4].equals(currentPlayer)) {

                    tabController.clearTab();
                    tab[i][j] = currentPlayer;
                    tab[i - 1][j + 1] = currentPlayer;
                    tab[i - 2][j + 2] = currentPlayer;
                    tab[i - 3][j + 3] = currentPlayer;
                    tab[i - 4][j + 4] = currentPlayer;
                    tabController.displayTab();
                    return true;
                }
            }
        }

        return false;
    }
}