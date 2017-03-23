package org.jfree.data.Assignment3Tests;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;
/**
 * A Test Suite for the function calculateColumnTotal from DataUtilities class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class DataUtilitiesTestCalculateColumn{
	Mockery mockingContext;
	Values2D values;

	@Before
	public void setup(){
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	null
	 * 	[1]	2.5
	 */
	@Test
	public void calculateColTotalForAMixtureOfNullsAndNonNulls() {	//Passed
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(null));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(2.5, result, .000000001d);
	}


	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	7.5
	 * 	[1]	2.5
	 */
	@Test
	public void calculateColumnTotalForTwoPositiveValues() {	//Passed
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(10.0, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	-5.6
	 * 	[1]	-4.4
	 */
	@Test
	public void calculateColumnTotalForTwoNegativeValues(){		//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-5.6));
				oneOf(values).getValue(1, 0);
				will(returnValue(-4.4));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(-10.0, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	Double.MAX_VALUE/2
	 * 	[1]	Double.MAX_VALUE/2)-1
	 */
	@Test
	public void calculateColumnTotalForCloseToPositiveMaxDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue((Double.MAX_VALUE/2)-1));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(Double.MAX_VALUE-1, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	Double.MAX_VALUE/2
	 * 	[1]	Double.MAX_VALUE/2
	 */
	@Test
	public void calculateColumnTotalAtMaxPositiveDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	Double.MAX_VALUE/2
	 * 	[1]	1+Double.MAX_VALUE/2
	 */
	@Test
	public void calculateColumnTotalPastMaxPositiveDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(1+Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(1+Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	-Double.MAX_VALUE/2
	 * 	[1]	1-Double.MAX_VALUE/2
	 */
	@Test
	public void calculateColumnTotalForCloseToNegativeMaxDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(1-Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	-Double.MAX_VALUE/2
	 * 	[1]	-Double.MAX_VALUE/2
	 */
	@Test
	public void calculateColumnTotalAtMaxNegativeDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(-Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateColumeTotal function from DataUtilities
	 * With the following values:
	 * 		[0]
	 * 	[0]	-Double.MAX_VALUE/2
	 * 	[1]	-1-Double.MAX_VALUE/2
	 */
	@Test
	public void calculateColumnTotalPastMaxNegativeDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(-1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(-1-Double.MAX_VALUE, result, .000000001d);
	}
}