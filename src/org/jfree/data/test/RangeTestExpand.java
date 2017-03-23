package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;


/**
 * A Test Suit for testing expand function of Range class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class RangeTestExpand{

	private Range exampleRange;
	@BeforeClass
	public static void setUpBeforeClass()
			throws Exception{}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void expandWithInvalidRangeInputs(){	//Pass
		exampleRange = null;
		Range.expand(exampleRange, 0, 0);
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (-1, 1)
	 * expanded by (0, 0)
	 */
	@Test
	public void expandZeroTest(){		//Pass
		exampleRange = new Range(-1, 1);
		Range.expand(exampleRange, 0, 0);
		Range testRange = new Range(-1, 1);
		assertTrue("Range should be (-1,1)", testRange.equals(exampleRange));
	}



	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}


}
