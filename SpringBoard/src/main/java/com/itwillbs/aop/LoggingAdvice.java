package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("메서드 실행전! 보조기능(로깅 실행)");
		
		// 주기능
		invocation.proceed();

		
		System.out.println("메서드 실행후! 보조기능(로깅 실행)");
		
		return null;
	}

	
}
