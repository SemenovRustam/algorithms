//package com.semenov.yandex.practicum.sprint5
//
//// <template>
//class Node {
//    var value: Int
//    var left: Node?
//    var right: Node?
//
//    constructor(value: Int) {
//        this.value = value
//        right = null
//        left = null
//    }
//
//    constructor(value: Int, left: Node?, right: Node?) {
//        this.value = value
//        this.right = right
//        this.left = left
//    }
//}
//// <template>
//
//fun treeSolution(head: Node?): Int {
//    if (head == null) return 0
//
//    return 1 + maxOf(treeSolution(head.left), treeSolution(head.right))
//}
//
//fun main() {
//    val node1 = Node(1, null, null)
//    val node2 = Node(4, null, null)
//    val node3 = Node(3, node1, node2)
//    val node4 = Node(8, null, null)
//    val node5 = Node(5, node3, node4)
//    assert(treeSolution(node5) == 3)
//    println(treeSolution(node5) == 3)
//}