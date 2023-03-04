package ru.wasabi;

import ru.wasabi.pieces.Piece;

public class BoardRender {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (Column column : Column.values()) {
                Coordinates coordinates = new Coordinates(column, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {
                    line += getPieceSprite(board.getPiece(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        // format = background color + font color + text
        String result = sprite;
        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates));
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "P";
            case "Knight":
                return "K";
            case "Bishop":
                return "B";
            case "Rook":
                return "R";
            case "Queen":
                return "Q";
            case "King":
                return "#";
        }
        return "";
    }

    private String getPieceSprite(Piece piece) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquareDark(piece.coordinates)
        );
    }
}
