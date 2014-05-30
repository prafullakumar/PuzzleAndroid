package com.diegodagum.commons;

import java.util.ArrayList;

/**
 * Basic implementation of a binary tree (not a binary search tree). It's
 * immutable.
 */
public class BinaryTree<T> {

    protected T mData;

    protected BinaryTree<T> mLeft;
    protected BinaryTree<T> mRight;

    public BinaryTree(T data) {
        this(data, null, null);
    }

    public BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
        mData = data;
        mLeft = left;
        mRight = right;
    }

    public T getData() {
        return mData;
    }

    public BinaryTree<T> getLeft() {
        return mLeft;
    }

    public BinaryTree<T> getRight() {
        return mRight;
    }

}
