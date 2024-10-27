package com.semenov.yandex.practicum.sprint7

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    println(countWays(n, k))
}

fun countWays(n: Int, k: Int): Int {
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