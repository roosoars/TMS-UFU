package main.java.com.conversor;

public class ConversorMoedas {
    private final TaxaCambioProvider taxaCambioProvider;
    private final InterfaceUsuario interfaceUsuario;

    public ConversorMoedas(TaxaCambioProvider taxaCambioProvider, InterfaceUsuario interfaceUsuario) {
        this.taxaCambioProvider = taxaCambioProvider;
        this.interfaceUsuario = interfaceUsuario;
    }

    public double converter(String nomeDeMoeda, String nomeParaMoeda, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }

        String deMoeda = interfaceUsuario.obterCodigoMoeda(nomeDeMoeda);
        String paraMoeda = interfaceUsuario.obterCodigoMoeda(nomeParaMoeda);

        if (deMoeda == null || paraMoeda == null) {
            throw new MoedaNaoSuportadaException("Moeda não suportada");
        }

        double taxa = taxaCambioProvider.obterTaxaCambio(deMoeda, paraMoeda);
        return valor * taxa;
    }
}
