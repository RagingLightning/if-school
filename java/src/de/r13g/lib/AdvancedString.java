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

  /**
   * replaces a character at a given position.
   *
   * @param position character position to be substituted
   * @param replacement replacement character
   * @return this with replaced character
   */
  public AdvancedString replaceCharAt(int position, char replacement) {
    char[] array = this.value.toCharArray();
    array[position] = replacement;
    this.value = new String(array);
    return this;
  }

  /**
   * repeats the contents of this String
   *
   * @param times number of repetitions
   * @return this with repeated String
   */
  public AdvancedString repeat(int times) {
    String original = this.value;
    this.append(original, times);
    return this;
  }

  /**
   * appends a given String to this
   *
   * @param string String to be appended
   * @param times how often to append the String
   * @return this with appended String
   */
  public AdvancedString append(String string, int times) {
    for (int i = 0; i < times; i++) {
      this.value += string;
    }
    return this;
  }

  /**
   * Finds the longest Run of the character at a given position
   *
   * @param startIdx index of the first character in the sequence
   * @return number of equal characters in a row
   */
  public int longestRun(int startIdx) {
    char c = this.value.charAt(startIdx);
    int i;
    for (i = 0; i < this.value.length() - startIdx; i++) {
      if (this.value.charAt(i+startIdx) != c) return i;
    }
    return i;
  }

}
