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


fun treeSolution(head1: Node?, head2: Node?): Boolean {
    if (head1 == null && head2 == null) return true

    if (head1?.value != head2?.value) return false

    return treeSolution(head1?.left, head2?.left) && treeSolution(head1?.right, head2?.right)
}


fun main() {
    val node1 = Node(1, null, null)
    val node2 = Node(2, null, null)
    val node3 = Node(3, node1, node2)
    val node4 = Node(1, null, null)
    val node5 = Node(2, null, null)
    val node6 = Node(3, node4, node5)
    assert(treeSolution(node3, node6))
}