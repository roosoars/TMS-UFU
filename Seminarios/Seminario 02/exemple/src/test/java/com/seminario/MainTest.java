package com.seminario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testSoma() {
        Main main = new Main();
        assertEquals(10, main.soma(2, 8), "A soma de 2 e 8 deve ser 10");
    }
}