package com.semenov.yandex.practicum.sprint7.final_task

fun main() {
    val s = readln()
    val t = readln()

    levenshteinRange(s, t)
}

fun levenshteinRange(s: String, t: String) {
    val dp = Array(s.length + 1) { IntArray(t.length + 1) }

    // Инициализация первой строки и первого столбца
    for (i in 0..s.length) {
        dp[i][0] = i // Удаление всех символов из s
    }
    for (j in 0..t.length) {
        dp[0][j] = j // Вставка всех символов в t
    }

    for (i in 1..s.length) {
        for (j in 1..t.length) {
            if (s[i - 1] == t[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = minOf(
                    dp[i - 1][j] + 1,
                    dp[i][j - 1] + 1,
                    dp[i - 1][j - 1] + 1
                )
            }
        }
    }

    println(dp[s.length][t.length])
}
