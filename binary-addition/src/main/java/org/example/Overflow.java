package org.example;

public class Overflow extends CircuitComponent {

	private final CircuitComponent a;
	private final CircuitComponent b;
	private final CircuitComponent o;

	public Overflow(CircuitComponent a, CircuitComponent b, CircuitComponent o) {

		this.a = a;
		this.b = b;
		this.o = o;
	}

	@Override
	public Bit getOutput() {

		return new Or(new Or(new And(a, b), new And(a, o)), new And(b, o))
				.getOutput();

	}
}
