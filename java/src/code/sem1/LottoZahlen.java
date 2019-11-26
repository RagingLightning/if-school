package code.sem1;

import de.r13g.lib.ArrayTools;
import de.r13g.lib.Tools;
import de.r13g.lib.desktest.DeskTest;
import de.r13g.lib.desktest.IDeskTestTask;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LottoZahlen {

  static DeskTest test = null;
  Thread keyListener = null;

  public LottoZahlen() {
    int exp = 4;
    keyListener = new Thread(() -> new KeyListener());
    test = new DeskTest(new File(""), new TLottoZahlen(1,1));
    test.getTask().step();
  }

  public static void main(String[] args) {
    new LottoZahlen();
  }

  public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
      if(e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_SPACE) LottoZahlen.test.getTask().step();
      if(e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ENTER) LottoZahlen.test.getTask().resume();
    }
  }

  public class TLottoZahlen extends IDeskTestTask {

    int times;
    int num;

    public TLottoZahlen(int times, int num) {
      this.times = times;
      this.num = num;
    }

    @Override
    public void resume() {
      suspend = false;
      if (runThread != null) runThread.resume();
      else LottoZahlen.run(times, num);
    }

    @Override
    public void step() {
      suspend = true;
      if (runThread != null) runThread.resume();
      else LottoZahlen.run(times, num);
    }
  }

  public static void run(int times, int num) {
    test.getTask().runThread = Thread.currentThread();
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
    test.addConstant("num" , String.valueOf(num));
    Integer[] cnt = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    for (int i=0; i < num; i++) {
      test.addVariableValue("i", String.valueOf(i));
      int random = Tools.randomInt(1,49);
      test.addVariableValue("random", String.valueOf(random));
      cnt[random-1] += 1;
      test.addVariableValue("cnt[" + (random-1) + "]", String.valueOf(cnt[random-1]));
    }
    return cnt;
  }
}
