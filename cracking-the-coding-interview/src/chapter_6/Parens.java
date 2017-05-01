package chapter_6;

import java.util.ArrayList;
import java.util.List;

public class Parens {
  public List<String> getParans(int n) {
    List<String> result = new ArrayList<String>();
    getParans(n, 0, 0, new StringBuffer(), result);
    return result;
  }

  private void getParans(int n, int numOpeningParams, int numClosingParamsToInsert, StringBuffer buffer,
      List<String> result) {

    if (numOpeningParams == n && numClosingParamsToInsert == 0) {
      result.add(buffer.toString());
    } else {
      if (numOpeningParams < n) {
        buffer.append('(');
        getParans(n, numOpeningParams + 1, numClosingParamsToInsert + 1, buffer, result);
        buffer.setLength(buffer.length() - 1);
      }

      if (numClosingParamsToInsert > 0) {
        buffer.append(')');
        getParans(n, numOpeningParams, numClosingParamsToInsert - 1, buffer, result);
        buffer.setLength(buffer.length() - 1);
      }
    }
  }
}
