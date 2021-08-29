package Queue;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-29 7:55
 */
public class LoopQueue<E> implements Queue<E> {

  private static final int DEFAULT_CAPACITY = 8;
  private E[] queue;
  private int size;
  private int front;
  private int tail;

  public LoopQueue() {
    this(DEFAULT_CAPACITY);
  }

  public LoopQueue(int capacity) {
    queue = (E[]) new Object[capacity + 1];
    size = front = tail = 0;
  }

  @Override
  public String toString() {
    StringBuilder strings = new StringBuilder();
    strings.append("Queue: [");
    for (int i = 0; i < size; i++) {
      strings.append(queue[(i + front) % queue.length]);
      if (i != size - 1) {
        strings.append(", ");
      }
    }
    strings.append("]");
    return strings.toString();
  }

  @Override
  public void enqueue(E e) {
    expand();
    queue[tail] = e;
    tail = (tail + 1) % queue.length;
    size++;
  }

  @Override
  public E dequeue() {
    if (size == 0) {
      return null;
    }

    E result = queue[front];
    queue[front] = null;
    front++;
    size--;
    shrink();
    return result;
  }

  @Override
  public E getFront() {
    if (size == 0) {
      return null;
    }
    return queue[front];
  }

  @Override
  public int getSize() {
    return size;
  }

  public int getCapacity() {
    return queue.length - 1;
  }

  @Override
  public boolean isEmpty() {
    return front == tail;
  }

  private void shrink() {
    int cap = getCapacity();
    if (size == cap / 4 && cap / 2 != 0) {
      move((E[]) new Object[cap / 2 + 1]);
    }
  }

  private void expand() {
    int cap = getCapacity();
    if (size == cap) {
      move((E[]) new Object[cap * 2 + 1]);
    }
  }

  private void move(E[] newQueue) {
    for (int i = 0; i < size; i++) {
      newQueue[i] = queue[(i + front) % queue.length];
    }

    queue = newQueue;
    front = 0;
    tail = size;
  }
}
