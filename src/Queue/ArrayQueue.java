package Queue;

import Array.Array;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-27 23:39
 */
public class ArrayQueue<E> implements Queue<E> {

  private static final int DEFAULT_CAPACITY = 8;
  private Array<E> queue;

  public ArrayQueue(int capacity) {
    queue = new Array<E>(capacity);
  }

  public ArrayQueue() {
    this(DEFAULT_CAPACITY);
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public void enqueue(E e) {
    queue.addLast(e);
  }

  @Override
  public E dequeue() {
    return queue.removeFirst();
  }

  @Override
  public E getFront() {
    return queue.getFirst();
  }

  @Override
  public int getSize() {
    return queue.size();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }
}
