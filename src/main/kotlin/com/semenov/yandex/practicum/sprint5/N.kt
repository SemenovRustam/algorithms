package com.semenov.yandex.practicum.sprint5

// <template>
class Node(var left: Node?, var right: Node?, var value: Int, var size: Int)
// <template>


fun split(root: Node?, k: Int): List<Node?> {
    return when {
        root == null -> listOf(null, null)
        k == 0 -> listOf(null, root)
        (root.left?.size ?: 0) >= k -> {
            val result = split(root.left, k)
            root.left = result[1]
            root.size = (root.left?.size ?: 0) + (root.right?.size ?: 0) + 1
            listOf(result[0], root)
        }
        else ->  {
            val result = split(root.right, k - (root.left?.size ?: 0) - 1)
            root.right = result[0]
            root.size = (root.left?.size ?: 0) + (root.right?.size ?: 0) + 1
            listOf(root, result[1])
        }
    }
}

fun main() {
    val node1 = Node(null, null, 3, 1)
    val node2 = Node(null, node1, 2, 2)
    val node3 = Node(null, null, 8, 1)
    val node4 = Node(null, null, 11, 1)
    val node5 = Node(node3, node4, 10, 3)
    val node6 = Node(node2, node5, 5, 6)
    val res: List<Node?> = split(node6, 4)
    println(res[0]!!.size == 4)
    println(res[1]!!.size == 2)
}