package com.semenov.yandex.practicum.sprint3

fun main() {
    val s = readln()
    val t = readln()

    val result = checkSubsequence(s, t)

    if (s == result) {
        println("True")
    } else {
        println("False")
    }
}

private fun checkSubsequence(sub: String, t: String) = buildString {
    var subIndex = 0
    for (index in t.indices) {
        if (sub[subIndex] == t[index]) {
            subIndex++
            append(t[index])

            if (subIndex == sub.length) {
                break
            }
        }
    }
}

/**
abc
ahbgdcu

abcp
ahpc

 */