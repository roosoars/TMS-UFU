package com.seminario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testSoma() {
        Main main = new Main();
        assertEquals(5, main.soma(2, 3), "A soma de 2 e 3 deve ser 5");
    }
}