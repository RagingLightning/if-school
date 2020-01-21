package code.jg11.einstieg;

import java.util.HashMap;

import de.r13g.lib.Tools;
import de.r13g.lib.console.ArrayConsole;
import de.r13g.lib.console.ConsoleExt;

@SuppressWarnings("unused")
public class Kap7 {

	public static void main(String[] args) {
		(new Kap7()).aufgabe4();
	}

	private void aufgabe1() {
		// Arrays definieren
		int[] x = {12,11,-1};
		float[] y = {1.3f,1.4f,-12.3f,2.23f};
		char[] z = {'a','#'};
		String[] v = {"Ar","ra","y"};

		//Ausgabe
		System.out.println("x[0]: " + x[0]);
		System.out.println("y[3]: " + y[3]);
		System.out.println("z[1]: " + z[1]);
		System.out.println("v[0]: " + v[0]);
	}

	private void aufgabe2() {
		//Zuf�llige Arrays defineren
		int[] x = {1,2,4,5,3,645,-2,-123,-32,34,343253,-234};
		float[] y = {0.34f,324.4f,3.4f,-4.0f};

		//x ausgeben
		ArrayConsole.printIntArray("x", x);

		System.out.println();
		//y ausgeben
		ArrayConsole.printFloatArray("y", y);
	}

	private void aufgabe3() {
		//Array initialiseren...
		int[] x = new int[100];
		for (int i = 0; i < 100; i++) {
			//...und f�llen...
			x[i] = i+1;
		}
		//...sowie ausgeben
		ArrayConsole.printIntArray("x",x);
	}

	private void aufgabe4() { //Mit Erwiterung durch Extraaufgabe
		int[][] array = null;
		while (true) {
			System.out.println("1: Noten eingeben");
			System.out.println("2: Noten ausgeben");
			System.out.println("3: Durchschnitt berechnen");
			System.out.println("4: Ende"); 
			int mode = ConsoleExt.getInputInt("Modus w�hlen");

			if (mode==4) return; //4: Ende
			switch (String.valueOf(mode)) {
			case "1": //Eigabe Noten
				int l = ConsoleExt.getInputInt("Klassengr��e");
				int n = ConsoleExt.getInputInt("Anzahl Klausuren");
				array = new int[n][l]; //Gr��e des Arrays nach Eingabe setzen
				for (int[] a:array) { //F�r jede Klausur...
					System.out.println("** Klausurbeginn **");
					for (int i = 0; i < l; i++) {//..und f�r jeden Sch�ler
						a[i] = ConsoleExt.getInputInt("Sch�ler Nr. " + (i+1) + " Note");//...die Note eigeben
					}
				}
				break;
			case "2":
				String str = ConsoleExt.getInputString("Nummer des Ziels (f�r Sch�ler s000)");
				if(!str.startsWith("s") && !str.startsWith("S")) { //Klausur
					try {
						n = Integer.parseInt(str); //String -> int
						if (array != null && array.length > 0 && array[n] != null) {//ist Klausur eingegeben?
							ArrayConsole.printIntArray("Note", array[n]); //Noten der Klausur ausgeben
						}
						else { //nicht eingegeben
							System.err.println("Table not defined");
							System.out.println("Erst Schritt 1 ausf�hren");
						}
					} catch (Exception e) {}
				} else { // s000 -> Sch�ler
					try {
						n = Integer.parseInt(str.substring(1)); //String -> int
						if (array != null && array.length > 0) {
							int[] prt = new int[array.length];
							for (int c = 0; c < array.length; c++ ) { //aus jeder Klausur...
								prt[c] = array[c][n];//...hole die Note des Sch�lers
							}
							ArrayConsole.printIntArray("Note", prt); //Ausgabe
						}
						else {
							System.err.println("Table not defined");
							System.out.println("Erst Schritt 1 ausf�hren");
						}
					} catch (Exception e) {}
				}
				break;
			case "3":
				String target = ConsoleExt.getInputString("Welchen Durchschnitt (f�r Sch�ler s000)");
				if (target.startsWith("s") || target.startsWith("S")) { //Sch�ler
					try {
						int s = Integer.parseInt(target.substring(1));
						int d = 0;
						for (int[] a : array) { //f�r jede Klausur...
							if (a != null && a.length > 0) d += a[s]; // addiere zu Summe
						}
						d /= array.length*1.0; //...und teile schlussendlich durch die Zahl der Arbeiten
						System.out.println("Durchschnitt: " + d);
					} catch (Exception e) {}
				} else { //Klausur
					try {
						int k = Integer.parseInt(target);
						if (array != null && array.length > 0) {
							int d = 0;
							for(int i:array[k]) {
								d += i;//bilde die Summe
							}
							d /= array[k].length*1.0; //und teile durch die Anzahl 
							System.out.println("Durchschnitt: " + d);
						} else {
							System.err.println("Table not defined");
							System.out.println("Erst Schtitt 1 ausf�hren");
						}
					} catch (Exception e) {}
				}
				break;
			default:
				System.err.println("Command not found");
				break;    
			}
		}
	}

