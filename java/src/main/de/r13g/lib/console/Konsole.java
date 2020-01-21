package de.r13g.lib.console;

import java.io.*;

public class Konsole {

  private static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als String zurueck.
   *
   *  @return Einen Wert vom Typ <tt>String</tt> der die Benutzereingabe enthaelt.
   */
  static String getInputString() {
    while (true) {
      try {
        return br.readLine();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Integer zurueck.
   *
   *  @return Einen Wert vom Typ <tt>int</tt> der die Benutzereingabe enthaelt.
   */
  static int getInputInt() {
    while (true) {
      try {
        return Integer.parseInt(br.readLine());
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Double zurueck.
   *
   *  @return Einen Wert vom Typ <tt>double</tt> der die Benutzereingabe enthaelt.
   */
  static double getInputDouble() {
    String x;
    while ( true ) {
      try {
        x = br.readLine();
        return Double.parseDouble(x);
      }
      catch (NumberFormatException nfe) {
        System.err.println();
        System.err.println("Fehler bei der Verarbeitung der Eingabe: "
                + nfe.getLocalizedMessage());
        System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
        System.err.println();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Char zurueck.
   *
   *  @return Einen Wert vom Typ <tt>char</tt> der die Benutzereingabe enthaelt.
   */
  static char getInputChar() {
    String buffer;
    while (true) {
      try {
        buffer = br.readLine();
        return buffer.charAt(0);
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

}
         
      
