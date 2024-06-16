package com.semenov.yandex.practicum.sprint2


fun solution(head: Node<String>?, pos: Int): Node<String>? {
    if (pos == 0) {
        return head?.next
    }

    var index = 0
    var current = head

    while (current != null) {
        if (index + 1 == pos) {
            current.next = current.next?.next
            break
        }
        current = current.next
        index++
    }
    return head
}


fun main() {
    val node3 = Node("node3", null)
    val node2 = Node("node2", node3)
    val node1 = Node("node1", node2)
    val node0 = Node("node0", node1)
    val newHead = solution(node0, 1)
    assert(newHead === node0)
    assert(newHead?.next === node2)
    assert(newHead?.next?.next === node3)
    assert(newHead?.next?.next?.next == null)
    // result is : node0 -> node2 -> node3
}

/**
 * C. Нелюбимое дело
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Вася размышляет, что ему можно не делать из того списка дел, который он составил.
Но, кажется, все пункты очень важные!
Вася решает загадать число и удалить дело, которое идёт под этим номером.
Список дел представлен в виде односвязного списка. Напишите функцию solution,
которая принимает на вход голову списка и номер удаляемого дела и возвращает голову обновлённого списка.
Внимание: в этой задаче не нужно считывать входные данные.
Нужно написать только функцию, которая принимает на вход голову списка и номер
удаляемого элемента и возвращает голову обновлённого списка.
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
Функция принимает голову списка и индекс элемента, который надо удалить (нумерация с нуля). Список содержит не более 5000
элементов. Список не бывает пустым.

Вы можете ознакомиться с инструкцией по работе с Make на платформе в разделе "Начало тема «Введение в алгоритмы»,
урок «Оптимизация ввода и вывода»
Формат вывода
Верните голову списка, в котором удален нужный элемент.
 */