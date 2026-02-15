package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class Sample {

	@Test
	public void calculateColumnTotalForNullColumnValue() { 
	    Mockery context = new Mockery(); 
	    final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {{
	        oneOf(values).getRowCount(); will(returnValue(1));
	        oneOf(values).getColumnCount(); will(returnValue(1));
	        oneOf(values).getValue(0, 0); will(returnValue(null));
	    }});
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(0.0, result, 0.0000001);
	}


}
