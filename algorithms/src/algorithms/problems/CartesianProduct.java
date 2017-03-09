/**
 * 
 */
package algorithms.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Sudharsanan Muralidharan
 */
public class CartesianProduct {

  private List<List<String>> listOfLists = null;

  public CartesianProduct() {
    listOfLists = new ArrayList<List<String>>();
  }
  
  public void addList(String[] values) {
    List<String> inputList = new ArrayList<String>();
    for (int i = 0; i < values.length; i++) {
      inputList.add(values[i]);
    }
    listOfLists.add(inputList);
  }

  public List<List<String>> product() {
    List<List<String>> results = new ArrayList<List<String>>();
    product(listOfLists, new Stack<String>(), results, 0);
    return results;
  }

  @SuppressWarnings("unchecked")
  private void product(List<List<String>> lists, Stack<String> temp, List<List<String>> results, int index) {
    if (index >= lists.size()) {
      results.add((List<String>) temp.clone());
      return;
    }

    List<String> list = lists.get(index);
    for (int i = 0; i < list.size(); i++) {
      temp.push(list.get(i));
      product(lists, temp, results, index + 1);
      temp.pop();
    }
  }
}
