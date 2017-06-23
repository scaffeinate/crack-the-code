/**
 *
 */
package chapter_4;

import java.io.FileNotFoundException;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * Question 4.6: Write an algorithm to find the "next" node(i.e, in-order
 * successor) of a given node in a binary search tree. You may assume that each
 * node has a link to its parent.
 *
 * @author Sudharsanan Muralidharan
 */
public class Successor {

    private BinarySearchTree<Integer> tree = null;
    private TreeNode<Integer> root = null;

    public Successor() {
        tree = new BinarySearchTree<>(true);
    }

    private void constructTree(String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            String action = values[0];

            switch (action) {
                case "insertRoot":
                    root = tree.insertRoot(Integer.parseInt(values[1]));
                    break;
                case "insert":
                    tree.insert(root, Integer.parseInt(values[1]));
                    break;
                case "print":
                    System.out.println(tree.breadthFirstTraversal(root));
                    break;
                case "successor":
                    TreeNode<Integer> node = tree.find(root, Integer.parseInt(values[1]));
                    System.out.println(findSuccessor(node));
            }
        }
    }

    private Integer findSuccessor(TreeNode<Integer> node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node.data;
        } else {
            TreeNode<Integer> parent = node.parent;
            while (parent.right != null && parent.right.equals(node)) {
                node = parent;
                parent = node.parent;
                if (parent == null) {
                    return null;
                }
            }
            return parent.data;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents(4, "successor");
        Successor successor = new Successor();
        successor.constructTree(input);
    }
}
