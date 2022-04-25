package com.hegde.playground

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
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


