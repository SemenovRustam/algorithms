package com.semenov.yandex.practicum.sprint8

fun main() {
    val s = readln()

    val result = getMaxPalindrome(s)
    println(result)
}

fun getMaxPalindrome(s: String): String {
    val map = s.groupingBy { it }
        .eachCount()
        .entries.sortedByDescending {
            it.value
        }

    var mid = ""
    if (s.length % 2 != 0) {
        mid = map.sortedBy { it.key }
            .first { it.value == 1 }
            .key.toString()
    }

    //строю левую сторону
    val left = buildString {
        for ((char, value) in map) {
            if (value % 2 == 0) {
                repeat(value / 2) {
                    append(char)
                }
            }
        }
    }

    val right = left.reversed()

    return left + mid + right
}
