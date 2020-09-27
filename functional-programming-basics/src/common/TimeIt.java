package common;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeIt {
	//we na add methods for other scenarios also like functin, bifubction, suplier based on need
	public  static  void code(Runnable funProvider) {
		LocalDateTime start  =LocalDateTime.now();
		funProvider.run();
		
		LocalDateTime end  =LocalDateTime.now();
		System.out.println("total time taken: "+Duration.between(start, end).getNano());
	}
}
