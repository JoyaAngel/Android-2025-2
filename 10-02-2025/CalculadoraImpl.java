import java.io.*;

class CalculadoraImpl implements ICalculadora {

    @Override
    public Double calcular(Operacion operacion) {
        switch (operacion.getOp()) {
            case SUMA:
                return operacion.getX1() + operacion.getX2();
            case RESTA:
                return operacion.getX1() - operacion.getX2();
            case MULTIPLICACION:
                return operacion.getX1() * operacion.getX2();
            case DIVISION:
                if (operacion.getX2() == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operacion.getX1() / operacion.getX2();
            default:
                throw new IllegalArgumentException("Operación no soportada");
        }
    }
}
