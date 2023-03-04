package ru.wasabi;

import ru.wasabi.pieces.CoordinateShift;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return column == that.column && row.equals(that.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
