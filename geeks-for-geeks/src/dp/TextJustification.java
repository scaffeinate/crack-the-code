package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Question:
 */
public class TextJustification {
    public String justify(String[] words, int W) {
        StringBuilder builder = new StringBuilder();
        Wrapper wrapper = justify(words, W, 0, new HashMap<Integer, Wrapper>());
        int i = 0;
        Node node = wrapper.node;
        while (node != null && i < words.length) {
            while (i <= node.index) {
                builder.append(words[i]).append(" ");
                i++;
            }
            node = node.parent;
            builder.append("\n");
        }

        return builder.toString();
    }


    private Wrapper justify(String[] words, int W, int index, Map<Integer, Wrapper> memo) {
        if (index == words.length) return null;

        if (!memo.containsKey(index)) {
            int numChars = 0, i = index, minBadness = Integer.MAX_VALUE;
            Node minNode = null;
            while (i < words.length && (numChars += words[i].length()) <= W) {
                Wrapper result = justify(words, W, i + 1, memo);
                Node node = new Node(i);
                if (result != null) {
                    node.parent = result.node;
                    int badness = (int) (result.badness + Math.pow((W - numChars), 3));
                    if (badness < minBadness) {
                        minBadness = badness;
                        minNode = node;
                    }
                } else {
                    minBadness = 0;
                    minNode = node;
                }
                i++;
                numChars++;
            }

            memo.put(index, new Wrapper(minBadness, minNode));
        }

        return memo.get(index);
    }

    class Wrapper {
        int badness = 0;
        Node node;

        public Wrapper(int badness, Node node) {
            this.badness = badness;
            this.node = node;
        }
    }

    class Node {
        int index = 0;
        Node parent;

        public Node(int index) {
            this.index = index;
        }
    }
}
