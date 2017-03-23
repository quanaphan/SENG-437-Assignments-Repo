package org.jfree.data.Assignment4Ver;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

/**
 * A Test Suite for the function calculateRowTotal from DataUtilities class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class DatautilitiesTestCalculateRow{
	Mockery mockingContext;
	Values2D values;

	@Before
	public void setup(){
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]		[1]
	 * 	[0]	null	2.5
	 */
	@Test
	public void calculateRowTotalForAMixtureOfNullsAndNonNulls() {	//Passed
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(null));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(2.5, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]		[1]
	 * 	[0]	7.5		2.5
	 */
	@Test
	public void calculateRowTotalForTwoPositiveValues() {	//Passed
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(10.0, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]		[1]
	 * 	[0]	-5.6	-4.4
	 */
	@Test
	public void calculateRowTotalForTwoNegativeValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-5.6));
				oneOf(values).getValue(0, 1);
				will(returnValue(-4.4));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(-10.0, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]						[1]
	 * 	[0]	Double.MAX_VALUE/2		(Double.MAX_VALUE/2)-1
	 */
	@Test
	public void calculateRowTotalForCloseToPositiveMaxDoubleValues(){ 	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(0, 1);
				will (returnValue((Double.MAX_VALUE/2)-1));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(Double.MAX_VALUE-1, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]						[1]
	 * 	[0]	Double.MAX_VALUE/2		(Double.MAX_VALUE/2)
	 */
	@Test
	public void calculateRowTotalAtMaxPositiveDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(0, 1);
				will (returnValue(Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]						[1]
	 * 	[0]	Double.MAX_VALUE/2		1+(Double.MAX_VALUE/2)
	 */
	@Test
	public void calculateRowTotalPastMaxPositiveDoubleValues(){		//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(0, 1);
				will (returnValue(1+Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(1+Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]						[1]
	 * 	[0]	-Double.MAX_VALUE/2		1-(Double.MAX_VALUE/2)
	 */
	@Test
	public void calculateRowTotalForCloseToNegativeMaxDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(0, 1);
				will (returnValue(1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(1-Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]						[1]
	 * 	[0]	-Double.MAX_VALUE/2		-(Double.MAX_VALUE/2)
	 */
	@Test
	public void calculateRowTotalAtMaxNegativeDoubleValues(){	//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(0, 1);
				will (returnValue(-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(-Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * Testing calculateRowTotal function from DataUtilities
	 * With the following values:
	 * 		[0]						[1]
	 * 	[0]	-Double.MAX_VALUE/2		-1-(Double.MAX_VALUE/2)
	 */
	@Test
	public void calculateRowTotalPastMaxNegativeDoubleValues(){		//Passed
		mockingContext.checking(new Expectations(){
			{
				atLeast(1).of(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(0, 1);
				will (returnValue(-1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(-1-Double.MAX_VALUE, result, .000000001d);
	}

}