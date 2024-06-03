package com.semenov.yandex.practicum.sprint1

import kotlin.math.pow

fun main() {
    val number = readInt()
    println(if (isDegreeOfFour(number)) "True" else "False")
}

private fun isDegreeOfFour(n: Int): Boolean {
    val listOf = listOf(
        1,
        4,
        4 * 4,
        4 * 4 * 4,
        4 * 4 * 4 * 4,
        4 * 4 * 4 * 4 * 4,
        4 * 4 * 4 * 4 * 4 * 4
    )

    if (n in listOf) {
        return true
    }
    return false
}

private fun readStr() = readln()
private fun readInt() = readStr().toInt()

/**
I. Степень четырёх
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt

Напишите программу, которая определяет, будет ли положительное целое число степенью четвёрки.

Подсказка: степенью четвёрки будут все числа вида 4^n, где n – целое неотрицательное число.

Формат ввода
На вход подаётся целое число в диапазоне от 1 до 10000.

Формат вывода
Выведите «True», если число является степенью четырёх, «False» –— в обратном случае.

Пример 1
Ввод	Вывод
15      False

Пример 2
Ввод	Вывод
16      True
 */