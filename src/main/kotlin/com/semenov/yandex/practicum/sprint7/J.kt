package com.semenov.yandex.practicum.sprint7

fun main() {
    val n = readln().toInt()
    val ratings = readln().split(" ").map { it.toInt() }.toIntArray()

    val (length, indices) = findLIS(ratings)
    println(length)
    println(indices.joinToString(" "))
}


fun findLIS(ratings: IntArray): Pair<Int, List<Int>> {
    val n = ratings.size
    if (n == 0) return Pair(0, emptyList())

    val dp = IntArray(n) { 1 } // Длина LCS для каждого элемента
    val prev = IntArray(n) { -1 } // Для восстановления последовательности

    var maxLength = 1
    var maxIndex = 0

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (ratings[j] < ratings[i]) {
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1
                    prev[i] = j
                }
            }
        }
        if (dp[i] > maxLength) {
            maxLength = dp[i]
            maxIndex = i
        }
    }

    // Восстановление последовательности
    val lisIndices = mutableListOf<Int>()
    while (maxIndex != -1) {
        lisIndices.add(maxIndex + 1) // +1 для перехода к 1-индексации
        maxIndex = prev[maxIndex]
    }

    lisIndices.reverse() // Обратим порядок, чтобы получить правильную последовательность

    return Pair(maxLength, lisIndices)
}