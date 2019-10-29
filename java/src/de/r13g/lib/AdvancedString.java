package de.r13g.lib;

public class AdvancedString {

  private String value;

  public AdvancedString(Object value) {
    this.value = String.valueOf(value);
  }

  public static AdvancedString fromString(String string) {
    return new AdvancedString(string);
  }

  @Override
  public String toString() {return value;}

  public AdvancedString replaceCharAt(int position, char replacement) {
    char[] array = this.value.toCharArray();
    array[position] = replacement;
    this.value = new String(array);
    return this;
  }

  public AdvancedString repeat(int times) {
    String original = this.value;
    this.append(original, times);
    return this;
  }

  public AdvancedString append(String string, int times) {
    for (int i = 0; i < times; i++) {
      this.value += string;
    }
    return this;
  }

  public int longestRun(int startIdx) {
    char c = this.value.charAt(startIdx);
    int i;
    for (i = 0; i < this.value.length() - startIdx; i++) {
      if (this.value.charAt(i+startIdx) != c) return i;
    }
    return i;
  }

}
