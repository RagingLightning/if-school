package code.oop;
//TODO
import java.util.ArrayList;

public class DynArray<T> {

  private ArrayList<T> base = new ArrayList<T>();

  public boolean isEmpty() {
    return base.isEmpty();
  }

  public T getItem(int index) {
    return base.get(index);
  }

  public void setItem(int index, T item) {
    if (base.size() > index) {
      base.set(index, item);
    } else {
      throw new ArrayIndexOutOfBoundsException(index);
    }
  }

  public void insertAt(int index, T item) {
    if (base.size() >= index) {
      base.add(index, item);
    } else {
      throw new ArrayIndexOutOfBoundsException(index);
    }
  }

  public void append(T item) {
    base.add(item);
  }

  public void delete(int index) {
    if (base.size() > index) {
      base.remove(index);
    } else {
      throw new ArrayIndexOutOfBoundsException(index);
    }
  }

  public int getLength() {
    return base.size();
  }

}
