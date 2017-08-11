package chapter_10;

/**
 * Created by sudharti on 8/11/17.
 */
public class TreeNodeWithRank {
    protected TreeNodeWithRank left = null, right = null;
    protected int value = 0;
    private int rank = 0;

    public TreeNodeWithRank(int value) {
        this.value = value;
    }

    public void incrementRank() {
        this.rank++;
    }

    public int getRank() {
        return this.rank;
    }
}
