package main.java.com.conversor;

public class MoedaNaoSuportadaException extends RuntimeException {
    public MoedaNaoSuportadaException(String mensagem) {
        super(mensagem);
    }
}
