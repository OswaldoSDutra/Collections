package com.swd.data.structures;

import com.swd.data.structures.tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        bst.kthSmallest(1);

    }

}