package ru.wasabi.pieces;

import ru.wasabi.Color;
import ru.wasabi.Coordinates;

import java.util.Set;

public class Queen extends Piece{

    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return null;
    }
}
