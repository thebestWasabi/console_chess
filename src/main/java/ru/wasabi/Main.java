package ru.wasabi;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPosition();

        Game game = new Game(board);
        game.gameLoop();
    }
}