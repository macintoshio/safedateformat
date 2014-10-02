package io.macintosh.safedateformat;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class SafeSimpleDateFormatTest {
	
	private final static String FORMAT_STR = "yyyyMMddHHmmssSSS";
	private SafeSimpleDateFormat formatter;

	@Before
	public void setUp() throws Exception {
		formatter = new SafeSimpleDateFormat(FORMAT_STR);
	}

	@Test
	public void test_Parse_Format() throws ParseException {
		String dateStr = "20140203040506789";
		Date date = formatter.parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		assertEquals(2014, cal.get(Calendar.YEAR));
		assertEquals(1, cal.get(Calendar.MONTH));
		assertEquals(3, cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(4, cal.get(Calendar.HOUR));
		assertEquals(5, cal.get(Calendar.MINUTE));
		assertEquals(6, cal.get(Calendar.SECOND));
		assertEquals(789, cal.get(Calendar.MILLISECOND));
		
		String dateStr2  = formatter.format(date);
		assertEquals(dateStr, dateStr2);
	}

}
