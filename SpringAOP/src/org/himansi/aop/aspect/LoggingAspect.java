package org.himansi.aop.aspect;

import org.aspectj.lang.JoinPoint;
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
	@Before("methodsAcceptingEntities()")
	public void methodParaAdvise() {
		System.out.println("It executes when method with any parameter is circle ");
	}

	// this only applicable when this both pointcuts apply
	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice() { // standard format to write an advice
		System.out.println("Advice run . Get method is called");
	}

	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second advice executed");
	}

	/*
	 * Joinpoint - To get the info about what was the method that actually triggered
	 * the call
	 */
	@Before("allCircleMethods()")
	public void methodNameAdvice(JoinPoint joinpoint) {

		System.out.println(joinpoint.toString());
		System.out.println(joinpoint.getTarget());//gives the object whose method was called and the method triggered this//here itgives circle obj
	}

	/*
	 * ->can use one pointcut applies to different method ->ponintcut defines dummy
	 * method to hold an expression "execution(* get*())" so that we can replace it
	 * by "allGetters()" for ex -@Before("allGetters()")
	 */
	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	/*
	 * org.himansi.aop.model..* --> all the classes in the package( model ) and sub
	 * packages as well org.himansi.aop.model.Circle.*(..) or
	 * org.himansi.aop.model.Circle --> all the method of circle
	 * org.himansi.aop.model.* -->all the classes of model package
	 */
	@Pointcut("within(org.himansi.aop.model.Circle)")
	public void allCircleMethods() {
	}

	/*
	 * @args This PCD limits matching to join points where the runtime type of the
	 * actual arguments passed have annotations of the given type(s). Suppose that
	 * we want to trace all the methods accepting beans annotated with @Entity
	 * annotation:
	 */
	@Pointcut("args(org.himansi.aop.model.Circle)")
	public void methodsAcceptingEntities() {
	}

	/*
	 * @Before("execution(public String getName())") // "LoggingAdvice()" run before
	 * the execution of "public String // getName()" public void LoggingAdvice() {
	 * // standard format to write an advice
	 * System.out.println("Advice run . Get method is called"); }
	 */
}
