/*
 * Course: CSC1120
 * Fall 2023
 * Homework 14 - Tree rotations
 * Name: Dr. Taylor
 * Created: 9/25/2023
 */

import org.junit.jupiter.api.Assertions;
import username.BinaryTree;

class BinaryTreeTest {

    private BinaryTree<String> treeA;
    private BinaryTree<String> treeB;
    private BinaryTree<String> treeC;
    private BinaryTree<String> treeX;
    private BinaryTree<String> treeY;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        treeB = new BinaryTree<>("b");
        treeC = new BinaryTree<>("c");
        treeY = new BinaryTree<>("y", treeB, treeC);
        treeA = new BinaryTree<>("a");
        treeX = new BinaryTree<>("x", treeA, treeY);
    }

    @org.junit.jupiter.api.Test
    void height() {
        Assertions.assertEquals(1, treeA.height());
        Assertions.assertEquals(2, treeY.height());
        Assertions.assertEquals(3, treeX.height());
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assertions.assertEquals(1, treeA.size());
        Assertions.assertEquals(3, treeY.size());
        Assertions.assertEquals(5, treeX.size());
    }

    @org.junit.jupiter.api.Test
    void isLeftChild() {
        Assertions.assertTrue(treeA.isLeftChild());
        Assertions.assertTrue(treeB.isLeftChild());
        Assertions.assertFalse(treeY.isLeftChild());
        Assertions.assertFalse(treeX.isLeftChild());
    }

    @org.junit.jupiter.api.Test
    void leftRotate() {
        BinaryTree<String> treeP = new BinaryTree<>("p", treeX, null);
        Assertions.assertEquals(treeP, treeX.leftRotate(),
                "Should return the original parent of the rotated node");
        Assertions.assertEquals(3, treeX.size());
        Assertions.assertEquals(5, treeY.size());
    }

    @org.junit.jupiter.api.Test
    void leftRotateWithNullTrees() {
        treeC = new BinaryTree<>("c");
        treeY = new BinaryTree<>("y", null, treeC);
        treeA = new BinaryTree<>("a");
        treeX = new BinaryTree<>("x", treeA, treeY);
        Assertions.assertNull(treeX.leftRotate());
        Assertions.assertEquals(2, treeX.size());
        Assertions.assertEquals(4, treeY.size());
    }
}