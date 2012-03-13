package org.example;

public class Mass extends Bit {

	private static final Mass instance = new Mass();

	private Mass() {
	}

	public static Mass getInstance() {
		return instance;
	}

	@Override
	public Mass getOutput() {
		return this;
	}

}
