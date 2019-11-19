package de.r13g.lib.desktest;

public interface DeskTestTask extends Runnable {

  void resume();
  void step();

}
