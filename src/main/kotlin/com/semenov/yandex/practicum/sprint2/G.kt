package com.semenov.yandex.practicum.sprint2

class StackMaxEffective {
    private var items = mutableListOf<Int>()
    private var listOfMax = mutableListOf<Int>()

    fun push(element: Int) {
        items.add(element)

        if (listOfMax.isEmpty()) {
            listOfMax.add(element)
        } else {
            if (listOfMax[listOfMax.lastIndex] <= element) {
                listOfMax.add(element)
            }
        }
    }

    fun pop() {
        if (items.isEmpty()) {
            println("error")
        } else {
            val element = items.removeAt(items.lastIndex)

            if (listOfMax.isNotEmpty() && listOfMax[listOfMax.lastIndex] == element) {
                listOfMax.removeLast()
            }
        }
    }

    fun getMax() {
        if (items.isEmpty()) {
            println("None")
        } else {
            println(listOfMax.last())
        }
    }

    fun getTop() {
        if (items.isEmpty()) {
            println("error")
        } else {
            println("${items[items.lastIndex]}")
        }
    }
}

fun main() {
    val count = readln().toInt()
    val stackMaxEffective = StackMaxEffective()
    for (index in 0 until count) {
        when (val value = readln()) {
            "get_max" -> stackMaxEffective.getMax()
            "pop" -> stackMaxEffective.pop()
            "top" -> stackMaxEffective.getTop()
            else -> {
                val int = value.replace("push ", "").toInt()
                stackMaxEffective.push(int)
            }
        }
    }
}

/**
 * G. Стек - MaxEffective
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.2 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	1.5 секунд	64Mb
Python 3.7.3	1.5 секунд	64Mb
Swift 5.9.2	2 секунды	64Mb
OpenJDK Java 11	1.5 секунд	64Mb
C# (MS .NET 6.0 + ASP)	1.5 секунд	64Mb
Python 3.12.1	1.5 секунд	64Mb
Golang 1.21.0	0.5 секунд	64Mb
Java 21 (Temurin JDK)	1.5 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	1.5 секунд	64Mb
C# (MS .NET 5.0 + ASP)	1.5 секунд	64Mb
Реализуйте класс StackMaxEffective, поддерживающий операцию определения максимума среди элементов в стеке.
Сложность операции должна быть O(1). Для пустого стека операция должна возвращать None.
При этом push(x) и pop() также должны выполняться за константное время.

Формат ввода
В первой строке записано одно число — количество команд, оно не превосходит 100000.
Далее идут команды по одной в строке. Команды могут быть следующих видов:

push(x) — добавить число x в стек. Число x не превышает 105;
pop() — удалить число с вершины стека;
get_max() — напечатать максимальное число в стеке;
top() — напечатать число с вершины стека;
Если стек пуст, при вызове команды get_max нужно напечатать «None», для команды pop и top — «error».
Формат вывода
Для каждой команды get_max() напечатайте результат её выполнения.
Если стек пустой, для команды get_max() напечатайте «None».
Если происходит удаление из пустого стека — напечатайте «error».


 * Пример 1
Ввод

13
pop
pop
top
push 4
push -5
top
push 7
pop
pop
get_max
top
pop
get_max

Вывод
error
error
error
-5
4
4
None
Пример 2

Ввод

10
get_max
push -6
pop
pop
get_max
push 2
get_max
pop
push -2
push -6

Вывод
None
error
None
2
 */