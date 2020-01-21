package de.r13g.lib.desktest;

public abstract class IDeskTestTask {

  public boolean suspend = true;
  public Thread runThread = null;

  public abstract void resume();
  public abstract void step();

}
