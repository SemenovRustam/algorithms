package com.semenov.yandex.practicum.sprint8

fun main() {
    val trie = Trie1()
    val lines = buildList {
        repeat(readln().toInt()) {
            add(readln())
        }
    }

    val result = if (lines.size == 1) lines.first().length else getMaxPrefix(lines, trie)

    println(result)
}

fun getMaxPrefix(strings: List<String>, trie: Trie1): Int {
    var currentMax = 0
    var minLength = 0

    for ((currentIndex, s) in strings.sorted().withIndex()) {
        if (minLength == 0 || s.length < minLength) {
            minLength = s.length
        }

        val maxIndex = trie.insert(s.take(minLength), currentIndex)

        if (maxIndex == -1) {
            return 0
        }
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

    fun insert(s: String, index: Int): Int {
        var current = root
        var max = 0

        for (c in s) {
            if (c in current.children) {
                max++
            } else {
                if (index > 0 && current.maxIndex == 0) {
                    return -1
                }
            }

            current = current.children.getOrPut(c) { TrieNode1() }
            current.maxIndex = max
        }

        return current.maxIndex
    }
}

//fun main() {
//    val n = readln().toInt()
//    val strings = List(n) { readln() }
//
//    val result = longestCommonPrefix(strings)
//
//    println(result)
//}
//
//fun longestCommonPrefix(strings: List<String>): Int {
//    if (strings.isEmpty()) return 0
//
//    var prefix = strings[0]
//
//    for (i in 1 until strings.size) {
//        while (strings[i].indexOf(prefix) != 0) {
//            prefix = prefix.substring(0, prefix.length - 1)
//            if (prefix.isEmpty()) return 0
//        }
//    }
//
//    return prefix.length
//}

