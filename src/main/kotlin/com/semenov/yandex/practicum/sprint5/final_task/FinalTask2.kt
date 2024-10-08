package com.semenov.yandex.practicum.sprint5.final_task

class Node(var left: Node?, var right: Node?, var value: Int)

/**
https://contest.yandex.ru/contest/24810/run-report/120043276/
Принцип работы:
функция remove(root: Node?, key: Int) - получаем на вход корень дерева и значение ключа, которое необходимо удалить
Если корень равен null, тогда возвращаем null.
Если искомый ключ меньше значения в корне деерва - тогда вызываем рукурсивно функцию remove  для левого поддерева, присваивая
для левого поддерево результат вызова.
Если искомое значение больше значения корня - тогда вызываем ф-ию  remove с правым поддеревом, присваива результат вызова
правому поддереву.
Если искомое значение равно искомому ключу - тогда проверяем:
- если левое поддерево равно нулю - возвращаем правое поддерево
- если правое поддерево равно нулю - возвращаем левое

Удаляем текущую ноду(корень дерево), для это, чтобы сохранить свойства BST заменим корень девера на наименьшее значение в правом поддереве:
- находим минимальное значение в правом поддереве и присваиваем его корню
- удаляем ноду, которой мы заменили корень

minValue(node: Node) - в корне дерева ищем самое левое значение

Временная сложность:
minValue - так как функция проходит по всему дереву, пока не найдет самое левое значение - то сложность O(h)
remove - ищем узел для удаления - O(h), если у узла два поддерева - то ищем минимальное значение в правом поддереве - O(h),
Общая: O(h) - в худшем случае, в лучшем случае O(log n).

Пространственная сложность определяется кол-вом вызова функции remove - O(h)

 * */

fun remove(root: Node?, key: Int): Node? {
    when {
        root == null -> return null
        key < root.value -> root.left = remove(root.left, key)
        key > root.value -> root.right = remove(root.right, key)
        else -> when {
            root.left == null -> return root.right
            root.right == null -> return root.left
            else -> {
                root.value = minValue(root.right!!)
                root.right = remove(root.right, root.value)
            }
        }
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