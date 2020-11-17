package com.learning.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeCalculatoingInvocator implements InvocationHandler{

	private Object realInstance;
	
	public TimeCalculatoingInvocator(Object realInstance) {
		this.realInstance=realInstance;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.nanoTime();
		Object result = method.invoke(realInstance, args);
		long endTime = System.nanoTime();
		
		System.out.println(String.format("total time take to execute method %s is %d", method.getName(),(endTime-startTime)));
		return result;
	}

}
