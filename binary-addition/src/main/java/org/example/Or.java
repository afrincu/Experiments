package org.example;

public class Or extends CircuitComponent {

	private final CircuitComponent input1;
	private final CircuitComponent input2;

	public Or(CircuitComponent input1, CircuitComponent input2) {
		this.input1 = input1;
		this.input2 = input2;
	}

	@Override
	public Bit getOutput() {
		if (input1.getOutput() instanceof Mass
				&& input2.getOutput() instanceof Mass) {
			return Mass.getInstance();
		} else {
			return Vcc.getInstance();

		}

	}

}
