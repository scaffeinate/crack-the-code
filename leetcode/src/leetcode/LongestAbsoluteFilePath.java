/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * Problem: https://leetcode.com/problems/longest-absolute-file-path
 * 
 * @author Sudharsanan Muralidharan
 */
public class LongestAbsoluteFilePath {
  public int lengthLongestPath(String input) {
    Stack<String> stack = new Stack<String>();
    String[] lines = input.split("\n");
    int longest = 0, count = 0;
    for(String fileName:lines) {
      int level = level(fileName);
      while (!stack.isEmpty() && level <= level(stack.peek())) {
        String top = stack.pop();
        count -= (top.length() - level(top) + (isFile(top) ? 0 : 1));
      }
      
      stack.push(fileName);
      count += fileName.length() - level + 1;
      if(isFile(fileName)) {
        count -= 1;
        longest = Math.max(count, longest);
      }
    }

    return longest;
  }

  private boolean isFile(String fileName) {
    return fileName.indexOf('.') != -1;
  }
  
  private int level(String fileName) {
    return fileName.lastIndexOf("\t") + 1;
  }
}
