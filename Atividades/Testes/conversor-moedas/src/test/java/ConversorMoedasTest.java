
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.conversor.ConversorMoedas;
import com.conversor.InterfaceUsuario;
import com.conversor.MoedaNaoSuportadaException;
import com.conversor.TaxaCambioProvider;


public class ConversorMoedasTest {

    private TaxaCambioProvider taxaMock;
    private InterfaceUsuario interfaceMock;
    private ConversorMoedas conversor;

    @BeforeEach
    public void setUp() {
        taxaMock = mock(TaxaCambioProvider.class);
        interfaceMock = mock(InterfaceUsuario.class);
        conversor = new ConversorMoedas(taxaMock, interfaceMock);
    }

    @Test
    public void deveConverterUSDParaBRL() {
        when(interfaceMock.obterCodigoMoeda("Dólar Americano")).thenReturn("USD");
        when(interfaceMock.obterCodigoMoeda("Real Brasileiro")).thenReturn("BRL");
        when(taxaMock.obterTaxaCambio("USD", "BRL")).thenReturn(5.0);

        double resultado = conversor.converter("Dólar Americano", "Real Brasileiro", 10);

        assertEquals(50.0, resultado);
    }

    @Test
    public void deveConverterBRLParaUSD() {
        when(interfaceMock.obterCodigoMoeda("Real Brasileiro")).thenReturn("BRL");
        when(interfaceMock.obterCodigoMoeda("Dólar Americano")).thenReturn("USD");
        when(taxaMock.obterTaxaCambio("BRL", "USD")).thenReturn(0.2);

        double resultado = conversor.converter("Real Brasileiro", "Dólar Americano", 50);

        assertEquals(10.0, resultado);
    }

    @Test
    public void deveLancarExcecaoParaMoedaNaoSuportada() {
        when(interfaceMock.obterCodigoMoeda("Moeda Inexistente")).thenReturn(null);

        Exception exception = assertThrows(MoedaNaoSuportadaException.class, () -> {
            conversor.converter("Moeda Inexistente", "Real Brasileiro", 10);
        });

        assertEquals("Moeda não suportada", exception.getMessage());
    }

    @Test
    public void deveChamarObterTaxaCambioComParametrosCorretos() {
        when(interfaceMock.obterCodigoMoeda("Euro da União Europeia")).thenReturn("EUR");
        when(interfaceMock.obterCodigoMoeda("Iene Japonês")).thenReturn("JPY");
        when(taxaMock.obterTaxaCambio("EUR", "JPY")).thenReturn(130.0);

        conversor.converter("Euro da União Europeia", "Iene Japonês", 20);

        verify(taxaMock, times(1)).obterTaxaCambio("EUR", "JPY");
    }

    @Test
    public void deveLancarExcecaoParaValorNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            conversor.converter("Dólar Americano", "Real Brasileiro", -10);
        });

        assertEquals("Valor não pode ser negativo", exception.getMessage());
    }
}
