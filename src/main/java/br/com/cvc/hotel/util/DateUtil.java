package br.com.cvc.hotel.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public long daysBetweenDates(Date date1, Date date2) {
	    long diff = date2.getTime() - date1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
}
