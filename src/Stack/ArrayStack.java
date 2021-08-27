package Stack;

import Array.Array;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-27 14:14
 */
public class ArrayStack<E> implements Stack<E> {

  private static final int DEFAULT_CAPACITY = 8;
  private final Array<E> arr;

  public ArrayStack(int capactiy) {
    arr = new Array(capactiy);
  }

  public ArrayStack() {
    this(DEFAULT_CAPACITY);
  }

  @Override
  public E push(E e) {
    arr.addLast(e);
    return e;
  }

  @Override
  public boolean isEmpty() {
    return arr.isEmpty();
  }

  @Override
  public E peek() {
    return arr.getLast();
  }

  @Override
  public E pop() {
    return arr.removeLast();
  }

  @Override
  public String toString() {
    return "ArrayStack{" + "arr=" + arr + '}';
  }

  public int capacity() {
    return arr.capacity();
  }

  public int size() {
    return arr.size();
  }
}
