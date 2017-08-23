package datastructures.tree;

/**
 * Created by sudharti on 8/22/17.
 */
public class SegmentTree<T> {

    private SegmentTreeNode<T>[] tree;
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
        this.tree = new SegmentTreeNode[treeSize()];
    }

    public void constructTree() {
        constructTree(array, tree, 0, array.length - 1, 0);
    }

    public T rangeOf(int start, int end) {
        return rangeOf(array, tree, start, end, 0);
    }

    private T rangeOf(T[] array, SegmentTreeNode<T>[] tree, int start, int end, int pos) {
        if (start <= tree[pos].start && end >= tree[pos].end) {
            return tree[pos].val;
        } else if (end < tree[pos].start || start > tree[pos].end) {
            return defaultValue();
        } else {
            return eval(rangeOf(array, tree, start, end, (2 * pos) + 1),
                    rangeOf(array, tree, start, end, (2 * pos) + 2));
        }
    }

    private void constructTree(T[] array, SegmentTreeNode<T>[] tree, int start, int end, int pos) {
        tree[pos] = new SegmentTreeNode<>();
        if (start == end) {
            tree[pos].val = array[start];
            tree[pos].start = start;
            tree[pos].end = end;
            return;
        }

        int middle = (start + end) / 2;
        int child = (2 * pos);

        constructTree(array, tree, start, middle, child + 1);
        constructTree(array, tree, middle + 1, end, child + 2);

        tree[pos] = tree[pos];
        tree[pos].val = eval(tree[child + 1].val, tree[child + 2].val);
        tree[pos].start = start;
        tree[pos].end = end;
    }


    private T eval(T t1, T t2) {
        if (t1 instanceof Integer) {
            if (type == TreeType.MIN) {
                return ((Integer) t1).compareTo((Integer) t2) < 0 ? t1 : t2;
            } else if (type == TreeType.MAX) {
                return ((Integer) t2).compareTo((Integer) t1) < 0 ? t1 : t2;
            } else {
                return (T) Integer.valueOf(((Integer) t1) + ((Integer) t2));
            }
        } else if (t1 instanceof Double) {
            if (type == TreeType.MIN) {
                return ((Double) t1).compareTo((Double) t2) < 0 ? t1 : t2;
            } else if (type == TreeType.MAX) {
                return ((Double) t2).compareTo((Double) t1) < 0 ? t1 : t2;
            } else {
                return (T) Double.valueOf(((Double) t1) + ((Double) t2));
            }
        } else if (t1 instanceof Long) {
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

    public static class SegmentTreeNode<T> {
        T val;
        int start = 0, end = 0;
    }

    public static void main(String[] args) {
        SegmentTree<Integer> tree = new SegmentTree<>(TreeType.MIN, new Integer[]{0, 2, 3, 4, 4, 2, 3, 10});
        tree.constructTree();
        System.out.println(tree.rangeOf(0, 9));
    }
}
