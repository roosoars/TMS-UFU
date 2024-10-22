package main.java.com.conversor;

public class InterfaceUsuario {
    public String obterCodigoMoeda(String nomeMoeda) {
        return Moeda.obterCodigoPorNome(nomeMoeda);
    }
}
