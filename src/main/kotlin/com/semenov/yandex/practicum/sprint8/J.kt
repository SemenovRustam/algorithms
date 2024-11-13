package com.semenov.yandex.practicum.sprint8

fun main() {
    val trie = Trie()
    val n = readln().toInt()
    val words = buildList<String> {
        repeat(n) {
            val word = readln()
            add(word)
            trie.insert(word)
        }
    }
    val m = readln().toInt()
    val patterns = buildList {
        repeat(m) {
            add(readln())
        }
    }
    val result = mutableListOf<String>()
    for (pattern in patterns) {
        if (pattern.isBlank()) {
            println((words).joinToString("\n"))
        } else {
            getMatchingLines(pattern, trie)?.takeIf { it.isNotEmpty() }
                ?.sorted()
                ?.forEach { println(it) }
                ?: println()
        }
    }
}

fun getMatchingLines(pattern: String, trie: Trie): List<String> {
    var current = trie.root
    var patternIndex = 0
    var matchIndex = 0
    for (char in pattern) {
        if (char in current.children) {
            current = current.children[char]!!
            matchIndex++
        }
        patternIndex++
    }
    return if (patternIndex <= matchIndex) current.result else emptyList()
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isTerminated: Boolean = false
    var result = mutableListOf<String>()
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        val pattern = word.filter { it.isUpperCase() }
        var current = root

        for (c in pattern) {
            current = current.children.getOrPut(c) { TrieNode() }
            current.result.add(word)
        }
        current.isTerminated = true
    }
}