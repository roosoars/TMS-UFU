package com.seminario;

public class Main {

    // Método simples para ser testado
    public int soma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int resultado = main.soma(2, 8);
        System.out.println("Resultado da soma: " + resultado);

    }
}