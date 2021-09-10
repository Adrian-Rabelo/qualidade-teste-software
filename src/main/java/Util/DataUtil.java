package Util;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {
	
	public Date addDias(Date date, int dias) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		
		return calendar.getTime();
		
	}
	
}
