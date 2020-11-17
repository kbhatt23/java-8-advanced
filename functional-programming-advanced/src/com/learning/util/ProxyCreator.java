package com.learning.util;

import java.lang.reflect.Proxy;

public class ProxyCreator {

	public static <T> T createProxy(Class<T> clazz) throws Exception{
		T newInstance = clazz.newInstance();
		Object newProxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new TimeCalculatoingInvocator(newInstance));
		return (T)newProxyInstance;
	}
	
}
