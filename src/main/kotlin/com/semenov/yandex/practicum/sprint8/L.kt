package com.semenov.yandex.practicum.sprint8

fun main() {
    val text = readln()

    val result = getPrefixIndecies(text)

    println(result.joinToString(" "))
}

fun getPrefixIndecies(s: String): IntArray {
    val n = s.length
    val pi = IntArray(n) { 0 }
    pi[0]

    for (i in 1 until n) {
        var k = pi[i - 1]

        while (k > 0 && s[k] != s[i]) {
            k = pi[k - 1]
        }

        if (s[i] == s[k]) {
            k++
        }
        pi[i] = k
    }

    return pi
}
