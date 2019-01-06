package de.hsog.bank;

public class TestKonto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Konto konto = new Konto();
		konto.einzahlen(100.0);
		konto.abheben(50.0);

		//Fehler keine Deckung
		konto.abheben(200.0);
	}

}
