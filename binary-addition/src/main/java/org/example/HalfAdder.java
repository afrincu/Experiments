package org.example;

public class HalfAdder {

	private final CircuitComponent a;
	private final CircuitComponent b;
	private final CircuitComponent o1;

	public HalfAdder(CircuitComponent a, CircuitComponent b, CircuitComponent o1) {

		this.a = a;
		this.b = b;
		this.o1 = o1;
	}

	public Bit[] getOutput() {

		Overflow o = new Overflow(a, b, o1);
		Resultat r = new Resultat(a, b, o1);

		return new Bit[] { o.getOutput(), r.getOutput() };
	}
}
