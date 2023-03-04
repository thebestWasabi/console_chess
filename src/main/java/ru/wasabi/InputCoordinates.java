package ru.wasabi;

import ru.wasabi.pieces.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {

    static Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
        while (true) {
            System.out.println("Введите координаты (пример: a1)");
            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.err.println("Не корректный формат");
                continue;
            }

            char columnChar = line.charAt(0);
            char rowChar = line.charAt(1);

            if (!Character.isLetter(columnChar)) {
                System.err.println("Не корректный формат");
                continue;
            }

            if (!Character.isDigit(rowChar)) {
                System.err.println("Не корректный формат");
                continue;
            }

            int row = Character.getNumericValue(rowChar);
            if (row < 1 || row > 8) {
                System.err.println("Не корректный формат");
                continue;
            }

            Column column = Column.fromChar(columnChar);
            if (column == null) {
                System.err.println("Не корректный формат");
                continue;
            }

            return new Coordinates(column, row);
        }
    }

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("\nВведите координаты фигуры которой хотите сходить");
            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.err.println("Тут пусто");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if (piece.color != color) {
                System.err.println("Неправильный цвет");
                continue;
            }

            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
            if (availableMoveSquares.size() == 0) {
                System.err.println("Фигура заблокирована");
                continue;
            }
            return coordinates;
        }
    }

    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("\nСделайте ход выбранной фигурой");
            Coordinates input = input();
            if (!coordinates.contains(input)) {
                System.err.println("\nНе доступное для хода поле");
                continue;
            }
            return input;
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPosition();

        Coordinates coordinates = inputPieceCoordinatesForColor(Color.WHITE, board);
        System.out.println(coordinates);
    }
}
