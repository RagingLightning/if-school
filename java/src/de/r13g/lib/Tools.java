package de.r13g.lib;

public class Tools {

	/**
	 * Eine Funktion, um zu prüfen, ob eine Zahl eine Primzahl ist
	 * 
	 * @param  n  die zu prüfende Zahl
	 * @return    Wahrheitswert, true: Primzahl, false: keine Primzahl
	 */ 

	public static boolean isPrime(int n) {
		if (n<=1) { //0 und 1 sind keine Primzahlen, negative (aufgrund von Unsicherheit) vorerst auch 
			return false;
		}

		for (int i = 2; i < n; i++) { //Für alle Zahlen von 2 bis n-1
			if (n % i == 0) return false; //Wenn n durch i teilbar, ist n keine Primzahl
		} // end of for
		return true; // Andernfalls ist n eine Primzahl
	}

	/**
	 * Eine Funktion, die eine Zufällige Gannzahl zwischen zwei Werten zur�ckgibt
	 * 
	 * @param  lower  die untere Grenze des Zufallswertes (inklusive)
	 * @param  upper  die obere Grenze des Zufallwertes (inklusive)
	 * @return   int  die Zufällige Ganzzahl
	 */

	public static int randomInt(int lower, int upper) {
		return (int)(Math.random()*(upper-lower)+lower); //Verallgemeinert aus Zufall.java
	}
	
  /**
   * Eine Funktion, die eine Zufällige Gleitkommazahl zwischen zwei Werten zur�ckgibt
   * 
   * @param  lower  die untere Grenze des Zufallswertes (inklusive)
   * @param  upper  die obere Grenze des Zufallwertes (inklusive)
   * @return double die Zufällige Ganzzahl
   */

  public static double randomDouble(double lower, double upper) {
    return Math.random()*(upper-lower)+lower; //Verallgemeinert aus Zufall.java
  }


	/**
	 * eine Matrizenmultiplikation [a]*[b]
	 * 
	 * 
	 * @param a  Erster Operand
	 * @param b  Zweiter Operand
	 * @return   Ergebnismatrix
	 */
	public static double[][] matrixMultiply(double[][] a, double[][] b) {
		double[][] c = new double[a.length][b[0].length];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				double sum = 0;
				for (int k = 0; k < a[i].length; k++) { //Zeile mal Spalte
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			} 
		}
		return c;
	}

	/**
	 *
	 */
	public static String runLengthEncoding(String string, int preset) {
		AdvancedString s = AdvancedString.fromString(string);
		StringBuilder coded = new StringBuilder();
		int i = 0;
		while (i < string.length()) {
			int d = s.longestRun(i);
			if(preset==0){coded.append(s.toString().charAt(i)).append(d);}
			if(preset==1){coded.append(s.toString().charAt(i)).append('[').append(d).append(']');}
			i += d;
		}
		return coded.toString();
	}

}

