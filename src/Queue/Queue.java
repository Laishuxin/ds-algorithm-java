package Queue;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-27 23:06
 */
public interface Queue<E> {
  public void enqueue(E e);

  public E dequeue();

  public E getFront();

  public int getSize();

  public boolean isEmpty();
}
