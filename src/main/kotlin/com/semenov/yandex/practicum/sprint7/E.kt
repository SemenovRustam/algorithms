package com.semenov.yandex.practicum.sprint7


fun main() {
    val coast = readln().toInt()
    readln()
    val nominal = readln().split(" ").map { it.toInt() }.sortedByDescending { it }

    println(getMinBanknotes(coast, nominal))
}

fun getMinBanknotes(coast: Int, nominals: List<Int>): Int {
    // Создаем массив для хранения минимального количества банкнот для каждой суммы от 0 до coast
    val dp = IntArray(coast + 1) { Int.MAX_VALUE }
    dp[0] = 0 // Для суммы 0 нужно 0 банкнот

    // Заполняем массив dp
    for (nominal in nominals) {
        for (j in nominal..coast) { //j==80
            if (dp[j - nominal] != Int.MAX_VALUE) {
                dp[j] = minOf(dp[j], dp[j - nominal] + 1)
            }
        }
    }

    return if (dp[coast] == Int.MAX_VALUE) -1 else dp[coast] // Если для coast не нашли решение, возвращаем -1
}