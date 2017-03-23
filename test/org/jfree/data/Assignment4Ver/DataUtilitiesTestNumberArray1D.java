package org.jfree.data.Assignment4Ver;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.*;
/**
 * A Test Suite for the function createNumberArray from DataUtilities class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class DataUtilitiesTestNumberArray1D{

	/**
	 * calling createNumberArray() function from DataUtility using five (an abitrary number) doubles
	 */
	@Test
	public void createNumberArrayWithFiveDoubles(){		//Passed
		//setup
		double[] data = {1.2,2.2,3.2,4.2,5.2};
		Number[] expecteds = {1.2,2.2,3.2,4.2,5.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with null data
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArrayWithNullData(){	//Passed
		//setup
		double[] data = null;
		DataUtilities.createNumberArray(data);
	}

	/**
	 * calling createNumberArray() function from DataUtility with only 1 double in the array
	 */
	@Test
	public void createNumberArrayWithOneDouble(){		//Passed
		//setup
		double[] data = {1.2};
		Number[] expecteds = {1.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray() function from DataUtility by initializing data with a single int
	 */
	@Test
	public void createNumberArrayWithOneInt(){		//Passed
		//setup
		double[] data = {1};
		Number[] expecteds = {1.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility by initializing data with 10 ints
	 */
	@Test
	public void createNumberArrayWithTenInt(){		//Passed
		//setup
		double[] data = {0,1,2,3,4,5,6,7,8,9};
		Number[] expecteds = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with negatives
	 */
	@Test
	public void createNumberArrayWithNegativeDoubles(){		//Passed
		//setup
		double[] data = {-1.3,2.3,0.0};
		Number[] expecteds = {-1.3,2.3,0.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with max values for doubles mixed in data
	 */
	@Test
	public void createNumberArrayWithMaxValue(){	//Passed
		//setup
		double[] data = {1.2,Double.MAX_VALUE,-3.4};
		Number[] expecteds = {1.2,Double.MAX_VALUE,-3.4};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray() function from DataUtility with NaN mixed in data
	 */
	@Test
	public void createNumberArrayWithNaN(){		//Passed
		//setup
		double[] data = {1.2,3.4,Double.NaN, 2.0};
		Number[] expecteds = {1.2,3.4,Double.NaN, 2.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with Double's Min value
	 */
	@Test
	public void createNumberArrayWithMinValue(){	//Passed
		//setup
		double[] data = {1.2,3.4,4.5,-1.2,Double.MIN_VALUE,3.2};
		Number[] expecteds = {1.2,3.4,4.5,-1.2,Double.MIN_VALUE,3.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


}