package com.semenov.yandex.practicum.algorithms.algorithms.sprint1

import kotlin.math.absoluteValue

fun main() {
    val (a, b, c) = readInts()
    val ok = solve(a, b, c)
    if (ok) {
        println("WIN")
    } else {
        println("FAIL")
    }
}

private fun solve(a: Int, b: Int, c: Int): Boolean {
    val ax = a.absoluteValue
    val bx = b.absoluteValue
    val cx = c.absoluteValue

    val even = 0
    val notEven = 1
    return when {
        ax % 2 == even && bx % 2 == even && cx % 2 == even -> true
        ax % 2 == notEven && bx % 2 == notEven && cx % 2 == notEven -> true
        else -> false
    }
}

private fun readStr() = readln()
private fun readStrings() = readStr().split(" ")
private fun readInts() = readStrings().map { it.toInt() }

/**
 * Представьте себе онлайн-игру для поездки в метро: игрок нажимает на кнопку,
 * и на экране появляются три случайных числа.
 * Если все три числа оказываются одной чётности, игрок выигрывает.

Напишите программу, которая по трём числам определяет, выиграл игрок или нет.

Формат ввода
В первой строке записаны три случайных целых числа a, b и c. Числа не превосходят 109 по модулю.

Формат вывода
Выведите «WIN», если игрок выиграл, и «FAIL» в противном случае.

Пример 1
Ввод	Вывод
1 2 -3 FAIL

Пример 2
Ввод	Вывод
7 11 7 WIN

Пример 3
Ввод	Вывод
6 -2 0 WIN

 */