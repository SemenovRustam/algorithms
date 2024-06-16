package com.semenov.yandex.practicum.sprint2

// <template>
class Node1<V>(
    var value: V,
    var next: Node1<V>? = null,
)
// <template>

fun solution(head: Node1<String>?) {
    // Your code
    // ヽ(´▽`)/
    var current = head
    while (current != null) {
        println(current.value)
        current = current.next
    }
}

fun main() {
    val node13 = Node1("node3")
    val node12 = Node1("node2", node13)
    val node1 = Node1("node1", node12)
    val node10 = Node1("node0", node1)
    solution(node10)
    /*
    Output is:
    node0
    node1
    node2
    node3
    */
}

/**
B. Список дел
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Васе нужно распечатать свой список дел на сегодня. Помогите ему: напишите функцию, которая печатает все его дела. Известно, что дел у Васи не больше 5000.
Внимание: в этой задаче не нужно считывать входные данные. Нужно написать только функцию, которая принимает на вход голову списка и печатает его элементы.
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
В качестве ответа сдайте только код функции, которая печатает элементы списка. Длина списка не превосходит 5000 элементов. Список не бывает пустым.

Вы можете ознакомиться с инструкцией по работе с Make на платформе в разделе "Начало тема «Введение в алгоритмы», урок «Оптимизация ввода и вывода»
Формат вывода
Функция должна напечатать элементы списка по одному в строке.

* */