package logTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class timeReturn {
	
	public static String getTime() {
		LocalDateTime tm = LocalDateTime.now();
		String tm2 = tm.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return tm2;
	}
}
