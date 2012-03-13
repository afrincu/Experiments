package org.example;

public class Adder3 {

	private final Bit a1;
	private final Bit b1;

	private final Bit a2;
	private final Bit b2;

	private final Bit a3;
	private final Bit b3;

	public Adder3(Bit a1, Bit b1, Bit a2, Bit b2, Bit a3, Bit b3) {

		this.a1 = a1;
		this.b1 = b1;

		this.a2 = a2;
		this.b2 = b2;

		this.a3 = a3;
		this.b3 = b3;
	}

	public Bit[] getOutput() {

		Bit[] x = new Bit[4];
		Bit[] m;

		m = new HalfAdder(a1, b1, Mass.getInstance()).getOutput();
		x[3] = m[1];

		m = new HalfAdder(a2, b2, m[0]).getOutput();
		x[2] = m[1];

		m = new HalfAdder(a3, b3, m[0]).getOutput();
		x[1] = m[1];

		x[0] = m[0];

		return x;

	}
}
