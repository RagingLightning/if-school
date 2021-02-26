package code.oop;

public class Stack<T> {

  java.util.Stack<T> base = new java.util.Stack<>();

  public Stack() { }

  public T pop() {
    return base.pop();
  }

  public T peek() {
    return base.peek();
  }

  public void push(T item) {
    base.push(item);
  }

  public boolean isEmpty() {
    return base.isEmpty();
  }
}
