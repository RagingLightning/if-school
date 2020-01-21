package de.r13g.lib.desktest;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DeskTest {

  private File file;

  private IDeskTestTask task;
  private DeskTestKeyListener keyListener;
  private boolean output;

  private LinkedHashMap<String, String> constants = new LinkedHashMap<>();
  private LinkedHashMap<String, HashMap<Integer, String>> variables = new LinkedHashMap<>();

  private int step = 1;

  public DeskTest(File file, IDeskTestTask task, boolean output) {
    this.file = file;
    this.task = task;
    this.output = output;
    keyListener = new DeskTestKeyListener(this);
    keyListener.start();
  }

  public IDeskTestTask getTask() {
    return task;
  }

  public void addConstant(String name, String value) {
    constants.put(name, value);
  }

  public void addVariableValue(String name, String value) {
    if (!variables.containsValue(name)) variables.put(name, new HashMap<>());
    variables.get(name).put(step, value);
    if (output)
     System.out.println(name + ": " + value);
    step += 1;
    if (task.suspend) task.runThread.suspend();
  }

  public void addVariable(String name) {
    if (!variables.containsValue(name)) variables.put(name, new HashMap<>());
    variables.get(name).put(0, null);
  }

  public void printResults() {
    System.out.println();
    System.out.println();
    System.out.println();
    for (int i=0;i<0;i++){}
  }

}
