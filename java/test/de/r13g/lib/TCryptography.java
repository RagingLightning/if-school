package de.r13g.lib;

import org.junit.jupiter.api.Test;

public class TCryptography {

  @Test
  public void testCaesarEncode() {
    assert Cryptography.caesarEncode(0,"") == "";
    assert Cryptography.caesarEncode(0, "abcdwxyz") == "abcdwxyz";
    assert Cryptography.caesarEncode(10, "abcdwxyz") == "klmnüéâä";
    assert Cryptography.caesarEncode(36, "abcdwxyz") == "klmnüéâä";
  }

}
