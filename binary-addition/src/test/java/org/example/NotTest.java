package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NotTest {
	@Test
	public void getOutput() {

		assertThat(new Not(Vcc.getInstance()).getOutput(),
				instanceOf(Mass.class));
		assertThat(new Not(Mass.getInstance()).getOutput(),
				instanceOf(Vcc.class));

		assertThat(new Not(new Not(Vcc.getInstance())).getOutput(),
				instanceOf(Vcc.class));

		assertThat(new Not(new Not(Mass.getInstance())).getOutput(),
				instanceOf(Mass.class));

	}
}
