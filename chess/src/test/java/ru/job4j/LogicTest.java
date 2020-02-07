package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.black.BishopBlack;
import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Test
    public void whenMove() {
        Logic logic = new Logic();
        BishopBlack bhb = new BishopBlack(C1);
        logic.add(bhb);
        Assert.assertTrue(logic.move(C1, F4));
    }

    @Test(expected = IllegalStateException.class)
    public void whenMoveFall() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.move(C1, E4);
    }
}
