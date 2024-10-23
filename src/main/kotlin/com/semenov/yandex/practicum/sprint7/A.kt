package com.semenov.yandex.practicum.sprint7

fun main() {
    readln().toInt()

    val price = readln().split(" ").map { it.toInt() }

    val maxProfit = maxProfit(price)
    println(maxProfit)
}

fun maxProfit(prices: List<Int>): Int {
    if (prices.size < 2) return 0

    var profit = 0
    for (i in 0 until prices.size - 1) {
        if (prices[i] < prices[i + 1]) {
            profit += prices[i + 1] - prices[i]
        }
    }
    return profit
}

