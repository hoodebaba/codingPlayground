package com.hegde.playground


class CustomStack {
    var size: Int = 0
    var headNode: Node<Int>? = null

    data class Node<T>(var next: Node<T>?, var prev: Node<T>?, val value: T, val currentMin: T)

    fun push(value: Int) {
        if (size == 0) {
            val currentMin = value
            headNode = Node(null, null, value, currentMin)
            size++
        } else {
            val currentMin = headNode?.currentMin?.let {
                if (it > value) value else it
            } ?: value
            val tempNode = headNode
            headNode = Node(tempNode, null, value, currentMin)
            size++
        }
    }

    fun pop(): Int? {
        if (size == 0)
            return null
        val tempNode = headNode;
        headNode = headNode?.next;
        size--;
        return tempNode?.value
    }

    fun peek(): Int? {
        if (size == 0) return null
        return headNode?.value
    }

    fun getMin(): Int? {
        if (size == 0) return null
        return headNode?.currentMin
    }
}

