package org.example;

public class Adder2 {

	private final Bit a1;
	private final Bit b1;

	private final Bit a2;
	private final Bit b2;

	public Adder2(Bit a1, Bit b1, Bit a2, Bit b2) {

		this.a1 = a1;
		this.b1 = b1;

		this.a2 = a2;
		this.b2 = b2;
	}

	public Bit[] getOutput() {

		Bit[] x = new Bit[3];

		Bit[] m = new HalfAdder(a2, b2, new Adder1(a1, b1).getOutput()[0])
				.getOutput();
		x[0] = m[0];
		x[1] = m[1];

		x[2] = new Adder1(a1, b1).getOutput()[1];

		return x;

	}
}
