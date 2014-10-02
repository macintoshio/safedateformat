package io.macintosh.safedateformat.sample;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class EnumSampleTest {
	
	private Date epoch;
	
	@Before
	public void setup() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1970);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		epoch = cal.getTime();
	}
	
	@Test
	public void test_Year() {
		String year = EnumSample.YEAR.extract(epoch);
		assertEquals("1970", year);
	}

	@Test
	public void test_Month() {
		String month = EnumSample.MONTH.extract(epoch);
		assertEquals("1", month);
	}

}
