package com.semenov.yandex.practicum.sprint1

import kotlin.math.abs
import kotlin.math.min


fun main() {
    readln()
    val homeNumbers = readln().split(" ").map { it.toInt() }

    val toNearestZero = toNearestZero(homeNumbers)

    println(toNearestZero.joinToString(" "))
}

private fun toNearestZero(homeNumbers: List<Int>): List<Int> {
    val result = MutableList(homeNumbers.size) { 0 }
    val zeroIndexes = mutableListOf<Int>()

    homeNumbers.forEachIndexed { index, value ->
        if (value == 0) {
            zeroIndexes.add(index)
        }
    }

    var index = 0
    var leftZeroIndex = zeroIndexes[index]
    var rightZeroIndex = zeroIndexes.getOrElse(++index) { leftZeroIndex }

    for (i in homeNumbers.indices) {
        if (rightZeroIndex == i) {
            leftZeroIndex = rightZeroIndex
            rightZeroIndex = zeroIndexes.getOrElse(++index) { leftZeroIndex }
        }
        if (homeNumbers[i] != 0) {
            result[i] = min(
                abs(i - leftZeroIndex),
                abs(i - rightZeroIndex)
            )
        }
    }
    return result
}

/**
Все языки	3 секунды	256Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	1.6 секунд	256Mb
Swift 5.9.2	2 секунды	256Mb
OpenJDK Java 11	1.6 секунд	400Mb
C# (MS .NET 6.0 + ASP)	1.6 секунд	400Mb
Golang 1.21.0	0.8 секунд	64Mb
GNU GCC 13.1 C++20	0.8 секунд	64Mb
Java 21 (Temurin JDK)	1.6 секунд	400Mb
Kotlin 1.8.0 (JRE 11)	2.5 секунд	256Mb
GNU c++17 7.3	0.8 секунд	64Mb
C# (MS .NET 5.0 + ASP)	1.6 секунд	400Mb

Тимофей ищет место, чтобы построить себе дом.
Улица, на которой он хочет жить, имеет длину n, то есть состоит из n одинаковых идущих подряд участков.
Каждый участок либо пустой, либо на нём уже построен дом.

Общительный Тимофей не хочет жить далеко от других людей на этой улице.
Поэтому ему важно для каждого участка знать расстояние до ближайшего пустого участка.
Если участок пустой, эта величина будет равна нулю — расстояние до самого себя.

Помогите Тимофею посчитать искомые расстояния.
Для этого у вас есть карта улицы.
Дома в городе Тимофея нумеровались в том порядке, в котором строились, поэтому их номера на карте никак не упорядочены.
Пустые участки обозначены нулями.

Формат ввода
В первой строке дана длина улицы —– n (1 ≤ n ≤ 106).
В следующей строке записаны n целых неотрицательных чисел — номера домов и обозначения пустых участков на карте (нули).
Гарантируется, что в последовательности есть хотя бы один ноль. Номера домов (положительные числа) уникальны и не превосходят 109.

Формат вывода
Для каждого из участков выведите расстояние до ближайшего нуля. Числа выводите в одну строку, разделяя их пробелами.

Пример 1
Ввод
5
0 1 4 9 0

Вывод
0 1 2 1 0

Пример 2
Ввод
6
0 7 9 4 8 20

Вывод
0 1 2 3 4 5

Входной файл
20
10 13 31 35 39 0 0 59 0 66 68 73 74 0 0 0 87 89 96 99

Вывод
5 4 3 2 1 0 0 1 0 1 2 2 1 0 0 0 1 2 3 4


 */