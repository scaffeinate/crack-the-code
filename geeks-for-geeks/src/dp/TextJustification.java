package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * Solution: https://www.youtube.com/watch?v=RORuwHiblPc
 */
public class TextJustification {
    public String justify(String[] words, int W) {
        StringBuilder builder = new StringBuilder();
        Wrapper wrapper = justify(words, W, 0, new HashMap<Integer, Wrapper>());
        int i = 0;
        Node node = wrapper.node;
        while (node != null && i < words.length) {
            while (i <= node.index) {
                builder.append(words[i]).append((i == node.index) ? "" : " ");
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
                    int badness = (int) (result.badness + Math.pow((W - numChars), 2));
                    if (badness < minBadness) {
                        minBadness = badness;
                        minNode = node;
                    }
                } else {
                    minBadness = (int) Math.pow((W - numChars), 2);
                    minNode = node;
                }
                i++;
                numChars++;
            }

            memo.put(index, new Wrapper(minBadness, minNode));
        }

        return memo.get(index);
    }

    public String justifyBottomUp(String[] words, int W) {
        StringBuilder builder = new StringBuilder();
        int[][] memo = new int[words.length][words.length];
        for (int i = 0; i < memo.length; i++)
            for (int j = 0; j < memo.length; j++) memo[i][j] = Integer.MAX_VALUE;

        for (int i = 0; i < memo.length; i++) {
            int numChars = 0;
            for (int j = i; j < memo.length && (numChars += words[j].length()) <= W; j++) {
                memo[i][j] = (int) (Math.pow((W - numChars), 2));
                numChars++;
            }
        }

        int[][] sources = new int[words.length][2];
        for (int i = words.length - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE, source = -1;
            for (int j = i; j < words.length && memo[i][j] != Integer.MAX_VALUE; j++) {
                int badness = memo[i][j] + ((j == words.length - 1) ? 0 : sources[j + 1][0]);
                if (badness < min) {
                    min = badness;
                    source = j + 1;
                }
            }
            sources[i][0] = min;
            sources[i][1] = source;
        }

        int i = 0;
        while (i < words.length) {
            int index = sources[i][1];
            while (i < index) {
                builder.append(words[i]).append((i == index - 1) ? "" : " ");
                i++;
            }
            builder.append("\n");
        }

        return builder.toString();
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
