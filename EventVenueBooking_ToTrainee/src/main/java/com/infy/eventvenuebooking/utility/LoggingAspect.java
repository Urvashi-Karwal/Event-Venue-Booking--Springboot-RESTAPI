package com.infy.eventvenuebooking.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.infy.eventvenuebooking.exception.EventVenueBookingException;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT 
	
	@AfterThrowing(pointcut = "execution(* com.infy.eventvenuebooking.service.EventServiceImpl.*(..))",
			throwing = "exception")
	public void logServiceException(EventVenueBookingException exception) {
		//your code goes here
		LOGGER.error(exception);
	}

}
