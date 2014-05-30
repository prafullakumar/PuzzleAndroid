package com.diegodagum.codinginterviewpuzzles.core.test;

import junit.framework.TestCase;

import com.diegodagum.codinginterviewpuzzles.core.BinaryTreeUtils;
import com.diegodagum.commons.BinaryTree;

public class BinaryTreeLowestCommonAncestorTests extends TestCase {

    private BinaryTree<Integer> mTree;

    protected void setUp() throws Exception {
        super.setUp();

        mTree = new BinaryTree<Integer>(1, new BinaryTree<Integer>(2, null,
                new BinaryTree<Integer>(4, new BinaryTree<Integer>(7), null)),
                new BinaryTree<Integer>(3, new BinaryTree<Integer>(5),
                        new BinaryTree<Integer>(6, null,
                                new BinaryTree<Integer>(8))));
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testNormalCase() {
        BinaryTree<Integer> node1 = mTree;
        BinaryTree<Integer> node4 = mTree.getLeft().getRight();
        BinaryTree<Integer> node3 = mTree.getRight();

        assertEquals(node1,
                BinaryTreeUtils.lowestCommonAncestor(mTree, node3, node4));

        BinaryTree<Integer> node7 = node4.getLeft();
        BinaryTree<Integer> node5 = node3.getLeft();
        assertEquals(node1,
                BinaryTreeUtils.lowestCommonAncestor(mTree, node7, node5));

        BinaryTree<Integer> node8 = node3.getRight().getRight();
        assertEquals(node3,
                BinaryTreeUtils.lowestCommonAncestor(mTree, node8, node5));
    }

    public void testSelf() {
        BinaryTree<Integer> node4 = mTree.getLeft().getRight();
        assertEquals(node4,
                BinaryTreeUtils.lowestCommonAncestor(mTree, node4, node4));

        BinaryTree<Integer> selfie = new BinaryTree<Integer>(15);
        assertEquals(selfie,
                BinaryTreeUtils.lowestCommonAncestor(selfie, selfie, selfie));
    }

    public void testSubtree() {
        BinaryTree<Integer> node2 = mTree.getLeft();
        BinaryTree<Integer> node7 = node2.getRight().getLeft();
        assertEquals(node2,
                BinaryTreeUtils.lowestCommonAncestor(mTree, node2, node7));
    }

    public void testOuterNode() {
        assertNull(BinaryTreeUtils.lowestCommonAncestor(mTree, mTree.getLeft(),
                new BinaryTree<Integer>(17)));
    }

    public void testNullInput() {
        assertNull(BinaryTreeUtils.lowestCommonAncestor(mTree, null, null));

        assertNull(BinaryTreeUtils.lowestCommonAncestor(mTree, null,
                mTree.getLeft()));

        assertNull(BinaryTreeUtils.lowestCommonAncestor(mTree, mTree.getLeft(),
                mTree.getLeft().getLeft())); // null
    }

}
