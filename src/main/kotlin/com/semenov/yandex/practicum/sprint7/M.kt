package com.semenov.yandex.practicum.sprint7

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val wears = buildList {
        repeat(n) {
            val (m, c) = readln().split(" ").map { it.toInt() }
            add(Wear(m, c))
        }
    }

    val indices = getMaxWearCount(m, wears)
    println(indices.size)
    println(indices.joinToString(" "))
}

fun getMaxWearCount(m: Int, wears: List<Wear>): List<Int> {
    val dp = IntArray(m + 1) { 0 }
    val selectedItems = Array(m + 1) { mutableListOf<Int>() }

    for (i in wears.indices) {
        val (mass, value) = wears[i]
        for (j in m downTo mass) {
            if (dp[j] < dp[j - mass] + value) {
                dp[j] = dp[j - mass] + value
                selectedItems[j] = selectedItems[j - mass].toMutableList()
                selectedItems[j].add(i + 1) // Сохраняем индекс предмета
            }
        }
    }

    val maxValue = dp.maxOrNull() ?: 0

    return selectedItems[dp.indexOf(maxValue)]
}

data class Wear(val mass: Int, val value: Int)

/**
 * M. Рюкзак
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.3 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
OpenJDK Java 11	0.6 секунд	64Mb
C# (MS .NET 6.0 + ASP)	0.6 секунд	64Mb
Java 21 (Temurin JDK)	0.6 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	0.6 секунд	64Mb
C# (MS .NET 5.0 + ASP)	0.6 секунд	64Mb
Тимофей решил отправиться в поход. Ему надо собрать рюкзак.
Так как поход долгий и трудный, необходимо подбирать вещи вдумчиво.

Каждому предмету Тимофей присвоил условную значимость: она равна ci для предмета с номером i.
Также каждый предмет весит mi килограммов. А грузоподъёмность рюкзака  равна M килограмм.

Найдите максимальную суммарную значимость предметов, которые Тимофей может взять с собой,
не порвав рюкзак, и укажите, как набрать эту значимость.

Формат ввода
В первой строке вводится число предметов n, не превышающее 100 и грузоподъемность M, не превышающая 104.

Далее следуют описания предметов по одному в строке. Каждый предмет описывается парой mi,
ci, оба числа не превосходят 100 по модулю.

Формат вывода
Выведите в первой строке единственное число — сколько предметов надо взять.
Во второй строке перечислите их номера (нумерация с единицы). Если ответов несколько, то выведите любой.

Пример
Ввод
4 6
2 7
4 2
1 5
2 1

Вывод
3
4 3 1
 * */