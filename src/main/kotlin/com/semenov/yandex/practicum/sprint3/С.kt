package com.semenov.yandex.practicum.sprint3

fun main() {
    val s = readln()
    val t = readln()

    val result = checkSubsequence(s, t)

    if (result) {
        println("True")
    } else {
        println("False")
    }
}

private fun checkSubsequence(sub: String, t: String): Boolean {
    var subIndex = 0
    for (index in t.indices) {
        if (subIndex < sub.length && sub[subIndex] == t[index]) {
            subIndex++
        }
        // Ранняя остановка
        if (subIndex == sub.length) {
            return true
        }
    }
    return subIndex == sub.length
}

/**
abc
ahbgdcu

abcp
ahpc

 */