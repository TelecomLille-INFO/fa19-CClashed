package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.HelloWorld;

public class TestHelloWorld {

	@Test
	public void testAdd() {
		HelloWorld hw = new HelloWorld();
		assertEquals(5, hw.add(2, 3));
		assertEquals(-2, hw.add(2, -4));
	}

}
