package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AndTest {

	@Test
	public void getOutput() {

		assertThat(new And(Mass.getInstance(), Mass.getInstance()).getOutput(),
				instanceOf(Mass.class));
		assertThat(new And(Mass.getInstance(), Vcc.getInstance()).getOutput(),
				instanceOf(Mass.class));
		assertThat(new And(Vcc.getInstance(), Mass.getInstance()).getOutput(),
				instanceOf(Mass.class));
		assertThat(new And(Vcc.getInstance(), Vcc.getInstance()).getOutput(),
				instanceOf(Vcc.class));

		And and1 = new And(Vcc.getInstance(), Vcc.getInstance());
		assertThat(new And(and1, and1).getOutput(), instanceOf(Vcc.class));

	}
}
