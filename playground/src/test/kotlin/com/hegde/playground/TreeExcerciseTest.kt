package com.hegde.playground

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue

internal class TreeExcerciseTest {

    data class TestTreeNode(override var `val`: Int, override var left: TreeNode?, override var right: TreeNode?): TreeNode(`val`)

    fun buildTree(levelOrder: List<Int>) {
        val queue: Queue<Int> = LinkedList(listOf());
        levelOrder.forEach {}
    }




    @Test
    fun isValidBST_WhenRootNodeHasNoSibling_ShouldReturnFalse() {
        assertFalse(isValidBST(TreeNode(1)))
    }

    @Test
    fun isValidBST_WhenRootNodeHasSiblingValidOrder_ShouldReturnTrue() {
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)
        assertTrue(isValidBST(root))
    }

    @Test
    fun isValidBST_WhenRootNodeHasSiblingInValidOrder_ShouldReturnFalse() {
        val root = TreeNode(2)
        root.left = TreeNode(3)
        root.right = TreeNode(1)
        assertFalse(isValidBST(root))
    }

    @Test
    fun isValidBST_WhenRootNodeHasSiblingValidOrderAndHeight3_ShouldReturnTrue() {

//        val rootNode = TreeNode(5);
//        rootNode.left = TreeNode(4)
//        rootNode.right = TreeNode(6)
//
//        rootNode.left?.left = null
//        rootNode.left?.right = null
//
//        rootNode.right?.left = TreeNode(3)
//        rootNode.right?.right = TreeNode(7)
//
//        assertFalse(isValidBST(rootNode))

        val rootNode2 = TreeNode(3);
        rootNode2.left = TreeNode(1)
        rootNode2.right = TreeNode(5)

        rootNode2.left?.left = TreeNode(0)
        rootNode2.left?.right = TreeNode(2)

        rootNode2.right?.left = TreeNode(4)
        rootNode2.right?.right = TreeNode(6)

        assertTrue(isValidBST(rootNode2))
    }


    private fun buildTree(): TreeNode {
        val rootNode = TreeNode(10);
        rootNode.left = TreeNode(9)
        rootNode.right = TreeNode(8)

        rootNode.left?.left = TreeNode(7)
        rootNode.left?.right = TreeNode(6)

        rootNode.right?.left = TreeNode(5)
        rootNode.right?.right = TreeNode(4)

        rootNode.left?.left?.left = TreeNode(1)

//                        10
//                        /\
//                       9  8
//                      /\  /\
//                     7 6  5 4
//                    /
//                   1
        return rootNode
    }

    @Test
    fun testNewTra() {
        println(preOrderTra(buildTree(), mutableListOf()).toString())
    }

    @Test
    fun testNewTra_() {
        println(preOrderTraWithStack(buildTree()).toString())
    }

    @Test
    fun testNewTra_withStack() {
        println(inOrderTraWithStack(buildTree()).toString())
    }

    @Test
    fun test_treeIncludes() {
        assertFalse(treeIncludesBreadthFirst(buildTree(), 0))
        assertTrue(treeIncludesBreadthFirst(buildTree(), 5))

        assertFalse(treeIncludesDepthFirst(buildTree(), 0))
        assertTrue(treeIncludesDepthFirst(buildTree(), 5))
    }
}