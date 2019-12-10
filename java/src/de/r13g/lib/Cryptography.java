package de.r13g.lib;

public class Cryptography {

  /**
   * encodes a given message using the Cesar cryptography method
   *
   * @param key      encryption key; amount of characters shifted
   * @param message  message to be necrypted
   * @return         encrypted message
   */
  public static String cesarEncode(int key, String message) {
    StringBuilder encoded = new StringBuilder();
    for (int c : message.toUpperCase().toCharArray()) {
      encoded.append(((char)((c+key-65)%26)+65));
    }
    return encoded.toString();
  }

  /**
   * decrypts a message that was encrypted using cesarEncrypt(int, String)
   *
   * @param key      encryption key; amount of characters shifted
   * @param encoded  encrypted message to be decrypted
   * @return         decrypted message
   */
  public static String cesarDecode(int key, String encoded) {
    StringBuilder message = new StringBuilder();
    for (int c : encoded.toUpperCase().toCharArray()) {
      message.append(((char)((c-key-65)%26)+65));
    }
    return message.toString();
  }

}
