package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
	
	private Mockery mockingContext; 
	private Values2D values;
	private double result;
	@Before 
	public void setUp() { 
		mockingContext = new Mockery(); 
		values = mockingContext.mock(Values2D.class); 
		}
    @Test
    public void calculateColumnTotalForTwoValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(2));
            oneOf(values).getValue(0, 0);
            will(returnValue(7.5));
            oneOf(values).getValue(1, 0);
            will(returnValue(2.5));
        }});

        // exercise
        result = DataUtilities.calculateColumnTotal(values, 0);

        // verify
        assertEquals(10.0, result, .000000001d);

        // tear-down: NONE in this test method
    }
    @Test
    public void calculateColumnTotalNegativeValues() { 
         mockingContext.checking(new Expectations() {{
             oneOf(values).getRowCount();
             will(returnValue(2));
             oneOf(values).getValue(0, 0);
             will(returnValue(-7.5));
             oneOf(values).getValue(1, 0);
             will(returnValue(-2.5));
         }});
         result = DataUtilities.calculateColumnTotal(values, 0);

         // verify
         assertEquals(-10.0, result, -.000000001d);
    }
    @Test
    public void calculateColumnTotalForZeroValues() { 
    	mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(2));
            oneOf(values).getValue(0, 0);
            will(returnValue(0.0));
            oneOf(values).getValue(1, 0);
            will(returnValue(0.0));
        }});
    	 result = DataUtilities.calculateColumnTotal(values, 0);
    	 assertEquals(0.0, result, .000000000d);
    }
    @Test
    public void calculateColumnTotalWhenColumnIndexIsLastcolumnIndexPlusOne() { 
        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount(); 
            will(returnValue(2));
            oneOf(values).getColumnCount(); 
            will(returnValue(2));
            oneOf(values).getValue(0, 0);
            will(returnValue(0.0));
            oneOf(values).getValue(1, 0);
            will(returnValue(0.0));
            
        }});

        result = DataUtilities.calculateColumnTotal(values, 2);

        assertEquals(0.0, result, 0.000000000d);
    }

}