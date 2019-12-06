package de.r13g.lib;

public class Cryptography {

  public static String cesarEncode(int key, String message) {
    StringBuilder encoded = new StringBuilder();
    for (int c : message.toCharArray()) {
      encoded.append(((char)c+key));
    }
    return encoded.toString();
  }

  public static String cesarDecode(int key, String encoded) {
    StringBuilder message = new StringBuilder();
    for (int c : encoded.toCharArray()) {
      message.append(((char)c-key));
    }
    return message.toString();
  }

}
