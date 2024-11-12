package com.semenov.yandex.practicum.sprint8



fun main() {
    val trie = Trie()

    val n = readln().toInt()
    val text = List(n) { readln() }

    val m = readln().toInt()
    repeat(m) {
        trie.insert(readln())
    }

    val result = buildList {
        for (word in text) {
            add(getMatchingLines(word, trie))
        }
    }


    for (word in result.sortedBy { it }) {
        word?.also { println(it) }
    }
}

fun getMatchingLines(s: String, trie: Trie): String? {
    var current = trie.root
    for (char in s) {
        if (char.isUpperCase() && char in current.children) {
            current = current.children[char]!!
            if (current.isTerminated) return s
        }
    }
    return null
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