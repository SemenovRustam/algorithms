package com.semenov.yandex.practicum.sprint2


fun main() {
    val commandCount = readln().toInt()
    val deque = Deque(readln().toInt())

    repeat(commandCount) {
        val input = readln().split(" ")
        when (input[0]) {
            POP_BACK -> deque.popBack()
            POP_FRONT -> deque.popFront()
            PUSH_BACK -> deque.pushBack(input[1].toInt())
            PUSH_FRONT -> deque.pushFront(input[1].toInt())
        }
    }
}

class Deque(private val capacity: Int) {
    private val deque = Array<Int?>(capacity) { null }
    private var head = 0
    private var tail = capacity - 1
    private var size = 0

    fun pushBack(value: Int) {
        if (size == capacity) {
            printError()
        } else {
            tail = (tail + 1) % capacity
            deque[tail] = value
            size++
        }
    }

    fun pushFront(value: Int) {
        if (size == capacity) {
            printError()
        } else {
            head = (head - 1 + capacity) % capacity
            deque[head] = value
            size++
        }
    }

    fun popFront() {
        if (size == 0) {
            printError()
        } else {
            println(deque[head])
            deque[head] = null
            head = (head + 1) % capacity
            size--
        }
    }

    fun popBack() {
        if (size == 0) {
            printError()
        } else {
            println(deque[tail])
            deque[tail] = null
            tail = (tail - 1 + capacity) % capacity
            size--
        }
    }

    private fun printError() {
        println(ERROR)
    }
}

private const val ERROR = "error"
private const val POP_BACK = "pop_back"
private const val POP_FRONT = "pop_front"
private const val PUSH_BACK = "push_back"
private const val PUSH_FRONT = "push_front"


/**
 * push_back(value) – добавить элемент в конец дека. Если в деке уже находится максимальное число элементов, вывести «error».
 * push_front(value) – добавить элемент в начало дека. Если в деке уже находится максимальное число элементов, вывести «error».
 * pop_front() – вывести первый элемент дека и удалить его. Если дек был пуст, то вывести «error».
 * pop_back() – вывести последний элемент дека и удалить его. Если дек был пуст, то вывести «error».
 * Value — целое число, по модулю не превосходящее 1000.
 *
 *
 * Пример 1
 *
Ввод
4
4
push_front 861
push_front -819
pop_back
pop_back

Вывод

861
-819

Пример 2

Ввод

7
10
push_front -855
push_front 0
pop_back
pop_back
push_back 844
pop_back
push_back 823

Вывод

-855
0
844

Пример 3
Ввод

6
6
push_front -201
push_back 959
push_back 102
push_front 20
pop_front
pop_back

Вывод
20
102
 */