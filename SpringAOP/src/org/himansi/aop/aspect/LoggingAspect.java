package org.himansi.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	/*
	 * public String org.himansi.aop.model.Circle.getName() --this method executes
	 * before when getName() of Circle needs to be called Use wildcard to avoid
	 * repetition of same advice for ex: public String getName() - * * get*() -
	 * method starts with get get*(*)-at least one argument , get*(..)-zero or more
	 * argument , get*()-only for zero argument "LoggingAdvice()" run before the
	 * execution of "public String getName()"
	 */
	@Before("execution(* get*())")
	public void LoggingAdvice() { // standard format to write an advice
		System.out.println("Advice run . Get method is called");
	}

	@Before("execution(* get*())")
	public void secondAdvice() {

		System.out.println("Second advice executed");
	}

//	ponintcut defines dummy method to hold an expression "execution(* get*())" so that we can replace it by "allGetters()" for ex -@Before("allGetters()")
	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	/*
	 * @Before("execution(public String getName())") // "LoggingAdvice()" run before
	 * the execution of "public String // getName()" public void LoggingAdvice() {
	 * // standard format to write an advice
	 * System.out.println("Advice run . Get method is called"); }
	 */
}
