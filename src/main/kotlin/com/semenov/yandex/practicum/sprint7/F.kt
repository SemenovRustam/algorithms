package com.semenov.yandex.practicum.sprint7

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    println(countWays(n, k))
}

private fun countWays(n: Int, k: Int): Int {
    val mod = 1_000_000_007
    val dp = IntArray(n + 1)
    dp[1] = 1

    for (i in 2..n) {
        for (j in 1..k) {
            if (i - j >= 1) {
                println("dp[$i] = ${dp[i]}, j = $j")
                dp[i] = (dp[i] + dp[i - j]) % mod
            }
        }
    }

    return dp[n]
}
/**
F. Прыжки по лестнице
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.1 секунда	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.4 секунды	64Mb
OpenJDK Java 11	0.4 секунды	64Mb
C# (MS .NET 6.0 + ASP)	0.4 секунды	64Mb
Python 3.12.1	0.3 секунды	64Mb
Java 21 (Temurin JDK)	0.4 секунды	64Mb
Kotlin 1.8.0 (JRE 11)	0.4 секунды	64Mb
C# (MS .NET 5.0 + ASP)	0.4 секунды	64Mb
Алла хочет доказать, что она умеет прыгать вверх по лестнице быстрее всех. На этот раз соревнования будут проходить
на специальной прыгательной лестнице. С каждой её ступеньки можно прыгнуть вверх на любое расстояние от 1 до k.
Число k придумывает Алла.

Гоша не хочет проиграть, поэтому просит вас посчитать количество способов допрыгать от первой ступеньки до n-й.
Изначально все стоят на первой ступеньке.

Формат ввода
В единственной строке даны два числа — n и k (1 ≤ n ≤ 1000, 1 ≤ k ≤ n).

Формат вывода
Выведите количество способов по модулю 109 + 7.

Пример 1
Ввод
6 3

Вывод
13

Пример 2
Ввод
7 7

Вывод
32

Пример 3
Ввод
2 2

Вывод
1
 */