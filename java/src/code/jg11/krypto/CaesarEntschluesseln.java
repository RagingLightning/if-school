package code.jg11.krypto;

import java.util.HashMap;

public class CaesarEntschluesseln {

  static HashMap<Character, Integer> map = new HashMap<>();

  private static void initMap() {
    for (int i = 65; i <= 90; i++) {
      map.put((char) i, 0);
    }
  }

  public static void main(String[] args) {
    initMap();
    String text = "xdy ikjkahmcalyqdpecy syopechryppyhrjb dpq di wydqahqyo xyp ekimrqyop jdecq iyco agqryhh.";
    for(char c : text.toUpperCase().toCharArray()) {
      if (map.containsKey(c)) map.put(c, map.get(c)+1);
    }
    char maxChar = ' ';
    for (char c : map.keySet()) {
      if (maxChar == ' ' ||map.get(c) > map.get(maxChar)) maxChar = c;
    }
    System.out.println("Maximum (E): " + maxChar);
  }

}
