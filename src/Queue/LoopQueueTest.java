package Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-29 8:33
 */
class LoopQueueTest {

  private LoopQueue<String> queue1;
  private LoopQueue<String> queue2;

  @BeforeEach
  void setUp() {
    queue1 = new LoopQueue<String>();
    queue2 = new LoopQueue<String>(2);
  }

  @Test
  void testToString() {}

  @Test
  void enqueue() {
    queue1.enqueue("q1");
    System.out.println(queue1.toString());
    assertEquals("q1", queue1.getFront());
    assertEquals(1, queue1.getSize());
    assertEquals(false, queue1.isEmpty());
    queue1.enqueue("q2");
    System.out.println(queue1.toString());
    assertEquals("q1", queue1.getFront());
    assertEquals(2, queue1.getSize());
    queue1.enqueue("q3");
    System.out.println(queue1.toString());
    assertEquals("q1", queue1.getFront());

    queue2.enqueue("q1");
    queue2.enqueue("q2");
    queue2.enqueue("q3");
    queue2.enqueue("q4");
    assertEquals(4, queue2.getCapacity());
    assertEquals(4, queue2.getSize());
    assertEquals("q1", queue2.getFront());
  }

  @Test
  void dequeue() {
    assertEquals(null, queue1.dequeue());

    queue1.enqueue("1");
    assertEquals("1", queue1.dequeue());
    assertEquals(0, queue1.getSize());
    assertEquals(8, queue1.getCapacity());

    queue1.enqueue("1");
    assertEquals("1", queue1.dequeue());
    assertEquals(0, queue1.getSize());
    assertEquals(8, queue1.getCapacity());

    queue1.enqueue("2");
    assertEquals("2", queue1.dequeue());
    assertEquals(0, queue1.getSize());
    assertEquals(8, queue1.getCapacity());

    String r = null;
    queue2.enqueue("q1");
    queue2.enqueue("q2");
    queue2.enqueue("q3");
    queue2.enqueue("q4");
    queue2.enqueue("q5");
    queue2.enqueue("q6");

    r = queue2.dequeue();
    assertEquals("q1", r);
    assertEquals(5, queue2.getSize());
    assertEquals(8, queue2.getCapacity());

    queue2.dequeue();
    queue2.dequeue();
    queue2.dequeue();
    r = queue2.dequeue();
    assertEquals("q5", r);
    assertEquals(1, queue2.getSize());
    assertEquals(2, queue2.getCapacity());
  }

  @Test
  void getFront() {
    queue2.enqueue("q1");
    queue2.enqueue("q2");
    queue2.enqueue("q3");
    assertEquals("q1", queue2.getFront());

    queue2.dequeue();
    assertEquals("q2", queue2.getFront());

    queue2.enqueue("q4");
    assertEquals("q2", queue2.getFront());

    queue2.dequeue();
    assertEquals("q3", queue2.getFront());

    queue2.dequeue();
    assertEquals("q4", queue2.getFront());

    queue2.dequeue();
    assertEquals(null, queue2.getFront());
  }

  @Test
  void getSize() {
    assertEquals(0, queue2.getSize());

    queue2.enqueue("q1");
    queue2.enqueue("q2");
    queue2.enqueue("q3");
    assertEquals(3, queue2.getSize());

    queue2.dequeue();
    assertEquals(2, queue2.getSize());

    queue2.dequeue();
    queue2.dequeue();
    assertEquals(0, queue2.getSize());

    queue2.dequeue();
    assertEquals(0, queue2.getSize());
  }

  @Test
  void isEmpty() {
    assertEquals(true, queue2.isEmpty());
    queue2.enqueue("q1");
    assertEquals(false, queue2.isEmpty());

    queue2.enqueue("q1");
    assertEquals(false, queue2.isEmpty());

    queue2.dequeue();
    assertEquals(false, queue2.isEmpty());

    queue2.dequeue();
    assertEquals(true, queue2.isEmpty());

    queue2.dequeue();
    assertEquals(true, queue2.isEmpty());
  }

  @Test
  void getCapacity() {
    assertEquals(2, queue2.getCapacity());

    queue2.enqueue("q1");
    assertEquals(2, queue2.getCapacity());

    queue2.enqueue("q2");
    assertEquals(2, queue2.getCapacity());

    queue2.enqueue("q3");
    assertEquals(4, queue2.getCapacity());

    queue2.enqueue("q4");
    assertEquals(4, queue2.getCapacity());

    queue2.enqueue("q5");
    assertEquals(8, queue2.getCapacity());

    queue2.dequeue();
    assertEquals(8, queue2.getCapacity());

    queue2.dequeue();
    queue2.dequeue();
    assertEquals(4, queue2.getCapacity());

    queue2.dequeue();
    assertEquals(2, queue2.getCapacity());

    queue2.dequeue();
    queue2.dequeue();
    assertEquals(1, queue2.getCapacity());
  }
}
