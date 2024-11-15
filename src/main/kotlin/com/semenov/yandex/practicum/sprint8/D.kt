package com.semenov.yandex.practicum.sprint8

fun main() {
    val trie = Trie1()
    val lines = buildList {
        repeat(readln().toInt()) {
            add(readln())
        }
    }

    val result = getMaxPrefix(lines, trie)

    println(result)
}

fun getMaxPrefix(strings: List<String>, trie: Trie1): Int {
    var currentMax = 0
    var minLength = 0
    for (s in strings.sorted()) {
        if (minLength == 0 || s.length < minLength) {
            minLength = s.length
        }

        val maxIndex = trie.insert(s.take(minLength))
        if (maxIndex > currentMax) {
            currentMax = maxIndex
        }
    }

    return currentMax
}

class TrieNode1 {
    val children = mutableMapOf<Char, TrieNode1>()
    var maxIndex = 0
}

class Trie1() {
    var root = TrieNode1()

    fun insert(s: String): Int {
        var current = root
        var max = 0
        var currentIndex = 0

        for (c in s) {
            if (c in current.children && currentIndex == max) {
                max++
            }
            currentIndex++
            current = current.children.getOrPut(c) { TrieNode1() }
            current.maxIndex = max
        }

        return current.maxIndex
    }
}

