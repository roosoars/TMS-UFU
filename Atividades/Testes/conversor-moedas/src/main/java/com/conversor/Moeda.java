package com.conversor;

public enum Moeda {
    DOLAR_AMERICANO("Dólar Americano", "USD"),
    DOLAR_AUSTRALIANO("Dólar Australiano", "AUD"),
    EURO_UNIAO_EUROPEIA("Euro da União Europeia", "EUR"),
    REAL_BRASILEIRO("Real Brasileiro", "BRL"),
    PESO_ARGENTINO("Peso Argentino", "ARS"),
    PESO_CHILENO("Peso Chileno", "CLP"),
    IENE_JAPONES("Iene Japonês", "JPY"),
    LIBRA_ESTERLINA("Libra Esterlina", "GBP"),
    WON_SULCOREANO("Won Sul-Coreano", "KRW"),
    FRANCO_SUIÇO("Franco Suíço", "CHF");

    private final String nome;
    private final String codigo;

    Moeda(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public static String obterCodigoPorNome(String nome) {
        for (Moeda moeda : Moeda.values()) {
            if (moeda.getNome().equalsIgnoreCase(nome)) {
                return moeda.getCodigo();
            }
        }
        return null;
    }
}
