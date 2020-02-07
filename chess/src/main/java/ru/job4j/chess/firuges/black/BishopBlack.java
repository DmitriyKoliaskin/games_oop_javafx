package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x;
        int deltaY = source.y;
        for (int index = 0; index < size; index++) {
            deltaX = deltaX + Integer.compare(dest.x, source.x);
            deltaY = deltaY + Integer.compare(dest.y, source.y);
            steps[index] = findBy(deltaX, deltaY);
        }
        return steps;
    }

    public static Cell findBy(int x, int y) {
        Cell[] cells = Cell.values();
        Cell[] step = new Cell[1];
        for (Cell cell : cells) {
            if (cell.x == x && cell.y == y) {
                step[0] = cell;
            }
        }
        return step[0];
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        if (deltaX == deltaY) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
