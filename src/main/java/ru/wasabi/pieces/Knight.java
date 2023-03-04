package ru.wasabi.pieces;

import ru.wasabi.Color;
import ru.wasabi.Coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinateShift> getPieceMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinateShift(1, 2),
                new CoordinateShift(2, 1),

                new CoordinateShift(2, -1),
                new CoordinateShift(1, -2),

                new CoordinateShift(-2, -1),
                new CoordinateShift(-1, -2),

                new CoordinateShift(-2, 1),
                new CoordinateShift(-1, 2)
        ));
    }
}
