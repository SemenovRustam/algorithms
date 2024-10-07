package com.semenov.yandex.practicum.sprint5.final_task

class Node(var left: Node?, var right: Node?, var value: Int)

fun remove(root: Node?, key: Int): Node? {
    if (root == null) return null
    val value = root.value
    val left = root.left
    if (key < value) {
        root.left = remove(left, key)
    } else {
        val right = root.right
        if (key > value) {
            root.right = remove(right, key)
        } else {
            // Node with only one child or no child
            if (left == null) return right
            else if (right == null) return left

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(right)

            // Delete the inorder successor
            root.right = remove(right, value)
        }
    }
    return root
}

fun minValue(node: Node): Int {
    var current = node
    val left = current.left
    while (left != null) {
        current = left
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