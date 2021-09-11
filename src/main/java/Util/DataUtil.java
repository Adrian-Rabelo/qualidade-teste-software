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
	
	public Date obterData(int dia, int mes, int ano) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.MONTH, mes - 1);
		calendar.set(Calendar.YEAR, ano);
		
		return calendar.getTime();
	}
	
}
