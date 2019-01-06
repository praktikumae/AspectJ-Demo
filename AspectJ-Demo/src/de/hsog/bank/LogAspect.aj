package de.hsog.bank;

public aspect LogAspect {

	pointcut callPublicMethods() :
			 call (public * de.hsog.bank.Konto.*(..) );

	before(): callPublicMethods() {
		System.out.println("Start von " + thisJoinPoint);
	}

	after(): callPublicMethods () {
		System.out.println("Ende von " + thisJoinPoint);
	}
}
