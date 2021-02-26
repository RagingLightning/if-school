package code.oop;

import java.util.LinkedList;

public class Queue<T> {

  private java.util.Queue<T> base = new LinkedList<T>();

  public Queue() { }

  public T dequeue() {
    return base.remove();
  }

  public void enqueue(T item) {
    base.add(item);
  }

  public T head() {
    return base.peek();
  }

  public boolean isEmpty() {
    return base.isEmpty();
  }

}
