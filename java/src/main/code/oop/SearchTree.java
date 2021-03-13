package code.oop;

import java.util.HashMap;

public class SearchTree<K extends Comparable,V> extends BinaryTree<K> {

  HashMap<K,V> assign = new HashMap<K,V>();

  public SearchTree(K key, V value) {
    super(key);
    assign.put(key, value);
  }

  public boolean insert(K key, V value) {
    if (contains(key)) return false;
    assign.put(key, value);
    insertInTree(this, key);
    return true;
  }

  private void insertInTree(BinaryTree<K> tree, K key) {
    if (tree.getValue().compareTo(key) < 0) {
      if (tree.hasRight())
        insertInTree(tree.getRight(), key);
      else
        tree.setRight(new BinaryTree<>(key));
    } else {
      if (tree.hasLeft())
        insertInTree(tree.getLeft(), key);
      else
        tree.setLeft(new BinaryTree<>(key));
    }
  }

  public boolean contains(K needle) {
    if (searchTreeNode(this, needle)==null) return false;
    return true;
  }

  public boolean delete(K key) {
    BinaryTree<K> node = searchTreeNode(this, key);
    if (node == null) return false;
    BinaryTree<K> parent = getParentNode(this, node);
    boolean isLeft = parent.hasLeft() && parent.getLeft() == node;
    BinaryTree<K> left = node.hasLeft() ? node.getLeft() : null;
    BinaryTree<K> right = node.hasRight() ? node.getRight() : null;
    if (isLeft) {
      parent.setLeft(null);
    }
    if (left != null)
      for (K k : left.traverseInOrder()) {
        insertInTree(this, k);
      }
    if (right != null)
      for (K k : right.traverseInOrder()) {
        insertInTree(this, k);
      }
    return true;
  }

  public V search(K needle) {
    BinaryTree<K> t = searchTreeNode(this, needle);
    if (t == null) return null;
    return assign.get(t.getValue());
  }

  private BinaryTree<K> getParentNode(BinaryTree<K> tree, BinaryTree<K> kid) {
    if ((tree.hasLeft() && tree.getLeft() == kid) || (tree.hasRight() && tree.getRight() == kid)) {
      return tree;
    }
    BinaryTree<K> result = null;
    if (tree.hasLeft()) {
      result = getParentNode(tree.getLeft(), kid);
    }
    if (result != null) return result;
    if (tree.hasRight()) {
      return getParentNode(tree.getLeft(), kid);
    }
    return null;
  }

  private BinaryTree<K> searchTreeNode(BinaryTree<K> tree, K needle) {
    if (tree.getValue().equals(needle))
      return tree;
    if (tree.getValue().compareTo(needle) < 0) {
      if (!tree.hasRight()) return null;
      return searchTreeNode(tree.getRight(), needle);
    } else {
      if (!tree.hasLeft()) return null;
      return searchTreeNode(tree.getLeft(), needle);
    }

  }

  public V getMin(){
    BinaryTree<K> tree = this;
    while (tree.hasLeft())
      tree = tree.getLeft();
    return assign.get(tree.getValue());
  }

  public V getMax(){
   return assign.get(getMaxNode(this).getValue());

  }

  private BinaryTree<K> getMaxNode(BinaryTree<K> root) {
    while (root.hasRight())
      root = root.getRight();
    return root;
  }

  public V getPrior(K needle) {
    BinaryTree<K> node = searchTreeNode(this, needle);
    BinaryTree<K> parent = getParentNode(this, node);
    if (!parent.hasLeft()) return assign.get(parent.getValue());
    if (parent.getLeft() != node) return assign.get(getMaxNode(parent.getLeft()).getValue());
    while (parent.hasLeft() && parent.getLeft() == node) {
      node = parent;
      parent = getParentNode(this, parent);
    }
    if (parent.hasLeft()) return assign.get(getMaxNode(parent.getLeft()).getValue());
    return assign.get(parent.getValue());
  }

}
