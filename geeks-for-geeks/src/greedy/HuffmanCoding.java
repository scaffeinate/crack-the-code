package greedy;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by sudharti on 8/14/17.
 */
public class HuffmanCoding {
    public static String encode(String s) {
        StringBuilder builder = new StringBuilder();
        Map<Character, HuffmanTreeNode> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            HuffmanTreeNode node = freqMap.getOrDefault(c, new HuffmanTreeNode());
            node.c = c;
            node.incrementFreq();
            freqMap.put(c, node);
        }

        PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<>(Comparator.comparing(HuffmanTreeNode::freq));
        Set<Entry<Character, HuffmanTreeNode>> entrySet = freqMap.entrySet();
        for (Entry<Character, HuffmanTreeNode> entry : entrySet) {
            queue.offer(entry.getValue());
        }

        HuffmanTreeNode root = constructHuffmanTree(queue);
        Map<Character, String> encodings = new HashMap<>();
        findEncodings(root, new StringBuilder(), encodings);

        for (int i = 0; i < s.length(); i++) {
            builder.append(encodings.get(s.charAt(i)));
        }

        return builder.toString();
    }


    private static void findEncodings(HuffmanTreeNode root, StringBuilder builder, Map<Character, String> encodings) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            encodings.put(root.c, builder.toString());
        } else {
            findEncodings(root.left, builder.append("0"), encodings);
            builder.setLength(builder.length() - 1);
            findEncodings(root.right, builder.append("1"), encodings);
            builder.setLength(builder.length() - 1);
        }
    }

    private static HuffmanTreeNode constructHuffmanTree(PriorityQueue<HuffmanTreeNode> queue) {
        while (queue.size() > 1) {
            HuffmanTreeNode node = new HuffmanTreeNode();
            if (!queue.isEmpty()) {
                node.left = queue.poll();
                node.freq = node.left.freq;
            }

            if (!queue.isEmpty()) {
                node.right = queue.poll();
                node.freq += node.right.freq;
            }

            queue.offer(node);
        }

        return queue.poll();
    }

    static class HuffmanTreeNode {
        char c = 0;
        int freq = 0;
        HuffmanTreeNode left = null;
        HuffmanTreeNode right = null;

        public int freq() {
            return freq;
        }

        public void incrementFreq() {
            freq++;
        }
    }
}
