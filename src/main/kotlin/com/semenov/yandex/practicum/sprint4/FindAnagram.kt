package com.semenov.yandex.practicum.sprint4

fun main() {
    readln()
    val words = readln().split(" ")

    val anagram = findAnagram(words)

    for (value in anagram.values) {
        println(value.joinToString(" "))
    }

}

fun findAnagram(words: List<String>): Map<Int, MutableList<Int>> {
    val result = mutableMapOf<Int, MutableList<Int>>()

    words.forEachIndexed { i, word ->
        val key = word.hash()
        result.getOrPut(key) { mutableListOf() }.add(i)
    }

    return result
}


private fun String.hash(): Int {
    var hash = 31
    val module = 1_000_000_7

    for (i in indices) {
        hash = (hash * this[i].code) % module
    }

    return hash
}
