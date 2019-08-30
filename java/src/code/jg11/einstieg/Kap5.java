package code.jg11.einstieg;

import de.r13g.lib.console.Konsole;

/*
  * Aufgabe 1: Im Schleifenkopf wird überprüft, ob der in der Variable "zahl" gespeicherte Wert kleiner als null ist
  * - wenn die Bedingung wahr ist, wird die Anweisung im ersten Code-Block ausgeführt, die den Text "Zahl ist negativ" ausgibt.
  * - andernfalls wird die Anweisung im Code-Block nach else ausgeführt, die den Text "Zahl ist positiv" ausgibt.
*/
public class Kap5 {
  // start attributes
  // end attributes
  
  // start methods
  public static void main(String[] args) {
    (new Kap5()).Aufgabe4();
  }

  
  public void Aufgabe1u3() {
    System.out.print("Bitte gib eine Zahl ein: ");
    double z = Konsole.getInputDouble();
    if (z<0) {
      System.out.println("Die eingegebene Zahl ist kleiner als null");
    } else if(z==0) {
      System.out.println("Die eingegebene Zahl ist null");
    } else {
      System.out.println("Die eingegebene Zahl ist größer als null");
    } // end of if-else
    
  }
  
  public void Aufgabe2() {
    int k = 13634; //int in ct, um rundungsfehler zu vermeiden
    System.out.println("Ihr Guthaben beträgt " + k/100.0 + " €");
    System.out.print("Abzuhebender Betrag: ");
    int c = (int)Math.floor(Konsole.getInputDouble()*100);
    if (c<=k) {
      k -= c;
      System.out.println("Es wurden " + c/100.0 + " € abgehoben.");
    } else {
      System.out.println("Du hast keine " + c/100.0 + " € auf dem Konto, der Vorgang wurde abgebrochen.");
    } // end of if-else
    System.out.println("Du hast noch " + k/100.0 + " € auf dem Konto.");
  }
  
  public void Aufgabe4() {
    System.out.println("**Eingabe Datum**");
    System.out.print("Tag: ");
    int d = Konsole.getInputInt();
    System.out.print("Monat: ");
    int m = Konsole.getInputInt();
    System.out.print("Jahr: ");
    int y = Konsole.getInputInt();
    System.out.println("**Eingabe Geburtsdatum**");
    System.out.print("Tag: ");
    int bd = Konsole.getInputInt();
    System.out.print("Monat: ");
    int bm = Konsole.getInputInt();
    System.out.print("Jahr: ");
    int by = Konsole.getInputInt();
    System.out.println(y-by - ((bm > m || bd > d)?1:0));
    
  }
  
  public void Aufgabe5(){
    System.out.println("**Rechner**");
    System.out.print("Erste Zahl: ");
    double z1 = Konsole.getInputDouble();
    System.out.print("Operator: ");
    char o = Konsole.getInputChar();
    System.out.print("Zweite Zahl: ");
    double z2 = Konsole.getInputDouble();
    switch (o) {
      case '+': 
        System.out.println(z1+z2);
        break;
      case '-': 
        System.out.println(z1-z2);
        break;
      case '*':
        System.out.println(z1*z2);
        break;
      case '/':
        System.out.println(z1/z2);
        break;
    } // end of switch
  }
  
  public double AufgabeE(double x){
    if (x < -1) {
      System.out.println(1-x/2);
      return 1-x/2;
    } else if (x > 1) {
      System.out.println(1+x/2);
      return 1+x/2;
    } else {
      System.out.println(1);
      return 1;
    } // end of if-else
  }
  // end methods






  
}

