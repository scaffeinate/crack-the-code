package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Question: http://www.geeksforgeeks.org/find-pairs-ab-cd-array-satisfy-ab-cd/
 * 
 * @author Sudharsanan Muralidharan
 */
public class FindAllPairsABCD {

  public Map<Integer, List<Integer[]>> findAllPairs(int[] arr) {
    Map<Integer, List<Integer[]>> resultMap = new HashMap<Integer, List<Integer[]>>();
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
        resultMap.put(entry.getKey(), entry.getValue());
      }
    }

    return resultMap;
  }
}
