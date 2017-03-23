package org.jfree.data.Assignment3TestsFilteredForAllGreens;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.*;
/**
 * A Test Suite for the function createNumberArray2D from DataUtilities class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class DataUtilitiesTestNumberArray2D{

	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArray2D_WithNullData(){ //Passed
		double[][] data = null;
		DataUtilities.createNumberArray2D(data);
	}


	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0
	 */
	@Test
	public void createNumberArray2D_WithSingleValue(){ //Passed
		double[][] data = {{1.0}};
		Number[][] expecteds = {{1.0}};
		Number[][] actuals = DataUtilities.createNumberArray2D(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0   2.0   3.0   4.0
	 */
	@Test
	public void createNumberArray2D_WithMultipleValuesInARow(){ //Passed
		double[][] data = {{1.0,2.0,3.0,4.0}};
		Number[][] expecteds = {{1.0,2.0,3.0,4.0}};
		Number[][] actuals = DataUtilities.createNumberArray2D(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0
	 * 2.0
	 * 3.0
	 */
	@Test
	public void createNumberArray2D_With_MultipleValuesInAColumn(){ //Passed
		double[][] data = {{1.0},{2.0},{3.0}};
		Number[][] expecteds = {{1.0},{2.0},{3.0}};
		Number[][] actuals = DataUtilities.createNumberArray2D(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0
	 * null
	 * 3.0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArray2D_With_MultipleValuesInAColumn_Withnullinbetweenvalidvalues(){ //Passed
		double[][] data = {{1.0},null,{3.0}};
		DataUtilities.createNumberArray2D(data);
	}

	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * null
	 * 2.0
	 * null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArray2D_With_MultipleValuesInAColumn_Withnullattheendandbeginning(){ //Passed
		double[][] data = {null,{2.0},null};
		DataUtilities.createNumberArray2D(data);
	}


	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0   4.0   7.0
	 * 2.0   5.0   8.0
	 * 3.0   6.0   9.0
	 */
	@Test
	public void createNumberArray2D_With_Valid3x3Values(){ //Passed
		double[][] data = {{1.0, 4.0, 7.0}, {2.0, 5.0, 8.0}, {3.0, 6.0, 9.0}};
		Number[][] expecteds = {{1.0, 4.0, 7.0}, {2.0, 5.0, 8.0}, {3.0, 6.0, 9.0}};
		Number[][] actuals = DataUtilities.createNumberArray2D(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0         NaN   7.0
	 * 2.0         5.0   -INFINITY
	 * +INFINITY   6.0   9.0
	 */
	@Test
	public void createNumberArray2D_With_NaNorinfinityValuesInA3z3(){ //Passed
		double[][] data = {{1.0, 4.0, Double.POSITIVE_INFINITY}, {Double.NaN, 5.0, 8.0}, {3.0, Double.NEGATIVE_INFINITY, 9.0}};
		Number[][] expecteds = {{1.0, 4.0, Double.POSITIVE_INFINITY}, {Double.NaN, 5.0, 8.0}, {3.0, Double.NEGATIVE_INFINITY, 9.0}};
		Number[][] actuals = DataUtilities.createNumberArray2D(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray2D() function from DataUtility with the following data:
	 * 1.0   MIN   MAX_EXPONENTIAL
	 * 2.0   5.0   MIN_EXPONENTIAL
	 * MAX   6.0   9.0
	 */
	@Test
	public void createNumberArray2D_With_MixtureOfMinAndMaxOfRegAndExponential_InA3x3(){ //Passed
		double[][] data = {{1.0, 4.0, Double.MAX_VALUE}, {Double.MIN_VALUE, 5.0, 8.0}, {Double.MAX_EXPONENT, Double.MIN_EXPONENT, 9.0}};
		Number[][] expecteds = {{1.0, 4.0, (double)Double.MAX_VALUE}, {(double)Double.MIN_VALUE, 5.0, 8.0}, {(double)Double.MAX_EXPONENT, (double)Double.MIN_EXPONENT, 9.0}};
		Number[][] actuals = DataUtilities.createNumberArray2D(data);
		assertArrayEquals(expecteds, actuals);
	}

}