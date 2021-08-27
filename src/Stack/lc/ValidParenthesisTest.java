package Stack.lc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Project  ds-algorithm-java
 * File     JUnit5 Test Class.java.java
 *
 * @author LaiShuXin
 * @time 2021-08-27 18:17
 */
class ValidParenthesisTest {

  @Test
  void checkVaildString() {
    ValidParenthesis solution = new ValidParenthesis();
    assertEquals(true, solution.isValid("()"));
    assertEquals(true, solution.isValid("(){}[]"));
    assertEquals(false, solution.isValid("(]"));
    assertEquals(false, solution.isValid("([)]"));
    assertEquals(false, solution.isValid("["));
    assertEquals(false, solution.isValid("]"));
  }
}
