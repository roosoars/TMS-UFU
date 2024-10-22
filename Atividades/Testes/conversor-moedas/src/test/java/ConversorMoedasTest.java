package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import main.java.com.conversor.ConversorMoedas;
import main.java.com.conversor.TaxaCambioProvider;

public class ConversorMoedasTest  {

    @Test
    public void deveConverterUSDParaBRL() {
        
        TaxaCambioProvider taxaMock = mock(TaxaCambioProvider.class);
        when(taxaMock.obterTaxaCambio("USD", "BRL")).thenReturn(5.0);

        ConversorMoedas conversor = new ConversorMoedas(taxaMock);

        double resultado = conversor.converter("USD", "BRL", 10);

        assertEquals(50.0, resultado);
    }
}