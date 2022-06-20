package com.hegde.playground

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue

internal class TreeExcerciseTest {

    data class TestTreeNode(override var `val`: Int, override var left: TreeNode?, override var right: TreeNode?): TreeNode(`val`)

    fun buildTree(levelOrder: List<List<Int>>) {
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
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)
        assertTrue(isValidBST(root))
    }
}