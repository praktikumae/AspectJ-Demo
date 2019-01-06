package de.hsog.bank;

public class Konto {

	public double kontostand = 0.0;

	public double getKontostand() {
		return kontostand;
	}

	public void einzahlen(double betrag) {
		kontostand = kontostand + betrag;
	}

	public void abheben(double betrag) {
		kontostand = kontostand - betrag;
	}

	public void ueberweise(double betrag, Konto anderesKonto) {
		abheben(betrag);
		anderesKonto.einzahlen(betrag);
	}
}
