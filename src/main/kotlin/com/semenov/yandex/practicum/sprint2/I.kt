package com.semenov.yandex.practicum.sprint2

class MyQueueSized(val n: Int) {
    private val queue = arrayOfNulls<Int>(n)
    private var head = 0
    private var tail = 0
    private var maxSize = n
    private var size = 0


    fun push(x: Int) {
        if (size != maxSize) {
            queue[tail] = x
            tail = (tail + 1) % maxSize
            size++
        } else {
            println("error")
        }
    }

    fun pop() {
        if (size == 0) {
            println("None")
        } else {
            val x = queue[head]
            queue[head] = null
            head = (head + 1) % maxSize
            size--
            println(x)
        }
    }

    fun peek() {
        if (size == 0) {
            println("None")
        } else {
            println(queue[head])
        }
    }

    fun size() {
        println(size)
    }

}


fun main() {
    val count = readln().toInt()
    val queueSize = readln().toInt()
    val queue = MyQueueSized(queueSize)

    for (index in 0 until count) {

        when (val input = readln()) {
            "peek" -> queue.peek()
            "pop" -> queue.pop()
            "size" -> queue.size()
            else -> {
                val x = input.replace("push ", "").toInt()
                queue.push(x)
            }
        }
    }
}

/**

I. Ограниченная очередь
Ограничение времени	0.3 секунды
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Астрологи объявили день очередей ограниченного размера. Тимофею нужно написать класс MyQueueSized,
который принимает параметр max_size, означающий максимально допустимое количество элементов в очереди.

Помогите ему —– реализуйте программу, которая будет эмулировать работу такой очереди.
Функции, которые надо поддержать, описаны в формате ввода.

Формат ввода
В первой строке записано одно число — количество команд, оно не превосходит 5000.
Во второй строке задан максимально допустимый размер очереди, он не превосходит 5000.
Далее идут команды по одной на строке. Команды могут быть следующих видов:

push(x) — добавить число x в очередь;
pop() — удалить число из очереди и вывести на печать;
peek() — напечатать первое число в очереди;
size() — вернуть размер очереди;
При превышении допустимого размера очереди нужно вывести «error».
При вызове операций pop() или peek() для пустой очереди нужно вывести «None».
Формат вывода
Напечатайте результаты выполнения нужных команд, по одному на строке.



Пример 1

Ввод

8
2
peek
push 5
push 2
peek
size
size
push 1
size

Вывод

None
5
2
2
error
2

Пример 2

Ввод

10
1
push 1
size
push 3
size
push 1
pop
push 1
pop
push 3
push 3

Вывод

1
error
1
error
1
1
error

 */