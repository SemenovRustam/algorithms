package com.semenov.yandex.practicum.sprint5

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
// <template>

fun treeSolution(head: Node?): Boolean {
    return head == null || checkSymmetry(head.left, head.right)
}

fun checkSymmetry(left: Node?, right: Node?): Boolean {
    return when {
        left == null && right == null -> true
        left == null || right == null -> false
        else -> {
            left.value == right.value && checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left)
        }
    }
}


fun main() {
    val node1 = Node(3, null, null)
    val node2 = Node(4, null, null)
    val node3 = Node(4, null, null)
    val node4 = Node(3, null, null)
    val node5 = Node(2, node1, node2)
    val node6 = Node(2, node3, node4)
    val node7 = Node(1, node5, node6)
    assert(treeSolution(node7))
    println(treeSolution(node7))
}