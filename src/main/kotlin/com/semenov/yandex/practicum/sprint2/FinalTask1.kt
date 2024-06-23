package com.semenov.yandex.practicum.sprint2

/*
https://contest.yandex.ru/contest/22781/run-report/115475842/

Решение реализовано на массиве(кольцевой буффер)
В решении используется два указателя:
head - указатель, по которому нужно извлекать элемент из дека;
tail - указатель, по которому нужно вставлять элемент в дек.

При операции push_back(value) - проверяется текущий размер массива, и если массив заполнен - выводится ошибка,
в ином случае значение указателя увеличивается на 1 и берется по модулю от максимального значения.

При операции push_front(value) - проверяется текущий размер массива, и если она заполнена - выводится ошибка, в ином случае
значение указателя уменьшается на 1 и прибавляется макс. размер массива для "кольцевого эффекта"

При операции pop_front – проверяется текущий размер массива. Если массив пуст - выдается ошибка, в ином случае
берется элемент из начала массива и уменьшается значение указателя.

При операции pop_back - проверяется текущий размер массива, если пуст - выводится ошибка. Если массив не пуст, берется
значение из конца массива, значение указателя уменьшается

Временная сложность алгоритма O(n), тк зависит от кол-ва данных, подаваемых на вход. Добавление и извлечение из очереди
О(1), поэтому на общую сложность не влияет.

Пространственная сложность - 0(1), тк размер дека задается однажды и больше не изменяется.
*/

fun main() {
    val commandCount = readln().toInt()
    val capacity = readln().toInt()
    val deque = Deque(capacity)

    repeat(commandCount) {
        val input = readln().split(" ")

        when (input[0]) {
            POP_BACK -> {
                deque.popBack()
                    ?.let { println(it) }
                    ?: printError()
            }

            POP_FRONT -> {
                deque.popFront()
                    ?.let { println(it) }
                    ?: printError()
            }

            PUSH_BACK -> {
                if (!deque.pushBack(input[1].toInt())) {
                    printError()
                }
            }

            PUSH_FRONT -> {
                if (!deque.pushFront(input[1].toInt())) {
                    printError()
                }
            }

            else -> error("unknown command")
        }
    }
}

class Deque(private val capacity: Int) {
    private val deque = arrayOfNulls<Int>(capacity)
    private var head = 0
    private var tail = 0
        private set(value) {
            field = value % capacity
        }
    private var size = 0

    fun pushBack(value: Int) =
        if (size == capacity) {
            false
        } else {
            deque[tail] = value
            ++tail
            ++size
            true
        }

    fun pushFront(value: Int) =
        if (size == capacity) {
            false
        } else {
            head = (head - 1 + capacity) % capacity
            deque[head] = value
            ++size
            true
        }


    fun popFront(): Int? {
        return if (size == 0) {
            null
        } else {
            val value = deque[head]
            deque[head] = null
            head = (head + 1) % capacity
            --size
            value
        }
    }

    fun popBack(): Int? {
        return if (size == 0) {
            null
        } else {
            tail = (tail - 1 + capacity) % capacity
            val value = deque[tail]
            deque[tail] = null
            --size
            return value
        }
    }
}

private fun printError() {
    println(ERROR)
}

private const val ERROR = "error"
private const val POP_BACK = "pop_back"
private const val POP_FRONT = "pop_front"
private const val PUSH_BACK = "push_back"
private const val PUSH_FRONT = "push_front"


/**

Гоша реализовал структуру данных Дек, максимальный размер которого определяется заданным числом. Методы push_back(x), push_front(x), pop_back(), pop_front() работали корректно. Но, если в деке было много элементов, программа работала очень долго. Дело в том, что не все операции выполнялись за O(1). Помогите Гоше! Напишите эффективную реализацию.

Внимание: при реализации используйте кольцевой буфер.

Формат ввода
В первой строке записано количество команд n — целое число, не превосходящее 100000.
Во второй строке записано число m — максимальный размер дека.
Он не превосходит 50000. В следующих n строках записана одна из команд:

push_back(value) – добавить элемент в конец дека. Если в деке уже находится максимальное число элементов, вывести «error».
push_front(value) – добавить элемент в начало дека. Если в деке уже находится максимальное число элементов, вывести «error».
pop_front() – вывести первый элемент дека и удалить его. Если дек был пуст, то вывести «error».
pop_back() – вывести последний элемент дека и удалить его. Если дек был пуст, то вывести «error».
Value — целое число, по модулю не превосходящее 1000.
Формат вывода
Выведите результат выполнения каждой команды на отдельной строке.
Для успешных запросов push_back(x) и push_front(x) ничего выводить не надо.

Пример 1

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