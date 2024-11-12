package com.semenov.yandex.practicum.sprint8

fun main() {
    val trie = Trie()

    repeat(readln().toInt()) {
        trie.insert(readln())
    }

    val m = readln().toInt()
    val patterns = List(m) { readln() }

     getMatchingLines(patterns, trie)

}

fun getMatchingLines(pattern: List<String>, trie: Trie) {
    TODO("Not yet implemented")
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isTerminated: Boolean = false
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var current = root

        for (c in word) {
            current = current.children.getOrPut(c) { TrieNode() }
        }
        current.isTerminated = true
    }

    fun search(word: String): Boolean {
        var current = root

        for (c in word) {
            current = current.children.getOrElse(c) { return false }
        }

        return current.isTerminated
    }
}