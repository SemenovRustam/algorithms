package com.semenov.yandex.practicum.sprint5

//import kotlin.math.absoluteValue
//
//// <template>
//class Node(var value: Int) {
//    var left: Node? = null
//    var right: Node? = null
//}
//// <template>
//
//
//fun treeSolution(head: Node?): Boolean {
//    if (head == null) return true
//
//    val right = height(head.right)
//    val left = height(head.left)
//
//    if ((left - right).absoluteValue > 1) return false
//
//    return treeSolution(head.left) && treeSolution(head.right)
//}
//
//fun height(node: Node?): Int {
//    if (node == null) return 0
//    return 1 + height(node.left).coerceAtLeast(height(node.right))
//}
//
//fun main() {
//    val node1 = Node(1)
//    val node2 = Node(-5)
//    val node3 = Node(3)
//    node3?.left = node1
//    node3?.right = node2
//    val node4 = Node(10)
//    val node5 = Node(2)
//    node5?.left = node3
//    node5?.right = node4
//    assert(treeSolution(node5))
//}