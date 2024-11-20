package com.semenov.yandex.practicum.sprint8


fun main() {
    val lines = buildList {
        repeat(readln().toInt()) {
            add(readln())
        }
    }

    val result = if (lines.size == 1) lines.first().length else getMaxPrefix(lines)

    println(result)
}

fun getMaxPrefix(strings: List<String>): Int {
    val trie = Trie1()
    var prefix = strings.first().length
    trie.insert(strings.first())

    for (i in 1 until strings.size) {
        val currentPrefix = trie.insert(strings[i].take(prefix))

        if (currentPrefix < prefix) {
            prefix = currentPrefix
        }
    }

    return prefix
}

class TrieNode1 {
    val children = mutableMapOf<Char, TrieNode1>()
    var maxIndex = 0
}

class Trie1 {
    var root = TrieNode1()

    fun insert(text: String): Int {
        var current = root
        var max = 0

        for (char in text) {
            if (char in current.children) {
                max++
            }
            current = current.children.getOrPut(char) { TrieNode1() }
            current.maxIndex = max
        }

        return current.maxIndex
    }
}
