package io.macintosh.safedateformat.sample;

import java.util.Date;
import io.macintosh.safedateformat.SafeSimpleDateFormat;

/**
 * A simple example using the SafeSimpleDateFormat class as a
 * static member.
 */
public class StaticSample {
	private final static SafeSimpleDateFormat formatter = new SafeSimpleDateFormat("yyyyMMddHHmmssSSS");
	
	public String getCurrentDatestamp() {
		Date now = new Date();
		String dateStamp = formatter.format(now);
		return dateStamp;
	}
}
