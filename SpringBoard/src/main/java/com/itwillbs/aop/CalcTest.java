package com.itwillbs.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * AOP(Aspect-oOriented Programming):관점지향 프로그래밍
 * => 메서드 안에서 주기능/보조기능(로깅, 트렌젝션, 보안, 예외)을 분리해서 선택적으로 사용 
 *    (개발자는 주기능만 구현)
 *    
 * AOP 용어
 * aspect : 구현하고자 하는 보조기능   
 * advice : aspect의 실제 구현체(클래스)   
 * joinpoint : advice를 적용하는 지점(스프링 - method결합점)
 * pointcut : advice가 적용되는 대상을 지정
 * target : advice가 적용되는 클래스(주기능을 수행)
 * weaving : advice를 주기능에 적용하는 것
 */
public class CalcTest {

	public static void main(String[] args) {
		
		// 계산기 사용(일반)
		Calculator c = new Calculator();
		c.add(100, 200);
		
		// 계산기 사용(AOP 적용) 
		// src/main/java 경로에 설정된 xml 파일 불러오기
		ApplicationContext CTX = new ClassPathXmlApplicationContext("aop.xml");
		
		Calculator proxyCal = (Calculator)CTX.getBean("proxyCal");
		
		proxyCal.add(200, 300);
	}

}
