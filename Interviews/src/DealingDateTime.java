import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DealingDateTime {

	static final String valid = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
	    for( int i = 0; i < length; i++ ) 
	    	sb.append( valid.charAt((int)(Math.random()*valid.length())));
	    return sb.toString();
	} // randomString (length); 
	
	public static int randomNumber(int start, int end) {
		if (start < end) {
			return ((int)(Math.random() * (end - start + 1) + start));
		} else {
			return ((int)(Math.random() * (start - end + 1) + end));
		}
	} // randomNumber (start, end)

	
	
	// A good start - http://www.tutorialspoint.com/java/java_date_time.htm
	
	public static Date randomDate() {
		Date date = new Date(randomNumber(0,200), randomNumber(1,12), randomNumber(1,31), randomNumber(1,12), randomNumber(0,59), randomNumber(0,59));
		return date; // return a valid random date
	} // randomNumber (start, end)
	
	public static Date randomDate(Date start, Date end) {
		if(end.before(start)) {
			Date temp = end;
			end = start;
			start = temp;
		}
		Date date = randomDate();
		while(date.before(start) || date.after(end)) {
			date = randomDate();
		}
		return date; // return a valid random date
	} 
	
	public static Date randomFutureDate() {
		Date now = new Date();
		Date date = randomDate();
		while(date.before(now)) {
			date = randomDate();
		}
		return date; // return a valid random date
	} 
	
	public static Date randomFutureDate(int range) {
		
		return null; // return a valid random date
	}
	
	public static Date difference(Date start, Date end) {
		
		return null; // return a valid random date
	}
	
	
	public static double angleClock(Date date) {
		int hour = date.getHours();
		int minute = date.getMinutes();		
		double hourDegree = (hour * 30.0) + (minute / 2.0);
		double minuteDegree = minute * 6.0;
		if(hourDegree == 360 && minuteDegree == 0) {
			return 0;
		} else if(hourDegree - minuteDegree > 180) {
			return Math.abs(180 - hourDegree - minuteDegree);
		}
		return Math.abs(hourDegree - minuteDegree);
	}
	
	public static Date randomPastDate() {
		Date now = new Date();
		Date date = randomDate();
		while(date.after(now)) {
			date = randomDate();
		}
		return date; // return a valid random date
	} 

	public static double difference (Date start, Date end, String s) {
//		Input string is in RFC1123 date time format abbreviation, i.e. dd/MMM/yyyy HH:mm:ss
//		Useful resources:
//		https://docs.oracle.com/javase/8/docs/api/java/time/Period.html
//		https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
		if(!start.before(end)) {
			Date temp = start;
			start = end;
			end = temp;
		}
		long diffInMilliseconds = end.getTime() - start.getTime();
		if(s.equals("ss")) {
			double seconds = diffInMilliseconds / 1000.0;
			return seconds;
		} else if(s.equals("mm")) {
			double minutes = diffInMilliseconds / 1000.0 / 60.0;
			return minutes;
		} else if(s.equals("HH")) {
			double hours = diffInMilliseconds / 1000.0 / 60.0 / 60.0;
			return hours;
		} else if(s.equals("dd")) {
			double days = diffInMilliseconds / 1000.0 / 86400.0;
			return days;
		} else if(s.equals("MM")) {
			double months = diffInMilliseconds / 1000.0 / 86400.0 / 30;
			return months;
		} else {
			double years = diffInMilliseconds / 1000.0 / 86400.0 / 365;
			return years;
		}
		// return a valid double
	} 
	
	//Date datetime, Path path, String executable
	public static int scheduler(Date datetime, Path path, String executable) throws InterruptedException {
		try
		{
			Date now = new Date();
			double difference = difference(now, datetime, "ss");
			Thread.sleep((long)difference*1000);
			Runtime.getRuntime().exec(path + executable, null, new File(path.toString()));
		}
		catch(IOException ex)
		{
		    System.out.println(ex.getMessage());
		}
//		Useful resource:
//		1. https://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html
//		2. https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html
//		3. find out the difference of wait() vs. sleep()
//		Use System.exit(status); The argument serves as a status code; by convention, a nonzero status code indicates abnormal termination.
//		The return code should follow System.exit (status) convention; The argument serves as a status code; by convention, 0 means successfully 
//		executed and exited;  a nonzero status code indicates abnormal termination.
		return 0; // returns 0 when successfully executed and "exited"
	}
	
	public static String addBinary(String binary1, String binary2) {
		boolean carryOver = false;
		int index = 7;
		StringBuilder sb = new StringBuilder(9);
		char[] charArray1 = binary1.toCharArray();
		char[] charArray2 = binary2.toCharArray();
		while(index >= 0) {
			if(carryOver) {
				if(charArray1[index] == '0' && charArray2[index] == '0') {
					sb.append("1");
					carryOver = false;
				} else if(charArray1[index] == '0' && charArray2[index] == '1')
					sb.append("0");
				else if(charArray1[index] == '1' && charArray2[index] == '0')
					sb.append("0");
				else if(charArray1[index] == '1' && charArray2[index] == '1') {
					sb.append("1");
				} else {
					return "Invalid String";
				}
			} else {
				if(charArray1[index] == '0' && charArray2[index] == '0')
					sb.append("0");
				else if(charArray1[index] == '0' && charArray2[index] == '1')
					sb.append("1");
				else if(charArray1[index] == '1' && charArray2[index] == '0')
					sb.append("1");
				else if(charArray1[index] == '1' && charArray2[index] == '1') {
					sb.append("0");
					carryOver = true;
				} else {
					return "Invalid String";
				}			
			}
			index--;
		}
		if(carryOver && index < 0)
			sb.append("1");
		char[] ans = sb.toString().toCharArray();
		StringBuilder reversed = new StringBuilder(9);
		for(int i = ans.length - 1; i >= 0; i--) {
			reversed.append(ans[i]);
		}
		return reversed.toString();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Random Date                   : " + randomDate());
		System.out.println("Random Future Date            : " + randomFutureDate());
		System.out.println("Random Future Date with Range : " + randomFutureDate());
		System.out.println("Random Past Date              : " + randomPastDate());
		System.out.println("Random Past Date with Range   : " + randomPastDate());
		Date date = randomDate();
		System.out.println("Angle on the Clock when it is " + date.getHours() + ":" + date.getMinutes() + " is " + angleClock(date));
		Date start = randomDate();
		Date end = randomDate();
		System.out.println("Difference between " + start.toString() + " and " + end.toString() + " is " + difference(start, end, "ss"));
		
		
		Date fiveSecondsFromNow = new Date();		
		Date now = new Date();
		fiveSecondsFromNow.setSeconds(now.getSeconds() + 5);
		System.out.println("Difference between " + now.toString() + " and " + fiveSecondsFromNow.toString() + " is " + difference(now, fiveSecondsFromNow, "ss"));
		String textPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application";
		String executable = "\\chrome.exe";
		Path path = Paths.get(textPath);
		//scheduler(fiveSecondsFromNow, path, executable);
		System.out.println("Binary: " + addBinary("11111111", "01010001"));
		
	}
}
