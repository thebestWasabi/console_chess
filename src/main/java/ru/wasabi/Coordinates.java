package ru.wasabi;

import ru.wasabi.model.CoordinateShift;

public class Coordinates {

    public final Column column;
    public final Integer row;

    public Coordinates(Column column, Integer row) {
        this.column = column;
        this.row = row;
    }

    public boolean canShift(CoordinateShift shift) {
        int c = column.ordinal() + shift.columnShift;
        int r = row + shift.rowShift;

        if ((c < 0) || (c > 7)) return false;
        if ((r < 1) || (r > 8)) return false;

        return true;
    }

    public Coordinates shift(CoordinateShift shift) {
        return new Coordinates(Column.values()[this.column.ordinal() + shift.columnShift], this.row + shift.rowShift);
    }
}
