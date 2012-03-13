package org.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Adder2Test {

	@Test
	public void getOutput() {

		Bit[] m = new Bit[] { Mass.getInstance(), Vcc.getInstance(),
				Vcc.getInstance() };

		assertThat(
				new Adder2(Mass.getInstance(), Vcc.getInstance(),
						Mass.getInstance(), Vcc.getInstance()).getOutput(),
				is(m));
	}
}
