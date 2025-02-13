import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer operando (x1): ");
        double x1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo operando (x2): ");
        double x2 = scanner.nextDouble();

        System.out.print("Ingrese el operador (+, -, /, *): ");
        String operador = scanner.next();

        Operando operandoEnum;
        switch (operador) {
            case "+":
                operandoEnum = Operando.SUMA;
                break;
            case "-":
                operandoEnum = Operando.RESTA;
                break;
            case "/":
                operandoEnum = Operando.DIVISION;
                break;
            case "*":
                operandoEnum = Operando.MULTIPLICACION;
                break;
            default:
                System.out.println("Operador no válido.");
                return;
        }

        Operacion op = new Operacion(x1, x2, operandoEnum);
        ICalculadora calculadora = new CalculadoraImpl();
        double resultado = calculadora.calcular(op);

        System.out.println("El resultado es: " + resultado);
    }
}
