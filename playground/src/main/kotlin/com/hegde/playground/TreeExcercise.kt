package com.hegde.playground

import java.util.*

open class TreeNode(open var `val`: Int) {
    open var left: TreeNode? = null
    open var right: TreeNode? = null
}

fun preorderTraversal(root: TreeNode?): List<Int?> {
    val nodeValues: MutableList<Int?> = mutableListOf()
    return root?.let { preOrderTravelNodes(root, nodeValues) } ?: mutableListOf()
}

fun preOrderTravelNodes(root: TreeNode, nodeValues: MutableList<Int?>): List<Int?> {
    nodeValues.add(root.`val`)

    root.left?.let {
        preOrderTravelNodes(it, nodeValues)
    }

    root.right?.let {
        preOrderTravelNodes(it, nodeValues)
    }
    return nodeValues
}

fun inOrderTraversal(root: TreeNode?): List<Int?> {
    val nodeValues: MutableList<Int?> = mutableListOf()
    return root?.let { inOrderTravelNodes(root, nodeValues) } ?: mutableListOf()
}

fun inOrderTravelNodes(root: TreeNode, nodeValues: MutableList<Int?>): List<Int?> {

    root.left?.let {
        inOrderTravelNodes(it, nodeValues)
    }
    nodeValues.add(root.`val`)
    root.right?.let {
        inOrderTravelNodes(it, nodeValues)
    }
    return nodeValues
}

fun postOrderTraversal(root: TreeNode?): List<Int?> {
    val nodeValues: MutableList<Int?> = mutableListOf()
    return root?.let { postOrderTravelNodes(root, nodeValues) } ?: mutableListOf()
}

fun postOrderTravelNodes(root: TreeNode, nodeValues: MutableList<Int?>): List<Int?> {

    root.left?.let {
        postOrderTravelNodes(it, nodeValues)
    }

    root.right?.let {
        postOrderTravelNodes(it, nodeValues)
    }
    nodeValues.add(root.`val`)
    return nodeValues
}


fun levelOrder(root: TreeNode?): List<List<Int>> {
    return root?.let { preOrderBFS(root, 0, mutableListOf())} ?: mutableListOf()
}

fun preOrderBFS(root: TreeNode, lvl: Int, nodeValues: MutableList<MutableList<Int>>): List<List<Int>> {
    if (lvl < nodeValues.size) {
        nodeValues.get(lvl).add(root.`val`)
    } else {
        nodeValues.add(lvl, mutableListOf(root.`val`))
    }

    root.left?.let {
        preOrderBFS(it, lvl + 1, nodeValues)
    }

    root.right?.let {
        preOrderBFS(it, lvl + 1, nodeValues)
    }

    return nodeValues
}


//fun isValidBST(root: TreeNode?): Boolean {
//    if (null == root)
//        return false
//
//    if (null == root.left && null == root.right)
//        return true
//
//    return root.left?.let { isValidBST(it) } ?: true
//            && root.right?.let { isValidBST(it) } ?: true
//                    && ((root.left?.`val` ?: Int.MIN_VALUE) < root.`val` && root.`val` < (root.right?.`val` ?: Int.MAX_VALUE))
//}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, null, 0)
}

fun isValidBST(root: TreeNode?, parentValue: Int?, level: Int): Boolean {
    if (null == root)
        return false

    val currentNodeValue = parentValue?.let {
        ((root.left?.`val` ?: Int.MIN_VALUE) < root.`val`
                && (root.left?.`val` ?: Int.MIN_VALUE) > it
                && root.`val` < (root.right?.`val` ?: Int.MAX_VALUE))
    } ?: ((root.left?.`val` ?: Int.MIN_VALUE) < root.`val`
            && root.`val` < (root.right?.`val` ?: Int.MAX_VALUE))

    val currentVal = if (level > 0) root.`val` else null

    println("Processing Node: ${root.`val`} with parentvalue -> $parentValue and level $level and currentValue $currentVal returning   --->  $currentNodeValue" )
    return currentNodeValue
            && root.left?.let { isValidBST(it, currentVal, level + 1) } ?: true
            && root.right?.let { isValidBST(it, currentVal, level + 1) } ?: true
}

fun preOrderTra(rootNode: TreeNode, li: MutableList<Int>): List<Int> {
    li.add(rootNode.`val`)
    if (rootNode.left != null)
        preOrderTra(rootNode.left!!, li)
    if (rootNode.right != null)
        preOrderTra(rootNode.right!!, li)
    return li
}

fun preOrderTraWithStack(rootNode: TreeNode): List<Int> {
    val linkedListStack = LinkedList<TreeNode>()
    val result: MutableList<Int> = mutableListOf()
    linkedListStack.push(rootNode)

    while (!linkedListStack.isEmpty()) {
        val treeNode = linkedListStack.pop()
        result.add(treeNode.`val`)
        if (treeNode.right != null)
            linkedListStack.push(treeNode.right)
        if (treeNode.left != null)
            linkedListStack.push(treeNode.left)
    }

    return result
}



fun inOrderTraWithStack(rootNode: TreeNode): List<Int> {
    val linkedListQueue = LinkedList<TreeNode>()
    val result: MutableList<Int> = mutableListOf()
    linkedListQueue.push(rootNode)
    var node = rootNode
    while (!linkedListQueue.isEmpty()) {
        val treeNode = linkedListQueue.pop()
        if (treeNode.right != null)
            linkedListQueue.push(treeNode.right)
        if (treeNode.left != null)
            linkedListQueue.push(treeNode.left)
    }

    return result
}

fun treeIncludesBreadthFirst(root: TreeNode, value: Int): Boolean {

    val linkedQueue = LinkedList<TreeNode>()
    linkedQueue.offer(root)
    val values = mutableListOf<Int>()

    while (!linkedQueue.isEmpty()) {
        println(values)
        val currentNode = linkedQueue.poll()
        values.add(currentNode.`val`)
        currentNode?.left?.let {
            if (it.`val` == value)
                return true
            linkedQueue.offer(it)
        }
        currentNode?.right?.let {
            if (it.`val` == value)
                return true
            linkedQueue.offer(it)
        }
    }

    return false
}

fun treeIncludesDepthFirst(root: TreeNode, value: Int): Boolean {
    println("----------------------")
    val linkedQueue = LinkedList<TreeNode>()
    linkedQueue.push(root)
    val values = mutableListOf<Int>()
    while (!linkedQueue.isEmpty()) {
        println(values)
        val currentNode = linkedQueue.pop()
        values.add(currentNode.`val`)

        currentNode?.right?.let {
            if (it.`val` == value)
                return true
            linkedQueue.push(it)
        }

        currentNode?.left?.let {
            if (it.`val` == value)
                return true
            linkedQueue.push(it)
        }
    }

    return false
}