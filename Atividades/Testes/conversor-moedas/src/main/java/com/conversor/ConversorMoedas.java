package main.java.com.conversor;

public class ConversorMoedas {
    private TaxaCambioProvider taxaCambioProvider;

    public ConversorMoedas(TaxaCambioProvider taxaCambioProvider) {
        this.taxaCambioProvider = taxaCambioProvider;
    }

    public double converter(String deMoeda, String paraMoeda, double valor) {
        double taxa = taxaCambioProvider.obterTaxaCambio(deMoeda, paraMoeda);
        return valor * taxa;
    }
}
