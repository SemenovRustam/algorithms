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
//        this.left = left
//        this.right = right
//    }
//}
//
//fun treeSolution(head: Node?): Int {
//    var maxSum = Int.MIN_VALUE
//
//    fun maxGain(node: Node?): Int {
//        if (node == null) return 0
//
//        val left = maxGain(node.left)
//        val right = maxGain(node.right)
//
//        // Вычисляем максимальную сумму, если мы начинаем путь в текущем узле
//        val startFromCurrent = node.value + maxOf(0, left) + maxOf(0, right)
//        maxSum = maxOf(maxSum, startFromCurrent)
//
//        // Вычисляем максимальную сумму, если мы продолжаем путь в текущем узле
//        val continueFromCurrent = node.value + maxOf(left, right)
//        return maxOf(continueFromCurrent, 0)
//    }
//
//    maxGain(head)
//    return maxSum
//}
//
//fun main() {
//    val node1 = Node(5, null, null)
//    val node2 = Node(1, null, null)
//    val node3 = Node(-3, node2, node1)
//    val node4 = Node(2, null, null)
//    val node5 = Node(2, node4, node3)
//    assert(treeSolution(node5) == 6)
//    println(treeSolution(node5) == 6)
//}
