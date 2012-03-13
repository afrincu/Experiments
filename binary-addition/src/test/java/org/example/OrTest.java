package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrTest {

	@Test
	public void getOutput() {
		assertThat(new Or(Mass.getInstance(), Mass.getInstance()).getOutput(),
				instanceOf(Mass.class));
		assertThat(new Or(Mass.getInstance(), Vcc.getInstance()).getOutput(),
				instanceOf(Vcc.class));
		assertThat(new Or(Vcc.getInstance(), Mass.getInstance()).getOutput(),
				instanceOf(Vcc.class));
		assertThat(new Or(Vcc.getInstance(), Vcc.getInstance()).getOutput(),
				instanceOf(Vcc.class));

		Or x = new Or(Vcc.getInstance(), Vcc.getInstance());
		assertThat(new Or(x, x).getOutput(), instanceOf(Vcc.class));

	}

}
