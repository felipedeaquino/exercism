import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(root.getData()) <= 0) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else if (value.compareTo(root.getData()) > 0) {
            root.setRight(insertRec(root.getRight(), value));
        }

        return root;
    }

    List<T> getAsSortedList() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), result);
            result.add(node.getData());
            inOrderTraversal(node.getRight(), result);
        }
    }

    List<T> getAsLevelOrderList() {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            result.add(node.getData());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

        return result;
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T data;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        };

        Node<T> getLeft() {
            return left;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        Node<T> getRight() {
            return right;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }

        T getData() {
            return data;
        }
    }
}
