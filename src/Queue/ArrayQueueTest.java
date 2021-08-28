package Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-27 23:42
 */
class ArrayQueueTest {

  private Queue<String> queue1;
  private Queue<String> queue2;

  @BeforeEach
  void setUp() {
    queue1 = new ArrayQueue<String>();
    queue2 = new ArrayQueue<String>(2);
  }

  @Test
  void testToString() {}

  @Test
  void enqueue() {
    queue1.enqueue("q1");
    assertEquals("q1", queue1.getFront());
    assertEquals(1, queue1.getSize());
    assertEquals(false, queue1.isEmpty());
    queue1.enqueue("q2");
    assertEquals("q1", queue1.getFront());
    assertEquals(2, queue1.getSize());
    queue1.enqueue("q3");
    assertEquals("q1", queue1.getFront());
  }

  @Test
  void dequeue() {
    try {
      queue1.dequeue();
      assertEquals(false, true);
    } catch (Exception e) {
      assertEquals(true, e != null);
    }

    queue1.enqueue("1");
    assertEquals("1", queue1.dequeue());
    queue1.enqueue("1");
    queue1.enqueue("2");
    assertEquals("1", queue1.dequeue());
    assertEquals("2", queue1.dequeue());
  }

  @Test
  void getFront() {
    assertEquals(null, queue1.getFront());
    queue1.enqueue("1");
    assertEquals("1", queue1.getFront());
    queue1.enqueue("2");
    assertEquals("1", queue1.getFront());
    queue1.dequeue();
    assertEquals("2", queue1.getFront());
  }

  @Test
  void getSize() {
    assertEquals(0, queue1.getSize());
    queue1.enqueue("1");
    assertEquals(1, queue1.getSize());
    queue1.enqueue("2");
    assertEquals(2, queue1.getSize());
    queue1.dequeue();
    assertEquals(1, queue1.getSize());
  }

  @Test
  void isEmpty() {
    assertEquals(true, queue1.isEmpty());
    queue1.enqueue("1");
    assertEquals(false, queue1.isEmpty());
    queue1.enqueue("2");
    assertEquals(false, queue1.isEmpty());
    queue1.dequeue();
    queue1.dequeue();
    assertEquals(true, queue1.isEmpty());
  }
}
