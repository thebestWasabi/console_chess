package ru.wasabi.model;

public class CoordinateShift {

    public final int columnShift;
    public final int rowShift;

    public CoordinateShift(int columnShift, int rowShift) {
        this.columnShift = columnShift;
        this.rowShift = rowShift;
    }
}
