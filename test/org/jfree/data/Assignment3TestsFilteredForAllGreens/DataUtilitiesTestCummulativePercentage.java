package org.jfree.data.Assignment3TestsFilteredForAllGreens;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;
/**
 * A Test Suite for the function getCummulativePercentage from DataUtilities class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class DataUtilitiesTestCummulativePercentage{
	Mockery mockingContext;

	@Before
	public void setup(){
		mockingContext = new Mockery();
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      3
	 * 1      4
	 * 2      5
	 */
	@Test
	public void getCummulativePercentagesWithThreeNumbers() {	//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(4));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(5));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {(3.0/(3.0+4.0+5.0)),((3.0+4.0)/(3.0+4.0+5.0)),1.0};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      -3
	 * 1      4
	 * 2      5
	 */
	@Test
	public void getCummulativePercentagesWithMixedPositivesAndNegatives() {		//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(-3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(4));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(5));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {((-3.0)/((-3.0)+4.0+5.0)),(((-3.0)+4.0)/((-3.0)+4.0+5.0)),1.0};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      0
	 * 1      0
	 * 2      0
	 */
	@Test
	public void getCummulativePercentagesWithZeros() {		//Pass
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(0));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(0));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(0));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {Double.NaN,Double.NaN,Double.NaN};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      -3
	 * 1      1
	 * 2      2
	 */
	@Test
	public void getCummulativePercentagesWithZeroSum() {	//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(-3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(1));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(2));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NaN};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      2
	 * 1      null
	 * 2      2
	 */
	@Test
	public void getCummulativePercentagesWithANullIndexValue() {	//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(-3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(null));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(2));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {0.5,0.5,1.0};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * Null	  Null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getCummulativePercentagesWithNullPointerForData() {	//Passed
		KeyedValues data = null;
		DataUtilities.getCumulativePercentages(data);
	}

}