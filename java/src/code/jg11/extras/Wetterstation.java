package code.jg11.extras;

import de.r13g.lib.PerlinNoise;
import de.r13g.lib.console.ArrayConsole;
import de.r13g.lib.console.ConsoleExt;

public class Wetterstation {

  private int n_tage = 7; 
  private double noise_deltaX = 0.5d;
  private double noise_deltaY = 0.1d;
  private double noise_offset = 0.5d;
  private double noise_scale = 30d;
  private double noise_add = 24d;

  public static void main(String[] args) {
    new Wetterstation(args);
  }

  public Wetterstation(String[] args) {
    if (args.length>=1) n_tage = Integer.parseInt(args[0]);
    if (args.length>=2) noise_deltaX = Double.parseDouble(args[1]);
    if (args.length>=3) noise_deltaY = Double.parseDouble(args[2]);
    if (args.length>=4) noise_offset = Double.parseDouble(args[3]);
    if (args.length>=5) noise_scale = Double.parseDouble(args[4]);
    

    //[tag][stunde]
    double[][] werte = new double[n_tage][24];
    //ArrayList<double[]> l_werte = new ArrayList<>();


    //Zufallswerte f�r Wetterdaten
    for (int i = 0; i < werte.length; i++) {
      for (int j = 0; j < werte[0].length; j++) {
        werte[i][j] = (PerlinNoise.noise(i * noise_deltaX, j * noise_deltaY, noise_offset) * noise_scale) + noise_add;
      }
    }

    operate:
      while (true) {
        System.out.println("**Auswertung Wetterstation**");
        System.out.println("1: Auswertung entlang der Tage");
        System.out.println("2: Auswertung entlang der Stunden");
        System.out.println("3: Ausgabe der Werte");
        int mode = ConsoleExt.getInputInt("Modus");
        switch (mode) {
        case 1:
          while (true) {
            System.out.println("-- Tageweise Auswertung --");
            System.out.println("1: Durchschnittstemperatur");
            System.out.println("2: Min / Max");
            System.out.println("3: Max delta");
            System.out.println("4: Anderer Modus");
            System.out.println("5: Ende");

            int m = ConsoleExt.getInputInt("Modus");

            if (m==4) break;
            if (m==5) break operate;

            switch (m) {
            case 1:
              for (int i = 0; i < werte.length; i++) { //Tage
                double sum = 0.0d;
                for (int j = 0; j < werte[0].length; j++) { //Stunden
                  sum += werte[i][j];
                }
                System.out.println("Durchschnitt f�r Tag " + (i + 1) + ": " + (sum / werte[0].length));

              }
              break;
            case 2:
              for (int i = 0; i < werte.length; i++) { //Tage
                double min = Double.MAX_VALUE;
                double max = Double.MIN_VALUE;
                for (int j = 0; j < werte[0].length; j++) { //Stunden
                  min = werte[i][j] < min ? werte[i][j] : min;
                  max = werte[i][j] > max ? werte[i][j] : max;
                }
                System.out.println("Minimalwert f�r Tag " + (i + 1) + ": " + min);
                System.out.println("Maximalwert f�r Tag " + (i + 1) + ": " + max);
              }
              break;
            case 3:
              for (int i = 0; i < werte.length; i++) {
                double max_delta = 0.0d;
                int i_max_delta = -1;
                for (int j = 0; j < werte[0].length-1 ; j++) {
                  double delta = Math.abs(werte[i][j] - werte[i][j+1]);
                  if (delta > max_delta) {
                    max_delta = delta;
                    i_max_delta = j;
                  }
                }
                System.out.println("Maximale Temperaturdifferenz f�r Tag " + (i + 1) + ": " + max_delta + " zwischen Stunde " + i_max_delta + " und " + (i_max_delta + 1));
              }
              break;
            }
          }
          break;
        case 2:
          while (true) {
            System.out.println("-- Stundenweise Auswertung --");
            System.out.println("1: Durchschnittstemperatur");
            System.out.println("2: Min / Max");
            System.out.println("3: Max delta");
            System.out.println("4: Anderer Modus");
            System.out.println("5: Ende");

            int m = ConsoleExt.getInputInt("Modus");

            if (m==4) break;
            if (m==5) break operate;

            switch (m) {
            case 1:
              for (int j = 0; j < werte[0].length; j++) { //Stunden
                double sum = 0.0d;
                for (int i = 0; i < werte.length; i++) { //Tage
                  sum += werte[i][j];
                }
                System.out.println("Durchschnitt f�r Stunde " + j + ": " + (sum / werte.length));

              }
              break;
            case 2:
              for (int j = 0; j < werte[0].length; j++) { //Tage
                double min = Double.MAX_VALUE;
                double max = Double.MIN_VALUE;
                for (int i = 0; i < werte.length; i++) { //Stunden
                  min = werte[i][j] < min ? werte[i][j] : min;
                  max = werte[i][j] > max ? werte[i][j] : max;
                }
                System.out.println("Minimalwert f�r Stunde " + j + ": " + min);
                System.out.println("Maximalwert f�r Stunde " + j + ": " + max);
              }
              break;
            case 3:
              for (int j = 0; j < werte[0].length; j++) {
                double max_delta = 0.0d;
                int i_max_delta = -1;
                for (int i = 0; i < werte.length-1 ; i++) {
                  double delta = Math.abs(werte[i][j] - werte[i+1][j]);
                  if (delta > max_delta) {
                    max_delta = delta;
                    i_max_delta = i;
                  }
                }
                System.out.println("Maximale Temperaturdifferenz f�r Stunde " + j + ": " + max_delta + " zwischen Tag " + (i_max_delta + 1) + " und " + (i_max_delta + 2));
              }
              break;
            }
          }
          break;
        case 3:
          for(int i = 0; i < werte.length; i++) {
            System.out.println("Tag " + i + ":");
            ArrayConsole.printDoubleArray("Werte", werte[i]);
          }
          break;
          
        }
      }



  }

}
