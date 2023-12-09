/*
 * Course: CSC1120
 * Fall 2023
 * Homework 14 - Tree rotations
 * Name: Dr. Taylor
 * Created: 9/25/2023
 */

package mamamia5x;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents a binary tree of arbitrary type. A tree consists of
 * a value for the root element, reference to two sub-trees and to
 * the parent.
 * @param <E> Type of values to be stored in the binary tree
 */
public class BinaryTree<E> {
    private E value;
    private BinaryTree<E> parent;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    /**
     * Creates a binary tree containing one element with the specified value.
     * @param value The value of the element in the tree
     */
    public BinaryTree(E value) {
        this(value, null, null);
    }

    /**
     * Creates a binary tree whose root node contains the specified value.
     * The tree has subtrees specified by left and right.
     * @param value The value of the element at the root of the tree
     * @param left The left subtree
     * @param right The right subtree
     */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        this.value = value;
        parent = null;
        leftChild = left;
        if (left != null) {
            left.parent = this;
        }
        rightChild = right;
        if (right != null) {
            right.parent = this;
        }
    }

    /**
     * Returns the height of the binary tree defined as 1 for a tree with one element in it.
     * @return The height of the tree
     */
    public int height() {
        return height(this);
    }

    private static <E> int height(BinaryTree<E> tree) {
        return tree == null ? 0 : 1 + Math.max(height(tree.leftChild), height(tree.rightChild));
    }

    /**
     * Returns the size of the binary tree.
     * @return The size of the tree
     */
    public int size() {
        return size(this);
    }

    private static <E> int size(BinaryTree<E> tree) {
        return tree == null ? 0 : 1 + size(tree.leftChild) + size(tree.rightChild);
    }

    /**
     * Returns true if this tree is the left child of its parent
     * @return True if the tree is the left child of its parent
     */
    public boolean isLeftChild() {
        if (this.parent != null) {
            return this.equals(this.parent.leftChild);
        }
        return false;
    }

    /**
     * Rotates the tree to the left. The diagram on the right shows the
     * state of the tree before leftRotate() is called on "x". The diagram
     * on the right shows the state of the tree after leftRotate() has been
     * called.
            y      <---     x
         /     \         /    \
        x       c       a      y
      /  \                   /   \
    a     b                 b     c

     * @return The parent of the rotated tree
     * @throws IllegalStateException if the right child is null
     */
    public BinaryTree<E> leftRotate() {
        if (this.rightChild == null) {
            throw new IllegalStateException();
        }
        BinaryTree<E> temp = this.rightChild;
        this.rightChild = temp.leftChild;
        temp.leftChild = this;
        return this.parent;
    }
}
