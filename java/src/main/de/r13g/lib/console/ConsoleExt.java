package de.r13g.lib.console;

public class ConsoleExt extends Konsole {
  
  
  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als String zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   * @param  end  Ein Wahrheitswert, der angibt, ob am Ende ein Doppelpunkt angehängt wird
   *
   * @return      Die eingegebene Nachricht  
   */

  public static String getInputString(String msg, boolean end) {
    System.out.print(msg + (end?": ":""));
    return Konsole.getInputString();
  }

  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als String zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   *
   * @return      Die eingegebene Nachricht  
   */

  public static String getInputString(String msg) {
    return getInputString(msg,true);
  }

  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als int zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   * @param  end  Ein Wahrheitswert, der angibt, ob am Ende ein Doppelpunkt angehängt wird
   *
   * @return      Die eingegebene Nachricht (int)  
   */

  public static int getInputInt(String msg, boolean end) {
    System.out.print(msg + (end?": ":""));
    return Konsole.getInputInt();
  }

  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als int zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   * 
   * @return      Die eingegebene Nachricht (int)  
   */

  public static int getInputInt(String msg) {
    return getInputInt(msg,true);
  }
  
  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als double zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   * @param  end  Ein Wahrheitswert, der angibt, ob am Ende ein Doppelpunkt angehängt wird
   *
   * @return      Die eingegebene Nachricht (double)
   */

  public static double getInputDouble(String msg, boolean end) {
    System.out.print(msg + (end?": ":""));
    return Konsole.getInputDouble();
  }

  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als double zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   *
   * @return      Die eingegebene Nachricht (double)
   */

  public static double getInputDouble(String msg) {
    return getInputDouble(msg,true);
  }
  
  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als char zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   * @param  end  Ein Wahrheitswert, der angibt, ob am Ende ein Doppelpunkt angehängt wird
   *
   * @return      Die eingegebene Nachricht (char)
   */

  public static char getInputChar(String msg, boolean end) {
    System.out.print(msg + (end?": ":""));
    return Konsole.getInputChar();
  }
  
  /**
   * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   * diese als char zurück.
   *
   * @param  msg  Eine Nachricht, die vor der Eingabe aussgegeben wird
   *
   * @return      Die eingegebene Nachricht (char)
   */

  public static char getInputChar(String msg) {
    return getInputChar(msg, true);
  }

  
}

