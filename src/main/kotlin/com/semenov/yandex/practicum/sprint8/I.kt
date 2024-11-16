package com.semenov.yandex.practicum.sprint8

fun main() {
    val s = readln()

    val result = getMaxRepeat(s)
    println(result)
}

fun getMaxRepeat(s: String): Int {
    val n = s.length
    val pi = IntArray(n)

    for (i in 1 until n) {
        var j = pi[i - 1]
        while (j > 0 && s[i] != s[j]) {
            j = pi[j - 1]
        }
        if (s[i] == s[j]) {
            j++
        }
        pi[i] = j
    }

    // Длина наибольшего префикса, который также является суффиксом
    val len = pi[n - 1]
    val d = n - len

    // Проверяем, является ли d делителем n
    return if (n % d == 0) n / d else 1
}