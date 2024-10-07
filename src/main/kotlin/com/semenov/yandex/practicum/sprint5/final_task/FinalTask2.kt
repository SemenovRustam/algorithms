package com.semenov.yandex.practicum.sprint5.final_task

class Node(var left: Node?, var right: Node?, var value: Int)

fun remove(root: Node?, key: Int): Node? {
    if (root == null) return null

    if (key < root.value) {
        root.left = remove(root.left, key)
    } else if (key > root.value) {
        root.right = remove(root.right, key)
    } else {
        if (root.left == null) return root.right
        else if (root.right == null) return root.left

        root.value = minValue(root.right!!)
        root.right = remove(root.right, root.value)
    }
    return root
}

fun minValue(node: Node): Int {
    var current = node
    while (current.left != null) {
        current = current.left!!
    }
    return current.value
}

fun main() {
    val node1 = Node(null, null, 2)
    val node2 = Node(node1, null, 3)
    val node3 = Node(null, node2, 1)
    val node4 = Node(null, null, 6)
    val node5 = Node(node4, null, 8)
    val node6 = Node(node5, null, 10)
    val node7 = Node(node3, node6, 5)
    val newHead = remove(node7, 10)
    println(newHead!!.value == 5)
    println(newHead?.right == node5)
    println(newHead?.right!!.value == 8)
}