package code.sem1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VigenereKnacken {

  private static String MESSAGE;

  private static ArrayList<Integer> dist = new ArrayList<>();

  public static void main(String[] args) {

    try {
      File f = new File("G:\\eA-IF1-19-21\\300 Kryptologie\\315 Polyalphabetische Substitutionen\\vigenere_ab_text.txt");
      Scanner s = new Scanner(f);
      s.useDelimiter("\\Z");
      MESSAGE = s.next();
      s.close();
    } catch (Exception e){}

    scanForSequences();
    for(int i = 0 ; i < dist.size(); i++) {
      if (!(dist.get(i)%7==0)) dist.set(i, dist.get(i)*-1);
    }
    System.out.println("finish");
  }

  private static void scanForSequences() {
    for (int a = 0+65; a < 26+65;a++) {
      for (int b = 0+65; b < 26+65;b++) {
        for (int c = 0+65; c < 26+65;c++) {
          String sequence = String.format("%s%s%s", (char) a, (char) b, (char) c);
          System.out.printf("Checking Sequence %1$s" + "%n", sequence);
          Pattern pattern = Pattern.compile(sequence);
          Matcher matcher = pattern.matcher(MESSAGE);
          int lastIdx = 0;
          while (matcher.find(lastIdx)) {
            int currentIdx = matcher.end();
            if(lastIdx!=0)dist.add(currentIdx-lastIdx);
            lastIdx = currentIdx;
          }
        }
      }
    }
  }

 /* private static void probabilities() {
    for (int i = )
  }*/

}
