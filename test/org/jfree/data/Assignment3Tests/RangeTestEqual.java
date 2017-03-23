package org.jfree.data.Assignment3Tests;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;


/**
 * A Test Suit for testing equals function of Range class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class RangeTestEqual{

	private Range exampleRange;
	@BeforeClass
	public static void setUpBeforeClass()
			throws Exception{}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range 1: (-1, 1)
	 * Range 2: null
	 */
	@Test
	public void equalsWithNullRangeTest(){ //Passed
		exampleRange = new Range(-1,1);
		Range exampleRange2 = null;
		boolean equal = exampleRange.equals(exampleRange2);
		assertEquals("The boolean should be false", false, equal);

	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range 1: (-1, 1)
	 * Range 2: (-1, 1)
	 */
	@Test
	public void SimpleEqualsTest() { 		//Pass
		Range exampleRange1 = new Range(-1,1);
		Range exampleRange2 = new Range(-1,1);
		boolean areSame = exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be the equal",true,areSame);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range 1: (-1, 1)
	 * Range 2: (-600, -500)
	 */
	@Test
	public void SimpleNotEqualsTest() {		 //Pass
		Range exampleRange1 = new Range(-1,1);
		Range exampleRange2 = new Range(-600,-500);
		boolean areDifferent = !exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should not be equal",true,areDifferent);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range 1: (-Double.MAX_VALUE, Double.MAX_VALUE)
	 * Range 2: (-Double.MAX_VALUE, Double.MAX_VALUE)
	 */
	@Test
	public void MaxRangeEqualTest() { 	//Pass
		Range exampleRange1 = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
		Range exampleRange2 = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
		boolean areSame = exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be equal",true,areSame);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range 1: (-Double.MAX_VALUE-1, Double.MAX_VALUE+1)
	 * Range 2: (-Double.MAX_VALUE-1, Double.MAX_VALUE+1)
	 */
	@Test
	public void OverMaxRangeEqualTest() {	 //Pass
		Range exampleRange1 = new Range(-Double.MAX_VALUE-1,Double.MAX_VALUE+1);
		Range exampleRange2 = new Range(-Double.MAX_VALUE-1,Double.MAX_VALUE+1);
		boolean areSame = exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be equal",true,areSame);
	}

	/**
	 * Testing equal function from Range class
	 * With data:
	 * Range 1: (-Double.MAX_VALUE-1, Double.MAX_VALUE+1)
	 * Range 2: (-Double.MAX_VALUE-1, Double.MAX_VALUE+1)
	 */
	@Test
	public void overMaxRangeNotEqualTest() {	 //Fail
		Range exampleRange1 = new Range(-Double.MAX_VALUE-1,Double.MAX_VALUE+1);
		Range exampleRange2 = new Range(-Double.MAX_VALUE-2,Double.MAX_VALUE+2);
		boolean areDifferent = !exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be equal",true,areDifferent);
	}

	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}


}
