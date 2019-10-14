package com.laurel.time;

import javax.swing.JOptionPane;

public class CurrentTime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Obtain current time
		long currentTime = System.currentTimeMillis();
		
//		Calculate the total numbers
		long totalSeconds = currentTime / 1000;
		long totalMinutes = currentTime / 60000;
		long totalHours = currentTime /3600000;
		
//		Calculate the current time
//		long currentYears = 1970+ totalHours/ 8760;
		long currentHours = totalHours % 24 + 8;
		long currentMinutes = totalMinutes % 60;
		long currentSeconds = totalSeconds % 60;
	
//		Display results
		/*String currentTimestring = 
				"\nThe total number of seconds is " + totalSeconds +
				"\nThe total number of minutes is " + totalMinutes +
				"\nThe total number of hours is " + totalHours +
//				"\nThe current year is " + currentYears +
				"\nThe current hour is " + currentHours +
				"\nThe current minute is " + currentMinutes +
				"\nThe current second is " + currentSeconds;*/
		
		String currentTimestring = "The current time is " +
		currentHours + ":" + currentMinutes + ":" + currentSeconds;
		
		JOptionPane.showMessageDialog(null,currentTimestring);
	}
}
