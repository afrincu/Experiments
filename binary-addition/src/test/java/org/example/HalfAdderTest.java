package org.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HalfAdderTest {

	@Test
	public void getOutput() {
		Bit[] m = new Bit[] { Mass.getInstance(), Vcc.getInstance() };
		assertThat(
				new HalfAdder(Mass.getInstance(), Vcc.getInstance(),
						Mass.getInstance()).getOutput(), is(m));
	}
}
