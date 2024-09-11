package com.semenov.yandex.practicum.sprint4

fun main() {
    val n = readln().toInt()
    val hashTable = HashTable()
    val none = "NONE"

    repeat(n) {
        val inputData = readln().split(" ")
        val (method, key) = inputData
        when (method) {
            "put" -> {
                hashTable.put(key.toInt(), inputData[2].toInt())
            }

            "get" -> {
                hashTable.get(key.toInt())
                    ?.also { println(it) }
                    ?: println(none)
            }

            "delete" -> {
                hashTable.delete(key.toInt())
                    ?.also { println(it) }
                    ?: println(none)
            }
        }
    }
}

class HashTable(var capacity: Int = 10) {
    private val buckets = Array<MutableList<Node>>(capacity) { mutableListOf() }
    private var size = 0

    private fun hash(key: Int) = key % capacity

    private fun findNode(key: Int): Node? {
        val index = hash(key)
        val nodes = buckets[index]

        for (node in nodes) {
            if (node.key == key) {
                return node
            }
        }
        return null
    }

    fun get(key: Int) = findNode(key)?.value

    fun put(key: Int, value: Int) {
        val index = hash(key)
        val nodes = buckets[index]

        val existingNode = findNode(key)
        if (existingNode != null) {
            existingNode.value = value
        } else {
            val newNode = Node(key, value)
            newNode.next = nodes.firstOrNull()
            nodes.add(0, newNode)
            size++
        }
    }

    fun delete(key: Int): Int? {
        val index = hash(key)
        val nodes = buckets[index]
        var prev: Node? = null
        var current: Node? = nodes.firstOrNull()

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    nodes.firstOrNull()?.next = current.next
                } else {
                    prev.next = current.next
                }
                size--
                return current.value
            }
            prev = current
            current = current.next
        }

        return null
    }
}

private class Node(var key: Int, var value: Int) {
    var next: Node? = null
}