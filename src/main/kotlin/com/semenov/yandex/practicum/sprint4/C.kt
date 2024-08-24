package com.semenov.yandex.practicum.sprint4

fun main() {
    val word1 = readln()
    val word2 = readln()

    val result = if (canBeReplaced(word1, word2)) {
        "YES"
    } else {
        "NO"
    }

    println(result)
}

fun canBeReplaced(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val minLength = minOf(word1.length, word2.length)
    val map = buildMap<Char, Char> {
        for (index in 0 until minLength) {
            if (!this.containsKey(word1[index]) && this.containsValue(word2[index])) {
                return false
            }
            this[word1[index]] = word2[index]
        }
    }

    var result = true
    for (index in 0 until minLength) {
        if (map[word1[index]] != word2[index]) {
            result = false
            break
        }
    }
    return result
}


/**
agg
xdd

mxyskaoghi
qodfrgmslc

aba
xxx

abacaba
abacabac
 */