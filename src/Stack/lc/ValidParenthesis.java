package Stack.lc;

import java.util.Stack;

/**
 * Project  ds-algorithm-java
 * File     null.java
 *
 * @author LaiShuXin
 * @time 2021-08-27 18:08
 */
public class ValidParenthesis {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '[' || c == '{' || c == '(') {
        stack.push(c);
      } else {
        if (c == ']') {
          if (stack.isEmpty() || stack.pop() != '[') return false;
        } else if (c == '}') {
          if (stack.isEmpty() || stack.pop() != '{') return false;
        } else if (c == ')') {
          if (stack.isEmpty() || stack.pop() != '(') return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
