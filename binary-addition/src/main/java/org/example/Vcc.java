package org.example;

public class Vcc extends Bit {

	private static final Vcc instance = new Vcc();

	private Vcc() {
	}

	public static Vcc getInstance() {
		return instance;
	}

	@Override
	public Vcc getOutput() {
		return this;
	}
}
