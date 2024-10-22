package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.conversor.InterfaceUsuario;


public class InterfaceUsuarioTest {

    private InterfaceUsuario interfaceUsuario;

    @BeforeEach
    public void setUp() {
        interfaceUsuario = new InterfaceUsuario();
    }

    @Test
    public void deveConverterNomeMoedaParaCodigo() {
        String codigoUSD = interfaceUsuario.obterCodigoMoeda("Dólar Americano");
        String codigoEUR = interfaceUsuario.obterCodigoMoeda("Euro da União Europeia");
        String codigoBRL = interfaceUsuario.obterCodigoMoeda("Real Brasileiro");
        String codigoInvalido = interfaceUsuario.obterCodigoMoeda("Moeda Inexistente");

        assertEquals("USD", codigoUSD);
        assertEquals("EUR", codigoEUR);
        assertEquals("BRL", codigoBRL);
        assertNull(codigoInvalido);
    }
}
