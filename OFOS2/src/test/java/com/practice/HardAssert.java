package com.practice;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void hardAssertTest() {
		System.out.println("-----------step1----------");
		System.out.println("-----------step2----------");
		System.out.println("-----------step3----------");
		assertEquals("A", "A"); // not throw
		System.out.println("-----------step4----------");
		System.out.println("-----------step5----------");
		assertEquals("a", "b");
		fail();
		System.out.println("-----------step6----------");
		System.out.println("-----------step7----------");
	}

	@Test
	public void sampleTest() {
		System.out.println("-----------step6----------");
		System.out.println("-----------step7----------");
		int a = 10;
		assertNull(a);
		System.out.println("-----------step8----------");

	}

}
