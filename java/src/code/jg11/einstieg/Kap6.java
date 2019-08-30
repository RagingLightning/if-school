/**
 * 
 */
 
/*
Aufgabe 1: Am Anfang wird die Variable i mit 0 initialisiert
- Der Code im Block wird ausgeführt
- der zähler wird um 1 erhöht
- wenn i kleiner als 10 ist, wird der schleifenrumpf erneut ausgeführt

Aufgabe 4: Vor der Schleife werden die Variablen initialisiert
- wenn x kleiner als 10 ist wird der Schleifenrumpf ausgeführt
 - Es wird der Wert der Variable ausgegeben und anschließend um 3 verringert
 - die bedingung wird erneut überprüft 
- andernfalls wird die schelife beendet
*/

package code.jg11.einstieg;

import de.r13g.lib.Tools;
import de.r13g.lib.console.ConsoleExt;

@SuppressWarnings("unused")
public class Kap6{
  
  public static void main(String[] args) {
    (new Kap6()).aufgabe6(); //Aufgabe ausf�hren
  }
  
  private void aufgabe2() {
    int sum = 0; //Initialisiere Summe mit 0
    for (int i=1; i<=100; i++) { //z�hle 1 bis 100
      sum += i; //addiere zu Summe
      System.out.println(sum); //Ausgabe Summe
    }
  }
  
  private void aufgabe3() {
    System.out.println("**Primzahl**");
    for (int i = 0; i<=100; i++) {
      System.out.print(Tools.isPrime(i)?i + " ":""); //Wenn Zahl Primzahl ist, Zahl und Leerzeichen ausgeben, sonst nichts
    } // end of for
    System.out.println();
    System.out.println("**Durch 3 teilbar**");
    for (int i = 0; i<=100; i++) {
      System.out.print((i%3==0)?i + " ":""); //Wenn Zahl teilbar durch 3, Zahl und Leerzeichen ausgeben, sonst nichts
    } // end of for
    System.out.println();
    System.out.println("**Durch 5 und nicht durch 4**");
    for (int i = 0; i<=100; i++) {
      System.out.print(((i%5==0)&&(i%4!=0))?i + " ":""); //Wenn Bedingung erfüllt ist, Zahl und Leerzeichen ausgeben, sonst nichts
    } // end of for
  }
  
  private void aufgabe5_2() { // F�r Ablauflogik s. aufgabe2()
    int sum = 0;
    int i=1; //for-Schleife Teil 1
    while( i<=100 ) { //for-Schleife Teil 2
      sum += i;
      System.out.println(sum);
      i++; //for-Schelife Teil 3
    }
  }
  
  private void aufgabe5_3() { // f�r Ablauflogik s. aufgabe3()
    System.out.println("**Primzahl**");
    int i = 0; //for-Schleife 1 Teil 1 
    while (i<=100) { //for-Schleife 1 Teil 2
      System.out.print(Tools.isPrime(i)?i + " ":""); //Wenn Zahl Primzahl ist, Zahl und Leerzeichen ausgeben, sonst nichts
      i++; //for-Schleife 1 Teil 3
    }
    System.out.println();
    System.out.println("**Durch 3 teilbar**");
    i = 0; //for-Schleife 2 Teil 1
    while (i<=100) { //for-Schleife 2 Teil 2
      System.out.print((i%3==0)?i + " ":""); //Wenn Zahl teilbar durch 3, Zahl und Leerzeichen ausgeben, sonst nichts
      i++; //for-Schleife 2 Teil 3
    }
    System.out.println();
    System.out.println("**Durch 5 und nicht durch 4**");
    i = 0; //for-Schleife 3 Teil 1
    while (i<=100) { //for-Schleife 3 Teil 2
      System.out.print(((i%5==0)&&(i%4!=0))?i + " ":""); //Wenn Bedingung erfüllt ist, Zahl und Leerzeichen ausgeben, sonst nichts
      i++; //for-Schleife 3 Teil 3
    } 
  }
  
  private void aufgabe6() {
    char mode = ConsoleExt.getInputChar("Rechenoperator"); //Eingabe operator (+,-,*,/,%)
    int count = 0; //Initialisiere Anzahl mit 0
    while (true) { 
      int z1 = Tools.randomInt(-99,99);
      int z2 = Tools.randomInt(-99,99); //Zuf�llige Zahlen von -99 bis 99 für Aufgaben
      int result = 0;
      switch (mode) { //Berechnung Ergebnis 
        case '+':
          result = z1 + z2;
          break;
        case '-':
          result = z1 - z2;
          break;
        case '*':
          result = z1 * z2;
          break;
        case '/':
          while (z2==0){z2=Tools.randomInt(-99,99);} //solange z2=0 neue Zahl, um Division durch null zu verhindern
          result = z1 / z2; //Ganzzahldivision, um Eingabe zu vereinfachen
          break;
        case '%':
          while (z2==0){z2=Tools.randomInt(-99,99);} //solange z2=0 neue Zahl, um Division durch null zu verhindern
          result = z1 % z2;
          break;
        default:
          System.out.println("Unbekannter Operator, bitte neustarten");
          break;
      }
      
      if (ConsoleExt.getInputInt("(" + z1 + ")" + mode + "(" +  z2 + ")=", false)!=result) { //Falsche Antwort -> Beenden
        System.out.println("Leider Falsch");
        System.out.println("Ergebnis: " + result);
        System.out.println("Richtige Ergebnisse: " + count);
        System.out.println("Hier ist Ende!");
        break;
      }
      count++; //Anzahl beantworteter Aufgaben um 1 erh�hen;
    }
  }
}

