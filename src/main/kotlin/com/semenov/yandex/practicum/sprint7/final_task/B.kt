package com.semenov.yandex.practicum.sprint7.final_task

fun main() {
    readln().toInt()
    val records = readln().split(" ").map { it.toInt() }.toIntArray()

    val result = if (isDivided(records)) "True" else "False"

    println(result)
}

fun isDivided(scores: IntArray): Boolean {
    val totalSum = scores.sum()

    if (totalSum % 2 != 0) {
        return false
    }

    val target = totalSum / 2

    val dp = BooleanArray(target + 1)
    dp[0] = true

    for (score in scores) {
        for (j in target downTo score) {
            if (dp[j - score]) {
                dp[j] = true
            }
        }
    }

    return dp[target]
}
