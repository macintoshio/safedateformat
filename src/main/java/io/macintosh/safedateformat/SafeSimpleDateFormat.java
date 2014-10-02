package io.macintosh.safedateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A thread-safe implementation of SimpleDateFormat. This uses
 * Java's thread-safe ThreadLocal class to create a unique
 * instance per-thread of the unsafe SimpleDateFormat class.
 * This avoids typical multi-threaded problems that arise from
 * using SimpleDateFormat in multi-threaded situations.
 */
public class SafeSimpleDateFormat {
	private final ThreadLocal<SimpleDateFormat> formatter;

	public SafeSimpleDateFormat(final String formatStr) {
		formatter = new ThreadLocal<SimpleDateFormat>(){
        	@Override
        	protected SimpleDateFormat initialValue()
        	{
        	    return new SimpleDateFormat(formatStr);
        	}
		};
	}
	
	public Date parse(String source) throws ParseException {
		return formatter.get().parse(source);
	}
	
	public String format(Date date) {
		return formatter.get().format(date);
	}
}
