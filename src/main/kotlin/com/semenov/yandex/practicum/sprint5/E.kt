package com.semenov.yandex.practicum.sprint5

import kotlin.math.min

// <template>
class Node {
    var value: Int
    var left: Node?
    var right: Node?

    constructor(value: Int) {
        this.value = value
        right = null
        left = null
    }

    constructor(value: Int, left: Node?, right: Node?) {
        this.value = value
        this.left = left
        this.right = right
    }
}

fun treeSolution(head: Node?): Boolean {
    if (head == null) {
        return true
    }
    fun isValid(node: Node?, minValue: Int, maxValue: Int): Boolean {
        if (node == null) return true
        val value = node.value
        if (value < minValue || value > maxValue) return false
        return isValid(node.left, minValue, value) && isValid(node.right, value, maxValue)
    }
    return isValid(head, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun main() {
    val node1 = Node(1, null, null)
    val node2 = Node(4, null, null)
    val node3 = Node(3, node1, node2)
    val node4 = Node(8, null, null)
    val node5 = Node(5, node3, node4)
    assert(treeSolution(node5))
    node2.value = 5
    assert(!treeSolution(node5))
    println(!treeSolution(node5))
}
