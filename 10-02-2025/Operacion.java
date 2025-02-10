class Operacion{

	private Double x1, x2;
	private	Operando op;

	Operando(Double x1, Double x2, Operacion op){

		this.x1 = x1;
		this.x2 = x2;
		this.op = op;

	}

	public Double getX1(){

		return this.x1;

	}

	public Double getX2(){

		return this.x2;

	}

	public Double getOp(){

		return this.op;

	}

}
