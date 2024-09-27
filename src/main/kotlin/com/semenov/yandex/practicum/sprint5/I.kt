package com.semenov.yandex.practicum.sprint5


fun main() {
    val N = readln().toInt()
    val trees = catalan(N)
    println(trees)
}

fun catalan(n: Int): Long {
    val catalan = LongArray(n + 1)
    catalan[0] = 1
    catalan[1] = 1

    for (i in 2..n) {
        catalan[i] = 0
        for (j in 0 until i) {
            catalan[i] += catalan[j] * catalan[i - j - 1]
        }
    }

    return catalan[n]
}

