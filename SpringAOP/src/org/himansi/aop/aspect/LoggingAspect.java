package org.himansi.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	public void CircleArgumentMethod() {
		System.out.println("A method that takes circle parameter has been called ");
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
		System.out.println(joinpoint.getTarget());// gives the object whose method was called and the method triggered
													// this//here it gives circle obj
	}

	/*
	 * can get the value of passed parameter of method that actually triggered apply
	 * some preprocessing before actual method runs
	 */
	@Before("args(name)")
	public void StringArgumentMethod(String name) {
		System.out.println("A method that takes string parameter has been called is " + name);
	}

	/*
	 * @After - It executes after calling method executed no matter method has
	 * successfully executed or not
	 * 
	 * @AfterReturning - it works to run only when method completes successfully
	 * without throwing any exception
	 */
	@After("args(name)")
	public void StringArgumentMethodAfter(String name) {
		System.out.println("A method that takes string parameter has been called is " + name);
	}

	/*
	 * @AfterReturning - it works to run only when method completes successfully
	 * without throwing any exception and returns here method get both method
	 * passing parameter and return value
	 */
	@AfterReturning(pointcut = "within(org.himansi.aop.model.Circle)", returning = "returnValue")
	public void StringArgumentMethodAfterReturning(int returnValue) {
		System.out.println("can't change returning value (there is no point to change returnig value here )");
		System.out.println("A method that takes string parameter has been called  return value is : " + returnValue);

	}

//	@AfterReturning(pointcut="org.himansi.aop.model.Circle.cetReturn() && args()" , returning = "abc")
//	public void StringArgumentMethodAfterReturning(int a,int abc) {
////		System.out.println("A method that takes string parameter has been called is : " + name + " and return value is : "+abc);
//	}	

	/*
	 * @AfterReturning - it works to run only when method throwing any exception and
	 * its type is RuntimeException only
	 */
	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("An exception has been thrown" + ex);
	}

	/*
	 * Here If target method is returning something then we have to write that
	 * return type for around advice and we can change that return value as well. we
	 * can have method variable that are shared with before and after code . so,
	 * local member variable can be shared by both the codes .most important point
	 * here is
	 * "It's not possible to do that in thread safe manner if we have two different method one for before and one for after "
	 */
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

		Object returnValue = null;

		try {
			System.out.println(
					"Before advice (can write some code here that needs to be executed before target method runs)");
			proceedingJoinPoint.proceed();
			System.out.println(
					"After advice (can write some code here that needs to be executed after target method runs)");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After throwing an exception !..");
		}
		System.out.println("After Finally !..");
		return returnValue;
	}

	/*
	 * Custom annotation - it is very helpful in case of this advice applies to many
	 * methods(easy to add unpredictable method later).It's more readable way to do
	 * that.
	 */
	@Around("@annotation(org.himansi.aop.aspect.Loggable)")
	public Object customAnnotationAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

		Object returnValue = null;

		try {
			System.out.println(
					"loggable : Before advice (can write some code here that needs to be executed before target method runs)");
			proceedingJoinPoint.proceed();
			System.out.println(
					"loggable : After advice (can write some code here that needs to be executed after target method runs)");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("loggable : After throwing an exception !..");
		}
		System.out.println("loggable : After Finally !..");
		return returnValue;
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
