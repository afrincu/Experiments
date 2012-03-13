package org.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HelloTest {

	@Test
	public void getString() {
		assertThat(Hello.getString(), is("Hello world!"));
	}
}
