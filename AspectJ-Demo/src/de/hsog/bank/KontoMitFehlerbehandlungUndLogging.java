package de.hsog.bank;

public class KontoMitFehlerbehandlungUndLogging {

	private double kontostand = 0.0;

	public double getKontostand() {
		System.out.println("Get Kontostand aufgerufen.");
		return kontostand;
	}

	public void einzahlen(double betrag) {
		System.out.println("Start Methode einzahlen.");
		if (betrag < 0) {
			System.out.println("IllegalArgumentException bei einzahlen. Betrag negativ");
			throw new IllegalArgumentException("Betrag negativ.");
		}
		kontostand = kontostand + betrag;
		System.out.println("Ende Methode einzahlen.");
	}

	public void abheben(double betrag) {
		System.out.println("Start Methode abheben.");
		if (betrag < 0) {
			System.out.println("IllegalArgumentException bei abheben. Betrag negativ");
			throw new IllegalArgumentException("Betrag negativ.");
		}
		if (kontostand < betrag) {
			System.out
					.println("RuntimeException bei abheben. Keine Kontodeckung.");
			throw new RuntimeException("Keine Kontodeckung.");
		}
		kontostand = kontostand - betrag;
		System.out.println("Ende Methode abheben.");
	}

	public void ueberweise(double betrag,
			KontoMitFehlerbehandlungUndLogging anderesKonto) {
		abheben(betrag);
		anderesKonto.einzahlen(betrag);
	}
}
