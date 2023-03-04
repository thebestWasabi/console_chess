package ru.wasabi.pieces;

import ru.wasabi.Color;
import ru.wasabi.Coordinates;

import java.util.Set;

public class King extends Piece {

    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return null;
    }
}
