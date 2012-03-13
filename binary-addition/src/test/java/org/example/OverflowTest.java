package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OverflowTest {

	@Test
	public void getOutput() {
		assertThat(
				new Overflow(Mass.getInstance(), Mass.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Overflow(Mass.getInstance(), Mass.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Overflow(Mass.getInstance(), Vcc.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Overflow(Mass.getInstance(), Vcc.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Vcc.class));
		assertThat(
				new Overflow(Vcc.getInstance(), Mass.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Overflow(Vcc.getInstance(), Mass.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Vcc.class));
		assertThat(
				new Overflow(Vcc.getInstance(), Vcc.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Vcc.class));
		assertThat(
				new Overflow(Vcc.getInstance(), Vcc.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Vcc.class));
	}
}
