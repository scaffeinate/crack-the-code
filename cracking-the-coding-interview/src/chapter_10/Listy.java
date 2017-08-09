package chapter_10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudharti on 8/9/17.
 */
public class Listy {
    private List<Integer> list;

    public Listy() {
        list = new ArrayList<Integer>();
    }

    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            return -1;
        }
        return list.get(index);
    }

    public void add(int value) {
        list.add(value);
    }
}
