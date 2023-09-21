package com.swd.data.structures.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private BinarySearchTree myBST = new BinarySearchTree();

    @Before
    public void tearUp(){

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);
    }

    @After
    public void tearDown(){
        myBST = null;
    }

    @Test
    public void contains_should_be_true(){
        assertTrue(myBST.contains(27));
    }

    @Test
    public void contains_should_be_false(){
        assertFalse(myBST.contains(17));
    }

    @Test
    public void contains_recursive_should_be_true(){
        assertTrue(myBST.containsRecursive(27));
    }

    @Test
    public void contains_recursive_should_be_false(){
        assertFalse(myBST.containsRecursive(17));
    }

}
