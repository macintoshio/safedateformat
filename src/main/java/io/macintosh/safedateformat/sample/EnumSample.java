package io.macintosh.safedateformat.sample;

import io.macintosh.safedateformat.SafeSimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Example of using SafeSimpleDateFormat in an enum class.
 * This class defines a couple of different ways to get
 * data from a date into a string.
 * Example usage:
 *   Date date = new Date();
 *   String year = EnumSample.YEAR.extract(date);
 */
public enum EnumSample {
	YEAR {
		/* This YEAR enum value doesn't (and can't!) define its formatter
		 * as a static member. But, because this enum value is
		 * actually a singleton (only one exists in the Java runtime),
		 * there is a multi-threaded problem. So such members must be
		 * made thread-safe if running in a multi-threaded app.
		 */
		private final SafeSimpleDateFormat formatter = new SafeSimpleDateFormat("yyyy");
		@Override String extract(Date date) {
			return formatter.format(date);
		}
	},
	MONTH {
		@Override String extract(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return String.valueOf(cal.get(Calendar.MONTH)+1);
		}
	},
	;
	
	abstract String extract(Date date);
}
