package com.semenov.yandex.practicum.sprint4


/**
 https://contest.yandex.ru/contest/24414/run-report/117767125/

 Принцип работы:
 Реализован класс HashTable, в котором имеется поле buckets - это Массив Списков с нодами.
 Реализованы функции:
 hash - которая высчитывает индекс элемента по ключу

 findNode - по ключу высчитывает хеш, по которому в массиве buckets ищется нода

  */


fun main() {
    val n = readln().toInt()
    val hashTable = HashTable(n)
    val none = "None"

    repeat(n) {
        val inputData = readln().split(" ")
        val (method, key) = inputData
        when (method) {
            "put" -> {
                hashTable.put(key.toInt(), inputData[2].toInt())
            }
            "get" -> {
                println(hashTable.get(key.toInt()) ?: none)
            }
            "delete" -> {
                println(hashTable.delete(key.toInt()) ?: none)
            }
        }
    }
}

class HashTable(private val capacity: Int) {
    private val buckets = Array<MutableList<Node?>>(capacity) { mutableListOf() }

    private fun hash(key: Int): Int {
        val hashValue = key % capacity
        return if (hashValue < 0) hashValue + capacity else hashValue
    }

    private fun findNode(key: Int): Node? {
        val index = hash(key)
        return buckets[index].find { it?.key == key }
    }

    fun get(key: Int): Int? {
        return findNode(key)?.value
    }

    fun put(key: Int, value: Int) {
        val index = hash(key)
        val nodes = buckets[index]
        val existingNode = findNode(key)

        if (existingNode != null) {
            existingNode.value = value
        } else {
            nodes.add(Node(key, value))
        }
    }

    fun delete(key: Int): Int? {
        val index = hash(key)
        val nodes = buckets[index]
        val iterator = nodes.iterator()

        while (iterator.hasNext()) {
            val node = iterator.next()
            if (node?.key == key) {
                iterator.remove()
                return node.value
            }
        }
        return null
    }
}

private class Node(val key: Int, var value: Int)