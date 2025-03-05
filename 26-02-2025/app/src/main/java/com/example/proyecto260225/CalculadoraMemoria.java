package com.example.proyecto260225;

public class CalculadoraMemoria implements ICalculadoraMemoria{

    String display = "";
    Operacion operation;

    @Override
    public String concat(String numero) {
        display += numero;
        return display;
    }

    @Override
    public String concat(Operacion operation) {
        this.operation = operation;
        return Operacion.convert(operation);
    }

    @Override
    public void clear() {
        display = "";
        //operation = null;
    }
}
