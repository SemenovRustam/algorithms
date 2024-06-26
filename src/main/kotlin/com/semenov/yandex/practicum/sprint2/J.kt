package com.semenov.yandex.practicum.sprint2

import java.util.LinkedList

class ListQueue {
    private val queue = LinkedList<Int?>()
    private var size = 0
    private var head = 0
    private var tail = 0

    fun size() {
        println(size)
    }

    fun put(x: Int) {
        queue.add(tail, x)
        tail++
        size++
    }

    fun get() {
        if (size == 0) {
            println("error")
        } else {
            val x = queue[head]
            queue[head] = null
            size--
            head++
            println(x)
        }
    }
}

fun main() {
    val queue = ListQueue()
    val count = readln().toInt()

    for (index in 0 until count) {
        when (val input = readln()) {
            "get" -> queue.get()
            "size" -> queue.size()
            else -> {
                val x = input.replace("put ", "").toInt()
                queue.put(x)
            }
        }
    }
}
/**
J. Списочная очередь
Ограничение времени	0.3 секунды
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Любимый вариант очереди Тимофея — очередь, написанная с использованием связного списка.
Помогите ему с реализацией. Очередь должна поддерживать выполнение трёх команд:

get() — вывести элемент, находящийся в голове очереди, и удалить его. Если очередь пуста, то вывести «error».
put(x) — добавить число x в очередь
size() — вывести текущий размер очереди
Формат ввода
В первой строке записано количество команд n — целое число, не превосходящее 1000.
В каждой из следующих n строк записаны команды по одной строке.

Формат вывода
Выведите ответ на каждый запрос по одному в строке.


Пример 1
Ввод

10
put -34
put -23
get
size
get
size
get
get
put 80
size

Вывод
-34
1
-23
0
error
error
1

Пример 2

Ввод
6
put -66
put 98
size
size
get
get

Вывод

2
2
-66
98

Пример 3

Ввод

9
get
size
put 74
get
size
put 90
size
size
size

Вывод

error
0
74
0
1
1
1

 * */