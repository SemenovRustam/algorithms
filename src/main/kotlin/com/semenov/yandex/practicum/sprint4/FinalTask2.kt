package com.semenov.yandex.practicum.sprint4

import java.util.LinkedList
import kotlin.math.absoluteValue


/**
https://contest.yandex.ru/contest/24414/run-report/118106373/

 Принцип работы:
 Реализован класс HashTable, в котором имеется поле buckets - это Массив Списков с нодами.
 Реализованы функции:

 hash(key: Int) — эта функция вычисляет индекс бакета (bucket) для заданного ключа.
 Она использует операцию взятия остатка от деления ключа на емкость (capacity) хеш-таблицы и
 возвращает абсолютное значение результата.

 findNode(key: Int): Node? — эта функция находит узел (Node) с заданным ключом в соответствующем бакете.
 Она использует индекс, вычисленный хеш-функцией, для получения списка узлов в бакете.
 Затем она ищет узел с заданным ключом в списке, используя метод find. Если узел найден, функция возвращает его;
 в противном случае, она возвращает null.

 get(key: Int): Int? — эта функция возвращает значение, связанное с заданным ключом, или null, если ключ не
 найден в хеш-таблице. Она вызывает findNode для поиска узла с заданным ключом и возвращает значение этого узла,
 если он найден; в противном случае, она возвращает null.

 put(key: Int, value: Int) - вычисляет хеш ключа, по ключу достает ноду из бакета, если нода существует
 - перезаписывает значение, если ноды нет - добавляет новую ноду

 delete(key: Int): Int? - по ключу ищет бакет, в нем перебирает ноды, в которых ключ совпадает с ключом ноды, удаляет, если
                            такой имеется, если нет - возвращает null

 main - считывает кол-во команд, реализуется класс HashTable с размером кол-ва команд
 В цикле считывается строка, которая парсит команды и вызывает соответствующие методы.

 Временная сложность:
 Метод hash(key: Int):  O(1)

 Метод findNode(key: Int): В лучшем случае - O(1), в худшем O(n), где  n — количество элементов в корзине,
амортизированная - при использование хеш-таблицы O(1).

 Метод get(key: Int): В лучшем случае - O(1), в худшем O(n), где  n — количество элементов в корзине,
амортизированная - при использование хеш-таблицы O(1).

 Метод put(key: Int, value: Int): В лучшем случае - O(1), в худшем O(n), где  n — количество элементов в корзине,
амортизированная - при использование хеш-таблицы O(1).

 Метод delete(key: Int) - В лучшем случае - O(1), в худшем O(n), где  n — количество элементов в корзине,
амортизированная - при использование хеш-таблицы O(1).

 Пространственная сложность:
 O(n+c) n — общее количество элементов в хеш-таблице. c — количество корзин, равное значению capacity.

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
    private val buckets = Array(capacity) { LinkedList<Node>() }

    private fun hash(key: Int) = (key % capacity).absoluteValue

    private fun findNode(key: Int): Node? {
        val index = hash(key)
        return buckets[index].find { it.key == key }
    }

    fun get(key: Int): Int? {
        return findNode(key)?.value
    }

    fun put(key: Int, value: Int) {
        val hash = hash(key)
        val nodes = buckets[hash]
        findNode(key)?.also {
            it.value = value
        } ?: nodes.add(Node(key, value))
    }

    fun delete(key: Int): Int? {
        val index = hash(key)
        val nodes = buckets[index]
        val iterator = nodes.iterator()

        while (iterator.hasNext()) {
            val node = iterator.next()
            if (node.key == key) {
                iterator.remove()
                return node.value
            }
        }
        return null
    }
}

private class Node(val key: Int, var value: Int)