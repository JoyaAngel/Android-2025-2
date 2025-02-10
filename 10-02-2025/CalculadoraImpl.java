import java.io.*

class CalculadoraImpl implements ICalculadora{

	Double calcular(Operacion operacion){

		switch (Operacion.getOp()){

			case SUMA:
				return getX1() + getX2;
			default:
				return 0.0;

		}
		return 0.0;
	}

}
