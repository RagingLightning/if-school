package code.oop;

import java.util.LinkedList;

public class Queue<E> {

  private java.util.Queue<E> base = new LinkedList<E>();

  public Queue() { }

  public E dequeue() {
    return base.remove();
  }

  public void enqueue(E item) {
    base.add(item);
  }

  public E head() {
    return base.peek();
  }

  public boolean isEmpty() {
    return base.isEmpty();
  }

}
