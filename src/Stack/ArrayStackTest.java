package Stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project  ds-algorithm-java
 *
 * @author LaiShuXin
 * @time 2021-08-27 17:39
 */
class ArrayStackTest {

  private Stack<String> stack1;
  private Stack<String> stack2;
  private Stack<String> stack3;

  @BeforeEach
  void setUp() {
    stack1 = new ArrayStack<String>(1);
    stack1 = new ArrayStack<String>(4);
    stack1 = new ArrayStack<String>();
  }

  @Test
  void push() {
    stack1.push("1");
    assertEquals("1", stack1.peek());
    stack1.push("2");
    assertEquals("2", stack1.peek());
    stack1.push("3");
    assertEquals("3", stack1.peek());
  }

  @Test
  void isEmpty() {
    assertEquals(true, stack1.isEmpty());
    stack1.push("1");
    assertEquals(false, stack1.isEmpty());
  }

  @Test
  void peek() {
    assertEquals(null, stack1.peek());
    stack1.push("1");
    assertEquals("1", stack1.peek());
    stack1.push("2");
    assertEquals("2", stack1.peek());
    stack1.push("3");
    assertEquals("3", stack1.peek());
  }

  @Test
  void pop() {
    stack1.push("1");
    assertEquals("1", stack1.pop());
    stack1.push("1");
    stack1.push("2");
    assertEquals("2", stack1.pop());
    assertEquals("1", stack1.pop());
  }
}
