package com.diegodagum.codinginterviewpuzzles.core;

import java.util.ArrayList;

import com.diegodagum.commons.BinaryTree;

/**
 * Popular tree-based coding puzzles.
 */
public class BinaryTreeUtils {

    /**
     * Given a tree root and two nodes in it, finds the lowest common ancestor
     * of these. <br/>
     * See <a href="http://www.careercup.com/question?id=15491794">
     * http://www.careercup.com/question?id=15491794</a>
     * 
     * @param root
     *            the tree root
     * @param node1
     *            the first node (show belong to the tree headed by root
     * @param node2
     *            the other node
     * @return null if any n1 or n2 doesn't actually belong to the tree.
     *         Otherwise, the lowest common ancestor.
     */
    @SuppressWarnings("rawtypes")
    public static BinaryTree<?> lowestCommonAncestor(BinaryTree<?> root,
            BinaryTree<?> node1, BinaryTree<?> node2) {
        // fail-fast when input is null
        if ((node1 == null) || (node2 == null))
            return null;

        ArrayList<BinaryTree> pathFromRootToNode1 = new ArrayList<BinaryTree>();
        ArrayList<BinaryTree> pathFromRootToNode2 = new ArrayList<BinaryTree>();

        findPathsFromRootToNodes(root, node1, pathFromRootToNode1, node2,
                pathFromRootToNode2);

        // if any path is empty, that node doesn't belong to the tree
        if ((pathFromRootToNode1.size() == 0)
                || (pathFromRootToNode2.size() == 0))
            return null;

        return findFartherCommonNodeFromRoot(pathFromRootToNode1,
                pathFromRootToNode2);
    }

    @SuppressWarnings("rawtypes")
    // if a non-empty path last element is the node sent as argument, cool
    private static boolean isPathFromRootToNodeComplete(
            ArrayList<BinaryTree> path, BinaryTree<?> node) {
        return ((path.size() > 0) && (path.get(path.size() - 1) == node));
    }

    @SuppressWarnings("rawtypes")
    private static void findPathsFromRootToNodes(BinaryTree<?> currentNode,
            BinaryTree<?> node1, ArrayList<BinaryTree> pathFromRootToNode1,
            BinaryTree<?> node2, ArrayList<BinaryTree> pathFromRootToNode2) {
        if (currentNode == null)
            return;

        if (!isPathFromRootToNodeComplete(pathFromRootToNode1, node1))
            pathFromRootToNode1.add(currentNode);
        if (!isPathFromRootToNodeComplete(pathFromRootToNode2, node2))
            pathFromRootToNode2.add(currentNode);

        if (isPathFromRootToNodeComplete(pathFromRootToNode1, node1)
                && isPathFromRootToNodeComplete(pathFromRootToNode2, node2))
            return;

        findPathsFromRootToNodes(currentNode.getLeft(), node1,
                pathFromRootToNode1, node2, pathFromRootToNode2);

        if (isPathFromRootToNodeComplete(pathFromRootToNode1, node1)
                && isPathFromRootToNodeComplete(pathFromRootToNode2, node2))
            return;

        findPathsFromRootToNodes(currentNode.getRight(), node1,
                pathFromRootToNode1, node2, pathFromRootToNode2);

        if (!isPathFromRootToNodeComplete(pathFromRootToNode1, node1))
            pathFromRootToNode1.remove(pathFromRootToNode1.size() - 1);
        if (!isPathFromRootToNodeComplete(pathFromRootToNode2, node2))
            pathFromRootToNode2.remove(pathFromRootToNode2.size() - 1);
    }

    @SuppressWarnings("rawtypes")
    private static BinaryTree<?> findFartherCommonNodeFromRoot(
            ArrayList<BinaryTree> pathFromRootToNode1,
            ArrayList<BinaryTree> pathFromRootToNode2) {
        int i;
        boolean areDifferent = false;
        for (i = 0; (i < Math.min(pathFromRootToNode1.size(),
                pathFromRootToNode2.size())); i++) {
            if (areDifferent = (pathFromRootToNode1.get(i) != pathFromRootToNode2
                    .get(i)))
                break;
        }

        if ((i == 0) && (areDifferent))
            return null;

        return pathFromRootToNode1.get(i - 1);
    }

}
