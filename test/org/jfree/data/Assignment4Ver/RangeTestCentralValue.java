package org.jfree.data.Assignment4Ver;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;


/**
 * A Test Suit for testing getCentralValue function of Range class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class RangeTestCentralValue{

	private Range exampleRange;
	@BeforeClass
	public static void setUpBeforeClass()
			throws Exception{}

	/**
	 * Testing Invalid Construction of Range class
	 * With data:
	 * Range: (1, -1)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithInvalidRangeInputs(){ //Passed
		exampleRange = new Range(1,-1);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-1, 1)
	 */
	@Test
	public void simpleZeroCentralValueTest(){		//Pass
		exampleRange= new Range(-1,1);
		assertEquals("The central value of -1 and 1 should 0", 0.0, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (1, 3)
	 */
	@Test
	public void centralPositiveValueTest(){			//Pass
		exampleRange = new Range(1,3);
		assertEquals("The central value of 1 and 3 should be 2", 2.0, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-3, -1)
	 */
	@Test
	public void centralNegativeValueTest(){			//Pass
		exampleRange = new Range(-3,-1);
		assertEquals("The central value of -3 and -1 should be -2", -2.0, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (1, 2)
	 */
	@Test
	public void centralFloatingPointValueTest(){	//Pass
		exampleRange = new Range(1,2);
		assertEquals("The central value of 1 and 2 should be 1.5", 1.5, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (1. 1)
	 */
	@Test
	public void singleValueRangeCentralValueTest(){	//Pass
		exampleRange = new Range(1,1);
		assertEquals("The central value of 1 and -1 should be 0", 1.0, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-Double.MAX_VALUE, Double.MAX_VALUE)
	 */
	@Test
	public void centralValueMaxRangeTest(){		//Pass
		exampleRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
		assertEquals("IDk", 0, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-Double.MAX_VALUE-1, Double.MAX_VALUE+1)
	 */
	@Test
	public void centralValueOverMaxRangeTest(){	//Pass
		exampleRange = new Range(-Double.MAX_VALUE-1, Double.MAX_VALUE+1);
		assertEquals("The central value of 1 extra from the max double value should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-Double.MAX_VALUE+1, Double.MAX_VALUE-1)
	 */
	@Test
	public void centralValueCloseToMaxRangeTest(){	//Pass
		exampleRange = new Range(-Double.MAX_VALUE+1, Double.MAX_VALUE-1);
		assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .0000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-Integer.MAX_VALUE, Integer.MAX_VALUE)
	 */
	@Test
	public void centralValueMaxIntegerTest(){		//Pass
		exampleRange = new Range(-Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertEquals("The central value of max integer values should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}


	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-Integer.MAX_VALUE+1, Integer.MAX_VALUE-1)
	 */
	@Test
	public void centralValueCloseToIntegerMaxRangeTest(){	//Pass
		exampleRange = new Range(-Integer.MAX_VALUE+1, Integer.MAX_VALUE-1);
		assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .0000000001d);
	}

	/**
	 * Testing getCentralValue function from Range class
	 * With data:
	 * Range: (-Integer.MAX_VALUE+3, Integer.MAX_VALUE-1)
	 */
	@Test
	public void centralValueCloseToIntegerMaxRangeTest2(){	//Pass
		exampleRange = new Range(-Integer.MAX_VALUE+3, Integer.MAX_VALUE-1);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}


	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}


}
