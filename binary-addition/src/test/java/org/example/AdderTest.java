package org.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AdderTest {
	@Test
	public void getOutput() {

		Bit[] a = new Bit[] { Mass.getInstance(), Vcc.getInstance(),
				Mass.getInstance(), Vcc.getInstance(), Mass.getInstance(),
				Vcc.getInstance(), Vcc.getInstance() };
		Bit[] b = new Bit[] { Vcc.getInstance(), Mass.getInstance(),
				Mass.getInstance(), Mass.getInstance(), Mass.getInstance(),
				Mass.getInstance(), Mass.getInstance() };

		Bit[] y = new Bit[] { Mass.getInstance(), Vcc.getInstance(),
				Vcc.getInstance(), Mass.getInstance(), Vcc.getInstance(),
				Mass.getInstance(), Vcc.getInstance(), Vcc.getInstance() };

		assertThat(new Adder(a, b).getOutput(), is(y));

	}
}
