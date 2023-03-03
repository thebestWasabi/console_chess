package ru.wasabi;

public enum Column {

    A, B, C, D, E, F, G, H;

    public static Column fromChar(char c) {
        try {
            return Column.valueOf(String.valueOf(c).toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
