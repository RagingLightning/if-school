package code.oop.oop210223;

import code.oop.Point;
import code.oop.Queue;
import code.oop.Stack;

public class Ex756 {

  Point[] points = new Point[7];
  Stack<Point> s1, s2;
  Queue<Point> q1, q2;

  Ex756() {
    points[0] = new Point("Woi", 2, 2);
    points[1] = new Point("Xau", 7, 8);
    points[2] = new Point("Dou", 1, 9);
    points[3] = new Point("Cei", 3, 4);
    points[4] = new Point("Aua", 9, 1);
    points[5] = new Point("Noi", 2, 3);
    points[6] = new Point("Bee", 4, 8);

    s1 = new Stack<>();
    s2 = new Stack<>();
    q1 = new Queue<>();
    q2 = new Queue<>();

    for (Point p : points) {
      q1.enqueue(p);
    }

    System.out.println("---");

    for (int i = 0; i < points.length; i++) {
      Point p = q1.dequeue();
      System.out.println(p.name);
      q1.enqueue(p);
    }

    System.out.println("---");

    for (int i = 0; i < points.length; i++) {
      Point p = q1.dequeue();
      System.out.println(p.name);
      q1.enqueue(p);
    }

    System.out.println("---");

    print(q1);

    System.out.println("---");

    Point first = q1.head();
    for (int i = 0; i < points.length; i++) {
      Point p = q1.dequeue();
      first = first.name.compareTo(p.name) > 0 ? p : first;
      q1.enqueue(p);
    }
    System.out.println(first.name);

    System.out.println("---");

    while (!q1.isEmpty()) {
      String lowest = q1.head().name;
      for (int i = 0; i < points.length; i++) {
        Point p = q1.dequeue();
        lowest = lowest.compareTo(p.name) > 0 ? p.name : lowest;
        q1.enqueue(p);
      }
      for (int i = 0; i < points.length; i++) {
        Point p = q1.dequeue();
        if (p.name == lowest)
          s1.push(p);
        q1.enqueue(p);
      }
    }

    print(s1);

    System.out.println("---");

    for (int i = 0; i < points.length; i++) {
      Point p = s1.pop();
      if (p.x==2)
        System.out.println(p);
      s2.push(p);
    }
    s1 = invertStack(s2);
    s2 = new Stack<>();

    System.out.println("---");

    for (int i = 0; i < points.length; i++) {
      Point p = s1.pop();
      if (p.name.charAt(1)=='o')
        System.out.println(p);
      s2.push(p);
    }
    s1 = invertStack(s2);
    s2 = new Stack<>();

    System.out.println("---");

    String concat = "";
    for (int i = 0; i < points.length; i++) {
      Point p = s1.pop();
      concat.concat(String.valueOf(p.name.charAt(1)));
    }
    System.out.println(concat);

    System.out.println("---");

    for (int i = 0; i < points.length; i++) {
      Point p1 = s1.pop();
      Point p2 = q1.dequeue();
      if (!(p1.name.charAt(2) =='u'))
        s2.push(p1);
      if (!(p2.name.charAt(2)=='u'))
        q1.enqueue(p2);
    }
    s1 = invertStack(s2);
    s2 = new Stack<>();

    String o = "Ich bin ein String zum Testen von Ersetzungen an bestimmten Positionen";
  }

  public void print(Queue q) {
    while (!q.isEmpty()) {
      System.out.println(q.dequeue());
    }
  }

  public void print(Stack s) {
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  public <E> Stack invertStack(Stack<E> stack) {
    Stack<E> rev = new Stack<>();
    while (!stack.isEmpty()) {
      rev.push(stack.pop());
    }
    return rev;
  }

  public <E> Queue stackToQueue(Stack<E> stack) {
    Queue<E> queue = new Queue<>();
    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }
    return queue;
  }

  public <E> Queue invertQueue(Queue<E> queue) {
    Queue<E> rev = new Queue<>();
    while (!queue.isEmpty()) {
      rev.enqueue(queue.dequeue());
    }
    return rev;
  }

  public static void main(String[] args) {
    new Ex756();
  }

}
