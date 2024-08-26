package com.semenov.yandex.practicum.sprint4


val base = readln().toLong()
val module = readln().toLong()
val string = readln()
val hash = LongArray(string.length + 1)
val powers = LongArray(string.length + 1)

fun main() {
    val countsInterval = readln().toInt()
    powers[0] = 1

    for (i in string.indices) {
        hash[i + 1] = (hash[i] * base + string[i].code) % module
        powers[i + 1] = (powers[i] * base) % module
    }

    repeat(countsInterval) {
        val (start, end) = readln().split(" ").map(String::toInt)
        println(prefixHash(start, end))
    }
}

fun prefixHash(start: Int, end: Int): Long {
    val startIndex = start - 1
    return (hash[end] - (hash[startIndex] * powers[end - startIndex]) % module + module) % module
}

/**
1000
1000009
abcdefgh
7
1 1
1 5
2 3
3 4
4 4
1 8
5 8


100
10
a
1
1 1
 */