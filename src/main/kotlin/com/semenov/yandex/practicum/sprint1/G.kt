package com.semenov.yandex.practicum.sprint1

/**
 * G. Работа из дома
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Вася реализовал функцию, которая переводит целое число из десятичной системы в двоичную.
Но, кажется, она получилась не очень оптимальной.

Попробуйте написать более эффективную программу.

Не используйте встроенные средства языка по переводу чисел в бинарное представление.

Формат ввода
На вход подаётся целое число в диапазоне от 0 до 10000.

Формат вывода
Выведите двоичное представление этого числа.

Пример 1
Ввод	Вывод
5       101

Пример 2
Ввод	Вывод
14      1110

 * */

fun main() {
    val number = readInt()
    println(toBinary(number))
}

private fun toBinary(number: Int): String {
    if (number==0) return "0"

    val sb = StringBuilder()
    var result = number
    while (result != 0) {
        if (result % 2 == 0) {
            sb.append(0)
        } else {
            sb.append(1)
        }
        result /= 2
    }
    return sb.reverse().toString()
}

private fun readStr() = readln()
private fun readInt() = readStr().toInt()