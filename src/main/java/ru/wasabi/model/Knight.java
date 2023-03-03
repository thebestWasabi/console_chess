package ru.wasabi.model;

import ru.wasabi.Color;
import ru.wasabi.Coordinates;

import java.util.Set;

public class Knight extends Piece {

    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return null;
    }
}
