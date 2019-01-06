package de.hsog.bank;

import de.hsog.bank.Konto;

public aspect ErrorHandlingAspect {

	pointcut kontobewegung(double betrag):
		 (call(public void de.hsog.bank.Konto.einzahlen(double))
		 || call (public void de.hsog.bank.Konto.abheben(double)))
		 && args(betrag);

	before(double betrag): kontobewegung(betrag) {
		if (betrag < 0) {
			throw new IllegalArgumentException("negativer Betrag");
		}
	}

	before(double betrag, Konto konto):
	 execution (public void Konto.abheben(double))
	 && args(betrag)
	 && this(konto) {
		if (betrag > konto.kontostand) {
			throw new RuntimeException("keine Deckung");
		}
	}

	pointcut kontoMethods():
		 call (public * bank.Konto.*(..) );

	after(): kontoMethods() {
		if (((Konto) thisJoinPoint.getTarget()).kontostand < 0) {
			throw new RuntimeException("Konto ueberzogen");
		}
	}
}
