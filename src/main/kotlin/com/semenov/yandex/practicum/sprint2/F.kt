package com.semenov.yandex.practicum.sprint2

class StackMax {
    private var items = mutableListOf<Int>()

    fun push(element: Int) {
        items.add(element)
    }

    fun pop() {
        if (items.isEmpty()) {
            println("error")
        } else {
            items.removeLast()
        }
    }

    fun getMax() {
        if (items.isEmpty()) {
            println("None")
        } else {
            println("${items.max()}")
        }
    }
}

fun main() {
    val count = readln().toInt()
    val stackMax = StackMax()
    for (index in 0 until count) {
        when (val value = readln()) {
            "get_max" -> stackMax.getMax()
            "pop" -> stackMax.pop()
            else -> {
                val int = value.replace("push ", "").toInt()
                stackMax.push(int)
            }
        }
    }
}

/**
 * F. Стек - Max
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Нужно реализовать класс StackMax, который поддерживает операцию определения максимума среди всех элементов в стеке.
Класс должен поддерживать операции push(x), где x – целое число, pop() и get_max().

Формат ввода
В первой строке записано одно число n — количество команд, которое не превосходит 10000.
В следующих n строках идут команды. Команды могут быть следующих видов:

push(x) — добавить число x в стек. Число x не превышает 105;
pop() — удалить число с вершины стека;
get_max() — напечатать максимальное число в стеке;
Если стек пуст, при вызове команды get_max() нужно напечатать «None», для команды pop() — «error».

Формат вывода
Для каждой команды get_max() напечатайте результат её выполнения.
Если стек пустой, для команды get_max() напечатайте «None».
Если происходит удаление из пустого стека — напечатайте «error».
Пример 1

Ввод

8
get_max
push 7
pop
push -2
push -1
pop
get_max
get_max

Вывод
None
-2
-2

Пример 2
Ввод

7
get_max
pop
pop
pop
push 10
get_max
push -9

Вывод
None
error
error
error
10

 */