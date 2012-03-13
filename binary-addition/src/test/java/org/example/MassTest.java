package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MassTest {

	@Test
	public void getOutput() {
		assertThat(Mass.getInstance().getOutput(), instanceOf(Mass.class));
		assertThat(Mass.getInstance().getOutput(), is(Mass.getInstance()));

	}
}
