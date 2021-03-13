package code.oop;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<V> {

  private BinaryTree<V> left = null, right = null;
  private V value = null;

  public BinaryTree() {
  }

  public BinaryTree(V _value) {
    value = _value;
  }

  public boolean hasLeft() {return left != null;}

  public boolean hasRight() {return right != null;}

  public BinaryTree<V> getLeft() {
    if (left == null)
      throw new NullPointerException("Tree has no left subtree");
    return left;
  }

  public BinaryTree<V> getRight() {
    if (right == null)
      throw new NullPointerException("Tree has no right subtree");
    return right;
  }

  public void setLeft(BinaryTree<V> newLeft) {
    left = newLeft;
  }

  public void setRight(BinaryTree<V> newRight) {
    right = newRight;
  }

  public boolean hasValue() {
    return value != null;
  }

  public V getValue() {
    if (value == null)
      throw new NullPointerException("Tree root has no value");
    return value;
  }

  public void setValue(V newValue) {
    value = newValue;
  }

  public List<V> traverseInOrder() {
    List<V> traverse = new ArrayList<>();
    if (hasLeft())
      traverse.addAll(getLeft().traverseInOrder());
    if (hasValue())
      traverse.add(getValue());
    if (hasRight())
      traverse.addAll(getRight().traverseInOrder());
    return traverse;
  }

  public List<V> traversePreOrder() {
    List<V> traverse = new ArrayList<>();
    if (hasValue())
      traverse.add(getValue());
    if (hasLeft())
      traverse.addAll(getLeft().traverseInOrder());
    if (hasRight())
      traverse.addAll(getRight().traverseInOrder());
    return traverse;
  }

  public List<V> traversePostOrder() {
    List<V> traverse = new ArrayList<>();
    if (hasLeft())
      traverse.addAll(getLeft().traverseInOrder());
    if (hasRight())
      traverse.addAll(getRight().traverseInOrder());
    if (hasValue())
      traverse.add(getValue());
    return traverse;
  }
}
