package pt.jao.cel;

import pt.jao.cel.game.GameController;

public class Main {
    public static void main(String[] args) {

        // Inicialização dos componentes do jogo
        GameController gameController = new GameController();

        // Inicialização do jogo
        gameController.play();
    }
}