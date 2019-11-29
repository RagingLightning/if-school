package de.r13g.lib.desktest;

import code.sem1.LottoZahlen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeskTestKeyListener extends Thread
{

  private DeskTest test;

  private volatile boolean doStep = false;
  private volatile boolean doResume = false;

  private KeyListener keyListener;

  public DeskTestKeyListener(DeskTest test)
  {
    this.test = test;
    keyListener = new KeyListener();
  }

  @Override
  public void run()
  {
    if (doStep) test.getTask().step();
    else if (doResume) test.getTask().resume();
  }

  public class KeyListener extends KeyAdapter
  {

    @Override
    public void keyPressed(KeyEvent e)
    {
      synchronized (DeskTestKeyListener.class) {
        switch (e.getID())
        {
          case KeyEvent.KEY_PRESSED:
            if (e.getKeyCode() == KeyEvent.VK_SPACE) doStep = true;
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) doResume = true;
            break;
          case KeyEvent.KEY_RELEASED:
            if (e.getKeyCode() == KeyEvent.VK_SPACE) doStep = false;
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) doResume = false;
        }
      }

    }
  }
}
