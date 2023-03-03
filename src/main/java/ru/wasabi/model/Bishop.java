package ru.wasabi.model;

import ru.wasabi.Color;
import ru.wasabi.Coordinates;

import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return null;
    }
}
