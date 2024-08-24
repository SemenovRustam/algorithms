package com.semenov.yandex.practicum.sprint4

import java.util.*
import kotlin.math.max

fun main() {
    val count = readln().toInt()
    val tokenizer = StringTokenizer(readln())
    val intArray = IntArray(count) { tokenizer.nextToken().toInt() }
    val maxRounds = getMaxRounds(intArray)

    println(maxRounds)
}

fun getMaxRounds(array: IntArray): Int {
    val ints = array.map { if (it == 0) 1 else -1 }

    val prefixSumIndex = mutableMapOf(0 to -1)
    var currentPrefixSum = 0
    var maxLenght = 0

    for (index in ints.indices) {
        currentPrefixSum += ints[index]

        if (prefixSumIndex.containsKey(currentPrefixSum)) {
            val length = index - prefixSumIndex[currentPrefixSum]!!
            if (length > maxLenght) {
                maxLenght = length
            }
        } else {
            prefixSumIndex[currentPrefixSum] = index
        }
    }
    return maxLenght
}

/**

B. Соревнование
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.3 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
OpenJDK Java 11	0.5 секунд	64Mb
C# (MS .NET 6.0 + ASP)	0.5 секунд	64Mb
Java 21 (Temurin JDK)	0.5 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	0.5 секунд	64Mb
C# (MS .NET 5.0 + ASP)	0.5 секунд	64Mb
Жители Алгосов любят устраивать турниры по спортивному программированию.
Все участники разбиваются на пары и соревнуются друг с другом.
А потом два самых сильных программиста встречаются в финальной схватке, которая состоит из нескольких раундов.
Если в очередном раунде выигрывает первый участник,
в таблицу с результатами записывается 0, если второй, то 1. Ничьей в раунде быть не может.

Нужно определить наибольший по длине непрерывный отрезок раундов,
по результатам которого суммарно получается ничья.
Например, если дана последовательность 0 0 1 0 1 1 1 0 0 0,
то раунды с 2-го по 9-й (нумерация начинается с единицы) дают ничью.

Формат ввода
В первой строке задаётся n (0 ≤ n ≤ 105) –— количество раундов.
Во второй строке через пробел записано n чисел –— результаты раундов.
Каждое число равно либо 0, либо 1.

Формат вывода
Выведите длину найденного отрезка.

Пример 1

Ввод
2
0 1

Вывод
2

Пример 2
Ввод
3
0 1 0

Вывод
2

 */