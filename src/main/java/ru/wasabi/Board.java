package ru.wasabi;

import ru.wasabi.model.*;

import java.util.HashMap;

public class Board {

    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }

    public void movePiece(Coordinates from, Coordinates to) {
        Piece piece = getPiece(from);
        removePiece(from);
        setPiece(to, piece);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    public void setupDefaultPiecesPosition() {
        //set pawn
        for (Column column : Column.values()) {
            setPiece(new Coordinates(column, 2), new Pawn(Color.WHITE, new Coordinates(column, 2)));
            setPiece(new Coordinates(column, 7), new Pawn(Color.BLACK, new Coordinates(column, 7)));
        }

        //set rook
        setPiece(new Coordinates(Column.A, 1), new Rook(Color.WHITE, new Coordinates(Column.A, 1)));
        setPiece(new Coordinates(Column.H, 1), new Rook(Color.WHITE, new Coordinates(Column.H, 1)));
        setPiece(new Coordinates(Column.A, 8), new Rook(Color.BLACK, new Coordinates(Column.A, 1)));
        setPiece(new Coordinates(Column.H, 8), new Rook(Color.BLACK, new Coordinates(Column.H, 8)));

        //set knight
        setPiece(new Coordinates(Column.B, 1), new Knight(Color.WHITE, new Coordinates(Column.B, 1)));
        setPiece(new Coordinates(Column.G, 1), new Knight(Color.WHITE, new Coordinates(Column.G, 1)));
        setPiece(new Coordinates(Column.B, 8), new Knight(Color.BLACK, new Coordinates(Column.B, 1)));
        setPiece(new Coordinates(Column.G, 8), new Knight(Color.BLACK, new Coordinates(Column.G, 8)));

        //set bishop
        setPiece(new Coordinates(Column.C, 1), new Bishop(Color.WHITE, new Coordinates(Column.C, 1)));
        setPiece(new Coordinates(Column.F, 1), new Bishop(Color.WHITE, new Coordinates(Column.F, 1)));
        setPiece(new Coordinates(Column.C, 8), new Bishop(Color.BLACK, new Coordinates(Column.C, 1)));
        setPiece(new Coordinates(Column.F, 8), new Bishop(Color.BLACK, new Coordinates(Column.F, 8)));

        //set queen
        setPiece(new Coordinates(Column.D, 1), new Queen(Color.WHITE, new Coordinates(Column.D, 1)));
        setPiece(new Coordinates(Column.D, 8), new Queen(Color.BLACK, new Coordinates(Column.D, 8)));

        //set king
        setPiece(new Coordinates(Column.E, 1), new King(Color.WHITE, new Coordinates(Column.E, 1)));
        setPiece(new Coordinates(Column.E, 8), new King(Color.BLACK, new Coordinates(Column.E, 8)));
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.column.ordinal() + 1) + coordinates.row) % 2) == 0;
    }
}
