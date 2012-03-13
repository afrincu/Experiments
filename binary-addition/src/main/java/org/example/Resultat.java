package org.example;

public class Resultat extends CircuitComponent {

	private final CircuitComponent a;
	private final CircuitComponent b;
	private final CircuitComponent o1;

	public Resultat(CircuitComponent a, CircuitComponent b, CircuitComponent o1) {
		this.a = a;
		this.b = b;
		this.o1 = o1;

	}

	@Override
	public Bit getOutput() {

		Overflow o = new Overflow(a, b, o1);

		return new Or(new And(new Or(new Or(a, b), o1), new Not(o)), new And(
				new And(a, b), new And(o1, o))).getOutput();
	}

}
