package code.sem1;

import de.r13g.lib.Cryptography;

public class VigenereCrypt {

  public static void main(String[] args) {
    System.out.println(Cryptography.vigenereEncode("zyxwvu", "\u0001\u0002"));
  }



}
