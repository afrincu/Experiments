package org.example;

//import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Adder1Test {

	@Test
	public void getOutput() {

		Bit[] m = new Bit[] { Mass.getInstance(), Vcc.getInstance() };

		assertThat(
				new Adder1(Mass.getInstance(), Vcc.getInstance()).getOutput(),
				is(m));

	}
}
