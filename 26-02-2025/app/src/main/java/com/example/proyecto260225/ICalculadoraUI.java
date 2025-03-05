package com.example.proyecto260225;

public interface ICalculadoraUI {

    CalculadoraMemoria memoria = null;
    void clearScreen();
    void showResult(String result);
    String addNumber(String numero);
    void addOperation(Operacion operation);

}
