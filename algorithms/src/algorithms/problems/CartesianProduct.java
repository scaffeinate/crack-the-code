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

  private void product(List<List<String>> lists, Stack<String> temp, List<List<String>> results, int index) {
    if (temp.size() == lists.size()) {
      results.add((List<String>) temp.clone());
      return;
    }

    for (int i = index; i < lists.size(); i++) {
      List<String> list = lists.get(i);
      for (int j = 0; j < list.size(); j++) {
        temp.push(list.remove(j));
        product(lists, temp, results, i + 1);
        list.add(j, temp.pop());
      }
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