	/*
      Aufgabe 5: 
      - int     0
      - double  0.0
      - char    ''
      - String  ""
	 */

	private void aufgabe6() {
		HashMap<Integer, String> map = new HashMap<>(); //Eingaben Validieren: Existiert das Fach?
		map.put(0,"Fs");
		map.put(1,"Ma");
		map.put(2,"En");
		map.put(3,"Ph");
		map.put(4,"If");
		map.put(5,"Sp");
		map.put(6,"De");
		map.put(7,"Fr");
		map.put(8,"Mu");
		map.put(9,"Po");
		map.put(10,"Ch");
		map.put(11,"Ge");
		map.put(12,"Re");
		map.put(13,"RC");

		int[][] plan = {{0,1,6,7,9,9,5,5}, //Standard Stundenplan festlegen
				{8,8,2,2,4,4,0,0},
				{0,0,10,10,6,6,13,13},
				{1,1,12,12,2,9,0,0},
				{11,11,3,3,7,7,0,0}};
		while (true) { 
			System.out.println("1: Stundenplan anzeigen");
			System.out.println("2: Stundenplan bearbeiten");
			System.out.println("3: Programm beenden");
			int op = ConsoleExt.getInputInt("Modus w�hlen");
			if (op==3) return;//3: Ende
			operate:
				switch(String.valueOf(op)) {
				case "1"://Stundenplan ausgeben
					System.out.println("** Stundenplan **");
					System.out.println("Mo\tDi\tMi\tDo\tFr\t");
					System.out.println("------------------------------------");
					for (int i = 0; i < plan[0].length; i++) {//F�r jede Stunde...
						for (int[] j:plan) {//...an jedem Tag...
							System.out.print(map.get(j[i]) + "\t");//...das Fach ausgeben...
						}
						System.out.println();//...und am Freitag in die n�chste Zeile rutschen
					}
					break;
				case "2"://Stundenplan �ndern
					System.out.println("** Stundenplan �ndern**");
					int i = ConsoleExt.getInputInt("Tag (0-4)");
					int j = ConsoleExt.getInputInt("Stunde (0-7)");
					System.out.println("Aktuell: " + map.get(plan[i][j])); //Information: Die aktuelle Belegung
					String change = ConsoleExt.getInputString("Neu"); //Nutzereingabe: Fachbezeichnung oder code
					try {
						int code = Integer.parseInt(change); //Wurde der Code eingegeben?
						for (int k : map.keySet()) {
							if (k==code) {//Ist dem code ein Fach zugeordnet?
								plan[i][j] = code;
								System.out.println("Unterricht ge�ndert zu " + map.get(plan[i][j]));
								break operate; //beende die Ausf�hrung (ohne "operate" nur for-schleife) 
							}
						}
						System.out.println("Der eingegebene Code existiert nicht.");
					} catch(Exception e) {
						for (int s: map.keySet()) {
							if (map.get(s).equalsIgnoreCase(change)) { //Existiert das eingegebene Fach?
								plan[i][j] = s;
								System.out.println("Unterricht ge�ndert zu " + map.get(plan[i][j]));
								break operate; //beende die Ausf�hrung (ohne "operate" nur for-schleife)
							} 
						}
						System.out.println("Unterrichtsfach nicht existent");
					}
					break;
				}
		}
	}

	private void aufgabeMatrix() {
		double[][] a = {{3,2,1},{1,0,2}}; //Beispiel Wikipedia
		double[][] b = {{1,2},{0,1},{4,0}};

		double[][] c = Tools.matrixMultiply(a, b); //Ausgelagert in Library

		for (double[] j:c) { //Zum �berpr�fen einmal ausgeben
			for (double i:j) {
				System.out.print(" " + i + " ");
			}
			System.out.println();
		}
	}
}
