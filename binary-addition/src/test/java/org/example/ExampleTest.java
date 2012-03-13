package org.example;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {

	public void getOutput() {

		assertThat(123, is(156));
	}

}
