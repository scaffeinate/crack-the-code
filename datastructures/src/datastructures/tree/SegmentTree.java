package datastructures.tree;

import java.lang.reflect.Array;

/**
 * Created by sudharti on 8/22/17.
 */
public class SegmentTree<T> {

    private T[] tree;
    private T[] array;
    private TreeType type;
    private Class clazz;

    public enum TreeType {
        MAX,
        MIN,
        SUM
    }

    public SegmentTree(TreeType type, T[] array) {
        clazz = array.getClass().getComponentType();
        this.type = type;
        this.array = array;
        this.tree = (T[]) Array.newInstance(clazz, treeSize());
    }

    public void constructTree() {
        constructTree(array, tree, 0, array.length - 1, 0);
    }

    public T rangeOf(int start, int end) {
        return rangeOf(tree, 0, array.length - 1, start, end, 0);
    }

    public void update(int index, T updatedVal) {
        T diff = diff(updatedVal, array[index]);
        tree[index] = updatedVal;
        update(tree, 0, array.length - 1, index, diff, 0);
    }

    private void constructTree(T[] array, T[] tree, int start, int end, int pos) {
        if (start == end) {
            tree[pos] = array[start];
            return;
        }

        int middle = (start + end) / 2;
        int child = (2 * pos);

        constructTree(array, tree, start, middle, child + 1);
        constructTree(array, tree, middle + 1, end, child + 2);

        tree[pos] = tree[pos];
        tree[pos] = eval(tree[child + 1], tree[child + 2]);
    }

    private T rangeOf(T[] tree, int start, int end, int rangeStart, int rangeEnd, int pos) {
        if (rangeStart <= start && rangeEnd >= end) {
            return tree[pos];
        } else if (rangeEnd < start || rangeEnd > end) {
            return defaultValue();
        } else {
            int middle = (start + end) / 2;
            return eval(rangeOf(tree, start, middle, rangeStart, rangeEnd, (2 * pos) + 1),
                    rangeOf(tree, middle + 1, end, rangeStart, rangeEnd, (2 * pos) + 2));
        }
    }

    private void update(T[] tree, int start, int end, int index, T diff, int pos) {
        if (index < start || index > end) {
            return;
        }

        tree[pos] = add(tree[pos], diff);
        if (start != end) {
            int middle = (start + end) / 2;
            update(tree, start, middle, index, diff, (2 * pos) + 1);
            update(tree, middle + 1, end, index, diff, (2 * pos) + 2);
        }
    }

    private T eval(T t1, T t2) {
        if (clazz.equals(Integer.class)) {
            if (type == TreeType.MIN) {
                return ((Integer) t1).compareTo((Integer) t2) < 0 ? t1 : t2;
            } else if (type == TreeType.MAX) {
                return ((Integer) t2).compareTo((Integer) t1) < 0 ? t1 : t2;
            } else {
                return (T) Integer.valueOf(((Integer) t1) + ((Integer) t2));
            }
        } else if (clazz.equals(Double.class)) {
            if (type == TreeType.MIN) {
                return ((Double) t1).compareTo((Double) t2) < 0 ? t1 : t2;
            } else if (type == TreeType.MAX) {
                return ((Double) t2).compareTo((Double) t1) < 0 ? t1 : t2;
            } else {
                return (T) Double.valueOf(((Double) t1) + ((Double) t2));
            }
        } else if (clazz.equals(Long.class)) {
            if (type == TreeType.MIN) {
                return ((Long) t1).compareTo((Long) t2) < 0 ? t1 : t2;
            } else if (type == TreeType.MAX) {
                return ((Long) t2).compareTo((Long) t1) < 0 ? t1 : t2;
            } else {
                return (T) Long.valueOf(((Long) t1) + ((Long) t2));
            }
        }

        return null;
    }

    private T defaultValue() {
        if (type == TreeType.MAX) {
            if (clazz.equals(Integer.class)) {
                return (T) Integer.valueOf(Integer.MIN_VALUE);
            } else if (clazz.equals(Double.class)) {
                return (T) Double.valueOf(Double.MIN_VALUE);
            } else {
                return (T) Long.valueOf(Long.MIN_VALUE);
            }
        } else if (type == TreeType.MIN) {
            if (clazz.equals(Integer.class)) {
                return (T) Integer.valueOf(Integer.MAX_VALUE);
            } else if (clazz.equals(Double.class)) {
                return (T) Double.valueOf(Double.MAX_VALUE);
            } else {
                return (T) Long.valueOf(Long.MAX_VALUE);
            }
        } else {
            return (T) ((Object) 0);
        }
    }

    private T add(T t1, T t2) {
        if (clazz.equals(Integer.class)) {
            return (T) (Integer.valueOf(((Integer) t1) + ((Integer) t2)));
        } else if (clazz.equals(Double.class)) {
            return (T) (Double.valueOf(((Double) t1) + ((Double) t2)));
        } else {
            return (T) (Long.valueOf(((Long) t1) + ((Long) t2)));
        }
    }

    private T diff(T t1, T t2) {
        if (clazz.equals(Integer.class)) {
            return (T) (Integer.valueOf(((Integer) t1) - ((Integer) t2)));
        } else if (clazz.equals(Double.class)) {
            return (T) (Double.valueOf(((Double) t1) - ((Double) t2)));
        } else {
            return (T) (Long.valueOf(((Long) t1) - ((Long) t2)));
        }
    }

    private int treeSize() {
        int len = array.length;
        if ((len & len - 1) == 0) {
            return (2 * len) - 1;
        } else {
            int i = 0, num = 1;
            while (num < len) {
                num = (num << 1);
            }
            return (2 * num) - 1;
        }
    }

    public static void main(String[] args) {
        SegmentTree<Integer> tree = new SegmentTree<>(TreeType.MAX, new Integer[]{1, 3, 5, 7, 9, 11});
        tree.constructTree();
        System.out.println(tree.rangeOf(0, 5));
        tree.update(3, -5);
        System.out.println(tree.rangeOf(0, 5));
    }
}
