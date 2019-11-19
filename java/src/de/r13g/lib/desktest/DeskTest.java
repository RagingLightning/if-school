package de.r13g.lib.desktest;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DeskTest {

  private File file;

  private DeskTestTask task;

  private LinkedHashMap<String, String> constants = new LinkedHashMap<>();
  private LinkedHashMap<String, HashMap<Integer, String>> variables = new LinkedHashMap<>();

  private int step = 1;

  public void step() {

  }

  public DeskTest(File file, DeskTestTask task) {
    this.file = file;
    this.task = task;
  }

  public void addConstant(String name, String value) {
    constants.put(name, value);
  }

  public void addVariableValue(String name, String value) {
    variables.get(name).put(step, value);
    step += 1;
  }

  public void addVariable(String name) {
    variables.get(name).put(0, null);
  }

}
