package code.sem1;

import de.r13g.lib.ArrayTools;
import de.r13g.lib.Tools;
import de.r13g.lib.desktest.DeskTest;
import de.r13g.lib.desktest.DeskTestTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LottoZahlen {

  public static void main(String[] args) {
    int exp = 4;
    run((int)Math.pow(10, exp), (int)Math.pow(10, exp));
    DeskTest test = new DeskTest(new File(""), (Runnable) () -> run());
  }

  public class TLottoZahlen implements DeskTestTask {

    Thread runThread = null;

    @Override
    public void resume() {
    }

    @Override
    public void step() {

    }

    @Override
    public void run() {
      LottoZahlen.run(10,10,false);
    }
  }

  public static void run(int times, int num, boolean interrupt) {
    HashMap<Integer, Integer[]> results = new HashMap<>();
    for (int n=0; n < times; n++) {
      System.out.println(n);
      Integer[] cnt = lottoZahlen(num);
      results.put(n, cnt);
      /*
      for (int i = 1; i <= cnt.length; i++) {
        System.out.println("" + i + ": " + cnt[i-1] + " (" + (cnt[i-1]*1.0/num)*100 + ")");
      }
      System.out.println();
      int minIdx = ArrayTools.minIndex(cnt);
      System.out.println("Min: " + (minIdx+1) + " (" + cnt[minIdx] + ")");
      int maxIdx = ArrayTools.maxIndex(cnt);
      System.out.println("Min: " + (maxIdx+1) + " (" + cnt[maxIdx] + ")");*/
    }
    System.out.println();
    System.out.println("-------------------------------------------------");
    HashMap<Integer, Integer> maxCount = new HashMap<>();
    for (Integer[] array : results.values()) {
      int maxIdx = ArrayTools.maxIndex(array);
      maxCount.put(maxIdx, maxCount.getOrDefault(maxIdx, 0)+1);
    }

    ArrayList<Integer> sortedMaxCount = new ArrayList<>(maxCount.keySet());
    Collections.sort(sortedMaxCount);
    int maxMaxCountIdx = -1;
    for (int k : sortedMaxCount) {
      System.out.println("" + (k+1) + ": " + maxCount.get(k));
      if (maxMaxCountIdx == -1) maxMaxCountIdx = k;
      maxMaxCountIdx = maxCount.get(k) > maxCount.get(maxMaxCountIdx) ? k : maxMaxCountIdx;
    }
    System.out.println("Max: " + maxMaxCountIdx + " (" + maxCount.get(maxMaxCountIdx) + "/" + (maxCount.get(maxMaxCountIdx)*1.0/times)*100 + ")");

  }

  private static Integer[] lottoZahlen(int num) {
    Integer[] cnt = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    for (int i=0; i < num; i++) {
      int random = Tools.randomInt(1,49);
      //System.out.print("" + random + " - ");
      cnt[random-1] += 1;
    }
    //System.out.println();
    return cnt;
  }
}
