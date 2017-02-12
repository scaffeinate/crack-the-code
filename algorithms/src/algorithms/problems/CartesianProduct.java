/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class CartesianProduct {

  private List<List<String>> product(List<List<String>> lists) {
    List<List<String>> results = new ArrayList<List<String>>();
    product(lists, new Stack<String>(), results, 0);
    return results;
  }

  @SuppressWarnings("unchecked")
  private void product(List<List<String>> lists, Stack<String> temp, List<List<String>> results, int index) {
    if (temp.size() == lists.size()) {
      results.add((List<String>) temp.clone());
      return;
    }

    while (index < lists.size()) {
      List<String> list = lists.get(index);
      for (int i = 0; i < list.size(); i++) {
        temp.push(list.get(i));
        product(lists, temp, results, index + 1);
        temp.pop();
      }
      index++;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("test_cartesian_product");
    List<List<String>> listOfLists = new ArrayList<List<String>>();
    CartesianProduct cartesian = new CartesianProduct();
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "insertList":
        List<String> inputList = new ArrayList<String>();
        for (int i = 1; i < values.length; i++) {
          inputList.add(values[i]);
        }
        listOfLists.add(inputList);
        break;
      case "product":
        List<List<String>> results = cartesian.product(listOfLists);
        for (List<String> list : results) {
          System.out.println(list);
        }
        System.out.println(results.size());
        break;
      }
    }
  }
}
