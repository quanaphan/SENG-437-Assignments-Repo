package org.jfree.data.Assignment4Ver;

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
		exampleRange = Range.expand(new Range(-1, 1), 0, 0);
		Range testRange = new Range(-1, 1);
		assertTrue("Range should be (-1,1)", testRange.equals(exampleRange));
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (0, 2)
	 * expanded by (0, 0.5)
	 */
	@Test
	public void expandUpperBoundTest(){		//Pass
		exampleRange = Range.expand(new Range(0, 2), 0, 0.5);
		Range testRange = new Range(0, 3);
		assertEquals("Range should be (0,3)", true, testRange.equals(exampleRange));
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (0, 2)
	 * expanded by (0.5, 0)
	 */
	@Test
	public void expandLowerBoundTest(){		//Fails
		exampleRange = Range.expand(new Range(0, 2), 0.5, 0);
		Range testRange = new Range(-1, 2);
		assertTrue("Range should be (-1,2)", testRange.equals(exampleRange));
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (2, 6)
	 * expanded by (0.25, 0.5)
	 */
	@Test
	public void expandBothBoundsTest(){		//Fails
		exampleRange = Range.expand(new Range(2, 6), 0.25, 0.5);
		Range testRange = new Range(1, 8);
		assertTrue("Range should be (1,8)", exampleRange.equals(testRange));
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (0, 2)
	 * expanded by (0, -0.5)
	 */
	@Test
	public void expandUpperBoundNegativeTest(){		//Passed
		exampleRange = Range.expand(new Range(0, 2), 0, -0.5);
		Range testRange = new Range(0, 1);
		assertTrue("Range should be (0,1)", testRange.equals(exampleRange));
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (0, 2)
	 * expanded by (-0.5, 0)
	 */
	@Test
	public void expandLowerBoundNegativeTest(){		//Fails
		exampleRange = Range.expand(new Range(0, 2), -0.5, 0);
		Range testRange = new Range(1, 2);
		assertTrue("Range should be (1,2)", testRange.equals(exampleRange));
	}

	/**
	 * Testing expand function of Range class
	 * With values:
	 * Range = (0, 2)
	 * expanded by (-0.25, -0.25)
	 */
	@Test
	public void expandBothBoundsNegativeTest(){		//Fails
		exampleRange = Range.expand(new Range(0, 4), -0.25, -0.25);
		Range testRange = new Range(1, 3);
		assertTrue("Range should be (1,3)", testRange.equals(exampleRange));
	}

	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}


}
