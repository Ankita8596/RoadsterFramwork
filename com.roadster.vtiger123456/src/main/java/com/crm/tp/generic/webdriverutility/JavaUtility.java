package com.crm.tp.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * generate the random number
	 * @param num
	 * @return ramNum
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int ramNum = random.nextInt(5000);
		return ramNum;
	}
	/**
	 * capture the system date 
	 * @return date
	 */
	public String getSystemDate() {
		Date dobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dobj);
		return date;
		
	}
	/**
	 * capture the required system date from the calendar
	 * @param days
	 */
	public String getRequiredSystemDateyyyyMMdd(int days) {
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;
	}

}

