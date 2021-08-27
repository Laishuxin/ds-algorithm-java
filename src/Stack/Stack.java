package Stack;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-27 14:14
 */
public interface Stack<E> {
  public E push(E e);

  public boolean isEmpty();

  public E peek();

  public E pop();
}
