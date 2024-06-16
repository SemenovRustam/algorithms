package com.semenov.yandex.practicum.sprint2

//<template>
class Node<V>(var value: V) {
    var next: Node<V>? = null
    var prev: Node<V>? = null

    fun hasNext(): Boolean {
        return next != null
    }
}
//<template>


private fun solution(head: Node<String>?): Node<String>? {
    var current = head
    var prev = head?.prev

    while (current != null) {
        val tempNext = current.next

        current.next = prev
        current.prev = tempNext

        prev = current
        current = tempNext
    }

    return prev
}


fun main() {
    val node13 = Node("node3")
    val node12 = Node("node2")
    val node1 = Node("node1")
    val node10 = Node("node0")

    node10.next = node1
    node1.next = node12
    node12.next = node13

    node1.prev = node10
    node12.prev = node1
    node13.prev = node12

    val newNode = solution(node10)
    assert(newNode === node13)
    assert(node13?.next === node12)
    assert(node12?.next === node1)
    assert(node12?.prev === node13)
    assert(node1?.next === node10)
    assert(node1?.prev === node12)
    assert(node10?.prev === node1)
}

/**
E. Всё наоборот
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Вася решил запутать маму —– делать дела в обратном порядке. Список его дел теперь хранится в двусвязном списке.
Напишите функцию, которая вернёт список в обратном порядке.
Внимание: в этой задаче не нужно считывать входные данные.
Нужно написать только функцию, которая принимает на вход голову двусвязного списка
и возвращает голову перевёрнутого списка.
Используйте заготовки кода для данной задачи, расположенные по ссылкам:

c++
Java
js
Python
C#
go
Kotlin
Swift
Формат ввода
Функция принимает на вход единственный аргумент — голову двусвязного списка.
Длина списка не превосходит 1000 элементов. Список не бывает пустым.

Вы можете ознакомиться с инструкцией по работе с Make на платформе в разделе
"Начало тема «Введение в алгоритмы», урок «Оптимизация ввода и вывода»

Формат вывода
Функция должна вернуть голову развернутого списка.
 */


