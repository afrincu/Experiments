package org.example;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ResultatTest {

	@Test
	public void getOutput() {

		assertThat(
				new Resultat(Mass.getInstance(), Mass.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Resultat(Mass.getInstance(), Mass.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Vcc.class));
		assertThat(
				new Resultat(Mass.getInstance(), Vcc.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Vcc.class));
		assertThat(
				new Resultat(Mass.getInstance(), Vcc.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Resultat(Vcc.getInstance(), Mass.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Vcc.class));
		assertThat(
				new Resultat(Vcc.getInstance(), Mass.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Resultat(Vcc.getInstance(), Vcc.getInstance(),
						Mass.getInstance()).getOutput(), instanceOf(Mass.class));
		assertThat(
				new Resultat(Vcc.getInstance(), Vcc.getInstance(),
						Vcc.getInstance()).getOutput(), instanceOf(Vcc.class));
	}
}
