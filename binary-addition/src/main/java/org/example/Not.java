package org.example;

public class Not extends CircuitComponent {

	private final CircuitComponent input;

	public Not(CircuitComponent input) {
		this.input = input;
	}

	@Override
	public Bit getOutput() {

		if (input.getOutput() instanceof Mass) {
			return Vcc.getInstance();
		} else {
			return Mass.getInstance();
		}

	}
}
