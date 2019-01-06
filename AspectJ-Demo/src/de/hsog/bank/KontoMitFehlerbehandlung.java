package de.hsog.bank;

public class KontoMitFehlerbehandlung {

	private double kontostand = 0.0;

	public double getKontostand() {
		return kontostand;
	}

	public void einzahlen(double betrag) {
		if (betrag < 0) {
			throw new IllegalArgumentException("Betrag negativ.");
		}
		kontostand = kontostand + betrag;
	}

	public void abheben(double betrag) {
		if (betrag <0 ){
			throw new IllegalArgumentException("Betrag negativ.");
		}
		if (kontostand < betrag ){
			throw new RuntimeException("Keine Kontodeckung.");
		}
		kontostand = kontostand - betrag;

	}

	public void ueberweise(double betrag, KontoMitFehlerbehandlung anderesKonto) {
		abheben(betrag);
		anderesKonto.einzahlen(betrag);
	}
}
