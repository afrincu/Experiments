package org.example;

public class Adder {

	private final Bit[] a;
	private final Bit[] b;

	public Adder(Bit[] a, Bit[] b) {

		if (a.length != b.length) {
			throw new IllegalArgumentException(
					"Expected a same length as b, got length of a " + a.length
							+ " different than length of b " + b.length);
		}

		this.a = a;
		this.b = b;
	}

	public Bit[] getOutput() {
		int n = a.length;

		Bit[] x = new Bit[n + 1];
		Bit[] m;
		m = new HalfAdder(a[0], b[0], Mass.getInstance()).getOutput();
		x[n] = m[1];
		System.out.println("last element of x is " + x[n]);

		for (int i = 1; i < n; i++) {
			m = new HalfAdder(a[i], b[i], m[0]).getOutput();
			x[n - i] = m[1];

		}
		x[0] = m[0];
		System.out.println("first element of x is " + x[0]);
		System.out.println("2nd element of x is " + x[1]);
		System.out.println("3rd element of x is " + x[2]);
		return x;
	}
}
