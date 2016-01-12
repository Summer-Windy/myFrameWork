package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * XML方式
 * @author Administrator
 *
 */
public class TestAspect {

	public void doAfter(JoinPoint jp) {
		System.out.println("-->aop log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		time = System.currentTimeMillis() - time;
		System.out.println("-->aop process time: " + time + " ms");
		return retVal;
	}

	public void doBefore(JoinPoint jp) {
		System.out.println("-->aop log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("-->aop method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}
}