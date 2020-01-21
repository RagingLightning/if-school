package de.r13g.lib;

@SuppressWarnings("unused")
public class Cryptography {

  /**
   * encodes a given message using the Caesar cryptography method
   *
   * @param key      encryption key; amount of characters shifted
   * @param message  message to be necrypted
   * @return         encrypted message
   */
  public static String caesarEncode(int key, String message) {
    key = key < 0 ? 0x7F - key : key;
    StringBuilder encoded = new StringBuilder();
    for (int c : message.toUpperCase().toCharArray()) {
      encoded.append(((char)c+key%0x7F));
    }
    return encoded.toString();
  }

  public static char caesarEncode(int key, char message) {
    key = key < 0 ? 0x7F - key : key;
    return (char)(message+key%0x7F);
  }

  /**
   * decrypts a message that was encrypted using caesarEncrypt(int, String)
   *
   * @param key      encryption key; amount of characters shifted
   * @param encoded  encrypted message to be decrypted
   * @return         decrypted message
   */
  public static String caesarDecode(int key, String encoded) {
    key = key < 0 ? 0x7F - key : key;
    return caesarEncode(-key, encoded);
  }

  public static char caesarDecode(int key, char encoded) {
    key = key < 0 ? 0x7F - key : key;
    return caesarEncode(-key, encoded);
  }

  /**
   * encryypts a given message using the Vigenere procedure
   *
   * @param message text to be encrypted
   * @param key     key to be used for encryption
   * @return        encrypted message
   */
  public static String vigenereEncode(String message, String key) {
    StringBuilder encoded = new StringBuilder();

    for (int i = 0; i < message.length(); i++) {
      char keyltr = key.charAt(i%key.length());
      char encodedltr = caesarEncode((int)keyltr, message.charAt(i));
      encoded.append(encodedltr);
    }

    return encoded.toString();
  }

  /**
   * decrypts a message that was encrypted using vigenereEncode(String, String)
   *
   * @param encoded text to be decrypted
   * @param key     key to be used for decryption
   * @return        decrypted message
   */
  public static String vigenereDecode(String encoded, String key) {
    StringBuilder message = new StringBuilder();

    for (int i = 0; i < message.length(); i++) {
      char keyltr = key.charAt(i%key.length());
      char decodedltr = Cryptography.caesarDecode((int)keyltr, message.charAt(i));
      message.append(decodedltr);
    }

    return message.toString();
  }

}
