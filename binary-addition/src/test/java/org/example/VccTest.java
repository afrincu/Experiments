package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VccTest {

	@Test
	public void getOutput() {
		assertThat(Vcc.getInstance().getOutput(), instanceOf(Vcc.class));
		assertThat(Vcc.getInstance().getOutput(), is(Vcc.getInstance()));

	}
}
