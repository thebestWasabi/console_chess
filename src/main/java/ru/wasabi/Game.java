package ru.wasabi;

import ru.wasabi.pieces.Piece;

import java.util.Set;

public class Game {

    private final Board board;
    private BoardRender render = new BoardRender();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            //render
            render.render(board);

            if (isWhiteToMove) {
                System.out.println("\nХодят белые");
            } else {
                System.out.println("\nХодят черные");
            }

            //input
            Coordinates sourseCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );
            Piece piece = board.getPiece(sourseCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            //make move
            board.movePiece(sourseCoordinates, targetCoordinates);

            //pass move
            isWhiteToMove = !isWhiteToMove;
        }
    }
}
