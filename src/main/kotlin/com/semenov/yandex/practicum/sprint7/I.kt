package com.semenov.yandex.practicum.sprint7

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val matrix = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        readln().forEachIndexed { j, char ->
            matrix[i][j] = char.digitToInt()
        }
    }

    val (maxFlowers, path) = getMaxFlowersWithPath(matrix, n, m)
    println(maxFlowers)
    println(path)
}

fun getMaxFlowersWithPath(matrix: Array<IntArray>, n: Int, m: Int): Pair<Int, String> {
    val dp = Array(n) { IntArray(m) }
    val path = Array(n) { Array(m) { "" } } // Массив для отслеживания пути

    // Начальная точка (нижний левый угол)
    dp[n - 1][0] = matrix[n - 1][0]

    // Заполняем первую колонку
    for (i in n - 2 downTo 0) {
        dp[i][0] = dp[i + 1][0] + matrix[i][0]
        path[i][0] = "U"
    }

    // Заполняем первую строку
    for (j in 1 until m) {
        dp[n - 1][j] = dp[n - 1][j - 1] + matrix[n - 1][j]
        path[n - 1][j] = "R" // Движение вправо
    }

    // Заполнение остальной части dp массива
    for (i in n - 2 downTo 0) {
        for (j in 1 until m) {
            if (dp[i + 1][j] > dp[i][j - 1]) {
                dp[i][j] = dp[i + 1][j] + matrix[i][j]
                path[i][j] = "U" // Движение вверх
            } else {
                dp[i][j] = dp[i][j - 1] + matrix[i][j]
                path[i][j] = "R" // Движение вправо
            }
        }
    }

    // Восстановление маршрута
    val sb = StringBuilder()
    var i = 0
    var j = m - 1
    while (i < n - 1 || j > 0) {
        if (path[i][j] == "U") {
            sb.append('U')
            i++
        } else {
            sb.append('R')
            j--
        }
    }

    return Pair(dp[0][m - 1], sb.reverse().toString())
}