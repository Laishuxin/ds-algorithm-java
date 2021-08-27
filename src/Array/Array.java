package Array;

import com.sun.source.tree.NewClassTree;
import java.util.Arrays;

/**
 * Project  ds-algorithm-java
 * 封装数组
 *
 * @author LaiShuXin
 * @time 2021-08-26 23:29
 */
public class Array<E> {

  private static final int DEFAULT_CAPACITY = 8;
  private int size;
  private E[] container;

  public Array(int capacity) {
    capacity = capacity != 0 ? capacity : DEFAULT_CAPACITY;
    size = 0;
    container = (E[]) new Object[capacity];
  }

  public Array() {
    this(DEFAULT_CAPACITY);
  }

  public int capacity() {
    return container.length;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Get element by index.
   * @param index
   * @return element if exists or null.
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    return container[index];
  }

  public E getFirst() {
    return get(0);
  }

  public E getLast() {
    return get(size - 1);
  }

  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (container[i] == e) {
        return i;
      }
    }
    return -1;
  }

  public boolean contains(E e) {
    return find(e) >= 0;
  }

  public void set(int index, E e) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }
    container[index] = e;
  }

  public void addLast(E e) {
    add(size, e);
  }

  public void addFirst(E e) {
    add(0, e);
  }

  public void add(int index, E e) {
    expand();
    if (index < 0 || index >= container.length) {
      throw new IllegalArgumentException();
    }
    for (int i = size; i > index; i--) {
      container[i] = container[i - 1];
    }
    container[index] = e;
    size++;
  }

  public E removeLast() {
    return remove(size - 1);
  }

  public E removeFirst() {
    return remove(0);
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }
    E result = container[index];
    for (int i = index; i < size - 1; i++) {
      container[i] = container[i + 1];
    }
    container[size - 1] = null;
    size--;
    shrink();
    return result;
  }

  @Override
  public String toString() {
    return Arrays.toString(container);
  }

  private void expand() {
    if (size == capacity()) {
      E[] newContainer = (E[]) new Object[size * 2];
      move(newContainer, 0, size);
      container = newContainer;
    }
  }

  private void shrink() {
    int capacity = capacity();
    if (size == capacity / 4) {
      E[] newContainer = (E[]) new Object[capacity / 2];
      move(newContainer, 0, capacity / 4);
      container = newContainer;
    }
  }

  private void move(E[] newContainer, int start, int end) {
    for (int i = start; i < end; i++) {
      newContainer[i] = container[i];
    }
  }
}
