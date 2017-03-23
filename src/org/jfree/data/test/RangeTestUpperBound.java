package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;


/**
 * A Test Suit for testing getUpperBound function of Range class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class RangeTestUpperBound{

	private Range exampleRange;
	@BeforeClass
	public static void setUpBeforeClass()
			throws Exception{}


	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (-1, 1)
	 */
	@Test
	public void simpleGetUpperBoundTest(){		//Passed
		exampleRange = new Range(-1,1);
		assertEquals("The upper bound of this range should be 1", 1.0, exampleRange.getUpperBound(), .000000001d);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (1, 3)
	 */
	@Test
	public void positiveRangeGetUpperBoundTest(){		//Passed
		exampleRange= new Range(1,3);
		assertEquals("The upper bound of this range should be 3", 3.0, exampleRange.getUpperBound(), .000000001d);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (-5, -2)
	 */
	@Test
	public void negativeRangeGetUpperBoundTest(){		//Passed
		exampleRange = new Range(-5, -2);
		assertEquals("The upper bound of this range should be -2", -2.0, exampleRange.getUpperBound(), .000000001d);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (1, 1)
	 */
	@Test
	public void singleValueRangeGetUpperBoundTest(){	//Pass
		exampleRange = new Range(1,1);
		assertEquals("The upper bound of this range should be 1", 1.0, exampleRange.getUpperBound(), .000000001d);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (0, Double.MAX_VALUE)
	 */
	@Test
	public void maxUpperRangeGetUpperBoundTest(){		//Passed
		exampleRange = new Range(0, Double.MAX_VALUE);
		assertEquals("The upper bound of this range should be the max double value", Double.MAX_VALUE, exampleRange.getUpperBound(), .000000001d);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (0, Double.MAX_VALUE + 1)
	 */
	@Test
	public void overMaxUpperRangeGetUpperBoundTest(){	//Passed
		exampleRange = new Range(0, Double.MAX_VALUE + 1);
		assertEquals("The upper bound of this range should be max double plus 1", Double.MAX_VALUE + 1, exampleRange.getUpperBound(), .000000001d);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range: (0, Double.MAX_VALUE - 1)
	 */
	@Test
	public void UnderMaxRangeGetUpperBoundTest(){		//Passed
		exampleRange = new Range(0, Double.MAX_VALUE - 1);
		assertEquals("The upper bound of this range should be max double minus 1", Double.MAX_VALUE - 1, exampleRange.getUpperBound(), .000000001d);
	}

	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}


}
