package datastructures.tree;

import java.util.Stack;

public class BinarySearchTree<T> extends AbstractBinaryTree<T> {

    public BinarySearchTree() {

    }

    public BinarySearchTree(boolean linkToParent) {
        super.linkToParent = linkToParent;
    }

    public TreeNode<T> insert(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<T>(data);
        } else {
            TreeNode<T> node = null;
            if (root.compareTo(data) >= 0) {
                node = insert(root.left, data);
                root.left = node;
                if (linkToParent) {
                    node.parent = root;
                }
            } else {
                node = insert(root.right, data);
                root.right = node;
                if (linkToParent) {
                    node.parent = root;
                }
            }
        }
        return root;
    }

    public TreeNode<T> delete(TreeNode<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (root.data.equals(data)) {
            // Leaf node
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right; // Node with only right child
            } else if (root.right == null) {
                root = root.left; // Node with only left child
            } else {
                // Node with two children
                T minVal = findRightMin(root.right); // Find min of right subTree
                root.data = minVal; // Set minVal to current node data
                root.right = delete(root.right, minVal); // Delete the minVal
            }
        } else {
            if (root.compareTo(data) >= 0) {
                root.left = delete(root.left, data);
            } else {
                root.right = delete(root.right, data);
            }
        }

        return root;
    }

    private T findRightMin(TreeNode<T> root) {
        if (root.left == null) {
            T data = root.data;
            return data;
        } else {
            return findRightMin(root.left);
        }
    }

    public String depthFirstPreOrder(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        StringBuilder builder = new StringBuilder();
        stack.push(root);

        builder.append("[ ");

        while (!stack.isEmpty()) {
            TreeNode<T> top = stack.peek();

            if (!top.visited) {
                builder.append(top.data).append(" ");
                top.visited = true;
            }
            TreeNode<T> child = null;
            if (top.left != null && !top.left.visited) {
                child = top.left;
            } else if (top.right != null && !top.right.visited) {
                child = top.right;
            }

            if (child == null) {
                stack.pop();
            } else {
                stack.push(child);
            }
        }

        builder.append("]");
        resetVisited(getRoot());
        return builder.toString();
    }

    public String depthFirstInOrder(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        StringBuilder builder = new StringBuilder();

        stack.push(root);
        builder.append("[ ");

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.peek();

            if (node.left != null && !node.left.visited) {
                stack.push(node.left);
            } else if (!node.visited) {
                builder.append(node.data + " ");
                node.visited = true;
                if (node.right != null && !node.right.visited) {
                    stack.push(node.right);
                } else {
                    stack.pop();
                }
            } else {
                stack.pop();
            }
        }

        builder.append("]");
        resetVisited(getRoot());
        return builder.toString();
    }

    public String depthFirstPostOrder(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        StringBuilder builder = new StringBuilder();

        stack.push(root);
        builder.append("[ ");

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.peek();
            if (node.left != null && !node.left.visited) {
                stack.push(node.left);
            } else if (node.right != null && !node.right.visited) {
                stack.push(node.right);
            } else if (!node.visited) {
                builder.append(node.data + " ");
                node.visited = true;
            } else {
                stack.pop();
            }
        }

        builder.append("]");
        resetVisited(getRoot());
        return builder.toString();
    }

    public TreeNode<T> find(TreeNode<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (root.data.equals(data)) {
            return root;
        } else {
            if (root.compareTo(data) >= 0) {
                return find(root.left, data);
            } else {
                return find(root.right, data);
            }
        }
    }

    public T search(TreeNode<T> root, T data) {
        while (root != null && !root.data.equals(data)) {
            if (root.compareTo(data) >= 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return (root != null) ? root.data : null;
    }

    public String findPath(TreeNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        if (root.data.equals(data)) {
            return root.data.toString();
        } else {
            if (root.compareTo(data) >= 0) {
                String nextElement = findPath(root.left, data);
                if (nextElement != null) {
                    builder.append(root.data).append("->left->").append(nextElement);
                } else {
                    builder = null;
                }
            } else {
                String nextElement = findPath(root.right, data);
                if (nextElement != null) {
                    builder.append(root.data).append("->right->").append(nextElement);
                } else {
                    builder = null;
                }
            }
        }

        return (builder == null) ? null : builder.toString();
    }

    public T getMinimum(TreeNode<T> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public T getMaximum(TreeNode<T> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    private void resetVisited(TreeNode<T> root) {
        if (root != null) {
            root.visited = false;
            resetVisited(root.left);
            resetVisited(root.right);
        }
    }
}
