package org.example;

public class Adder1 {
	private final Bit a1;
	private final Bit b1;

	public Adder1(Bit a1, Bit b1) {

		this.a1 = a1;
		this.b1 = b1;
	}

	public Bit[] getOutput() {

		return new HalfAdder(a1, b1, Mass.getInstance()).getOutput();
	}
}
