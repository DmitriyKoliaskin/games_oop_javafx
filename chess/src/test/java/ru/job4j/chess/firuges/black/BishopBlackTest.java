package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {

    @Test
    void position() {
        assertThat(new BishopBlack(Cell.A3).position()).isEqualTo(Cell.A3);
    }

    @Test
    void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.copy(Cell.A2).position()).isEqualTo(Cell.A2);
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.G5))
                .isEqualTo(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }
}