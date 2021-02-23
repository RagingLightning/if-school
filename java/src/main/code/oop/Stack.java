package code.oop;

public class Stack<E> {

  java.util.Stack<E> base = new java.util.Stack<>();

  public Stack() { }

  public E pop() {
    return base.pop();
  }

  public E peek() {
    return base.peek();
  }

  public void push(E item) {
    base.push(item);
  }

  public boolean isEmpty() {
    return base.isEmpty();
  }
}
