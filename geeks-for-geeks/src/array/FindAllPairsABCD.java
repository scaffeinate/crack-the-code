package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindAllPairsABCD {

  public List<Integer[]> findAllPairs(int[] arr) {
    List<Integer[]> resultList = new ArrayList<Integer[]>();
    Map<Integer, List<Integer[]>> productMap = new HashMap<Integer, List<Integer[]>>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int product = arr[i] * arr[j];
        List<Integer[]> tupleList = new ArrayList<Integer[]>();
        if (productMap.containsKey(product)) {
          tupleList = productMap.get(product);
        }

        tupleList.add(new Integer[] { arr[i], arr[j] });
        productMap.putIfAbsent(product, tupleList);
      }
    }

    for (Entry<Integer, List<Integer[]>> entry : productMap.entrySet()) {
      if (entry.getValue().size() > 1) {
        resultList.addAll(entry.getValue());
      }
    }

    return resultList;
  }

  public static void main(String[] args) {
    FindAllPairsABCD findAllPairsABCD = new FindAllPairsABCD();
    List<Integer[]> allPairs = findAllPairsABCD.findAllPairs(new int[] { 3, 4, 7, 1, 2, 9, 8 });
    for (Integer[] pair : allPairs) {
      System.out.println(pair[0] + "," + pair[1]);
    }
  }
}
