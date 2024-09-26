package com.semenov.yandex.practicum.sprint5

// <template>
class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}
// <template>

fun treeSolution(head: Node?): Int {
    if (head == null) {
        return Int.MIN_VALUE
    }

    val leftMax = treeSolution(head.left)
    val rightMax = treeSolution(head.right)

    return maxOf(head.value, leftMax, rightMax)
}

fun main() {
    val node1 = Node(1)
    val node2 = Node(-5)
    val node3 = Node(3)
    node3?.left = node1
    node3?.right = node2
    val node4 = Node(2)
    node4?.left = node3
    assert(treeSolution(node4) == 3)
}