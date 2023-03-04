package ru.wasabi.pieces;

import ru.wasabi.Color;
import ru.wasabi.Coordinates;

import java.util.Set;

public class Pawn extends Piece {

    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return null;
    }
}
