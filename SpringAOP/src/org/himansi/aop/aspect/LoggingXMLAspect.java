package org.himansi.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingXMLAspect {

	public Object annotationAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

		Object returnValue = null;

		try {
			System.out.println(
					"xml : Before advice (can write some code here that needs to be executed before target method runs)");
			proceedingJoinPoint.proceed();
			System.out.println(
					"xml : After advice (can write some code here that needs to be executed after target method runs)");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("xml : After throwing an exception !..");
		}
		System.out.println("xml : After Finally !..");
		return returnValue;
	}

	public void onLoggable() {
		System.out.println("on attempt of loggable");
	}

//	@Pointcut("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
//	private void accountDataAccessOperation(Account account) {}
//
//	@Before("accountDataAccessOperation(account)")
//	public void validateAccount(Account account) {
//	    // ...
//	}

//	Proceeding with arguments
//	We remarked earlier that we would describe how to write a proceed call with arguments that works consistently across Spring AOP and AspectJ. The solution is simply to ensure that the advice signature binds each of the method parameters in order. For example:
//
//	@Around("execution(List<Account> find*(..)) && " +
//	        "com.xyz.myapp.SystemArchitecture.inDataAccessLayer() && " +
//	        "args(accountHolderNamePattern)")
//	public Object preProcessQueryPattern(ProceedingJoinPoint pjp,
//	        String accountHolderNamePattern) throws Throwable {
//	    String newPattern = preProcess(accountHolderNamePattern);
//	    return pjp.proceed(new Object[] {newPattern});
//	}

}
