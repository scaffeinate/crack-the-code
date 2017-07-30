/**
 *
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructures.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class WeaveArrays {

    private List<List<Integer>> weave(List<Integer> first, List<Integer> second) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        weave(first, second, new Stack<Integer>(), result);
        return result;
    }

    private void weave(List<Integer> first, List<Integer> second, Stack<Integer> prefix, List<List<Integer>> result) {
        if (first.isEmpty() || second.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(prefix);
            temp.addAll(first.isEmpty() ? second : first);
            result.add(temp);
            return;
        }

        for (int i = 0; i < first.size(); i++) {
            prefix.push(first.remove(i));
            weave(first, second, prefix, result);
            first.add(i, prefix.pop());
        }

        for (int i = 0; i < second.size(); i++) {
            prefix.push(second.remove(i));
            weave(first, second, prefix, result);
            second.add(i, prefix.pop());
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents("test_weave_arrays");
        List<Integer> first = new ArrayList<Integer>();
        List<Integer> second = new ArrayList<Integer>();
        WeaveArrays weaveArrays = new WeaveArrays();
        for (String line : input) {
            String[] values = line.split(" ");
            String action = values[0];
            switch (action) {
                case "insertFirst":
                    for (int i = 1; i < values.length; i++) {
                        first.add(Integer.parseInt(values[i]));
                    }
                    break;
                case "insertSecond":
                    for (int i = 1; i < values.length; i++) {
                        second.add(Integer.parseInt(values[i]));
                    }
                    break;
                case "weave":
                    List<List<Integer>> result = weaveArrays.weave(first, second);
                    for (List<Integer> list : result) {
                        System.out.println(list);
                    }
                    System.out.println(result.size());
                    break;
            }
        }
    }
}
