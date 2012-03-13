package org.example;

public class And extends CircuitComponent {

	private final CircuitComponent input1;
	private final CircuitComponent input2;

	public And(CircuitComponent input1, CircuitComponent input2) {
		this.input1 = input1;
		this.input2 = input2;
	}

	public Bit getOutput() {
		if (input1.getOutput() instanceof Vcc
				&& input2.getOutput() instanceof Vcc) {
			return Vcc.getInstance();

		} else {
			return Mass.getInstance();

		}

	}
}
