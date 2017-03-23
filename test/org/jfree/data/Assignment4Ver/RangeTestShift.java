package org.jfree.data.Assignment4Ver;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestShift {

	private Range exampleRange;
	@BeforeClass
	public static void setUpBeforeClass()
			throws Exception{}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = null
	 */
	@Test
	public void positiveShiftTest(){
		exampleRange = Range.shift(new Range(3,6), 2);
		assertTrue("should be 5 to 8 ", exampleRange.equals(new Range(5,8)));
	}

	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}
}
