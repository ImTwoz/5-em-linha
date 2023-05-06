package pt.jao.cel;

import pt.jao.cel.game.GameController;
import pt.jao.cel.game.TabController;
import pt.jao.cel.player.PlayerController;

public class Main {
    public static void main(String[] args) {

        String currentPlayer = GameController.currentPlayer;

        // Inicialização dos controladores do jogo
        TabController tabController       = new TabController();            // Inicialização da classe responsável pelo tabuleiro do jogo
        GameController gameController     = new GameController();           // Inicialização da classe responsável pelo jogo
        PlayerController playerController = new PlayerController();         // Inicialização da classe responsável pelos jogadores

        // Limpeza da tabela para ter a certeza de que a tabela está vazia
        tabController.clearTab();

        // Mostrar a tabela do jogo usando a classe TabController
        tabController.displayTab();

        gameController.play();
    }
}