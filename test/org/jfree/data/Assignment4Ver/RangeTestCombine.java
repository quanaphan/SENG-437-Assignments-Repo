package org.jfree.data.Assignment4Ver;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;


/**
 * A Test Suit for testing combine function of Range class
 *
 * @author Group 8 - Quan, Alex, Sebastian, Carlos
 *
 */
public class RangeTestCombine{

	private Range exampleRange;
	@BeforeClass
	public static void setUpBeforeClass()
			throws Exception{}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (0, 1)
	 * Range 2: (0, 1)
	 */
	@Test
	public void combineSameRange(){		//Pass
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(0,1)).equals(new Range(0,1)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (0, 2)
	 * Range 2: (0, 1)
	 */
	public void combineLargerUpperRangeFirstParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(new Range(0,2), exampleRange).equals(new Range(0,2)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (0, 1)
	 * Range 2: (0, 2)
	 */
	@Test
	public void combineLargerUpperRangeSecondParam(){	//Pass
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(0,2)).equals(new Range(0,2)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (-1, 0)
	 * Range 2: (0, 1)
	 */
	@Test
	public void combineLargerLowerRangeFirstParam(){	//Error
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(new Range(-1,0), exampleRange).equals(new Range(-1,1)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (0, 1)
	 * Range 2: (-1, 0)
	 */
	@Test
	public void combineLargerLowerRangeSecondParam(){	//Pass
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(-1,0)).equals(new Range(-1,1)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (-1, 2)
	 * Range 2: (0, 1)
	 */
	@Test
	public void combineLargerRangeFirstParam(){		//Error
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(new Range(-1,2), exampleRange).equals(new Range(-1,2)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (0, 1)
	 * Range 2: (-1, 2)
	 */
	@Test
	public void combineLargerRangeSecondParam(){		//Pass
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(-1,2)).equals(new Range(-1,2)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: null
	 * Range 2: null
	 */
	@Test
	public void combineBothNull(){		//Pass
		exampleRange = null;
		assertNull(Range.combine(null, exampleRange));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: null
	 * Range 2: (0, 1)
	 */
	@Test
	public void combineFirstNull(){		//Pass
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(null, exampleRange).equals(new Range(0,1)));
	}

	/**
	 * Testing combine function from Range class
	 * With data:
	 * Range 1: (0, 1)
	 * Range 2: null
	 */
	@Test
	public void combineSecondNull(){		//Pass
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, null).equals(new Range(0,1)));
	}

	@After
	public void tearDown() throws Exception{}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{}


}
