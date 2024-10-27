package com.semenov.yandex.practicum.sprint7

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val matrix = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        readln().forEachIndexed { j, char ->
            matrix[i][j] = char.digitToInt()
        }
    }

    println(getMaxFlowers(matrix, n, m))
}

fun getMaxFlowers(matrix: Array<IntArray>, n: Int, m: Int): Int {
    val dp = Array(n) { IntArray(m) }

    // Начальная точка (нижний левый угол)
    dp[n - 1][0] = matrix[n - 1][0]

    // Заполняем первую колонку
    for (i in n - 2 downTo 0) {
        dp[i][0] = dp[i + 1][0] + matrix[i][0]
    }

    // Заполняем первую строку
    for (j in 1 until m) {
        dp[n - 1][j] = dp[n - 1][j - 1] + matrix[n - 1][j]
    }

    // Заполняем оставшиеся ячейки
    for (i in n - 2 downTo 0) {
        for (j in 1 until m) {
            dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1]) + matrix[i][j]
        }
    }

    println()
    dp.forEach {
        println(it.joinToString(" "))
    }


    // Возвращаем максимальное количество цветочков в правом верхнем углу
    return dp[0][m - 1]
}
