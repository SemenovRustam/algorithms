package com.semenov.yandex.practicum.sprint8

fun main() {
    val trie = TrieF()
    val n = readln().toInt()

    val lines = mutableListOf<String>()
    repeat(n) {
        lines.add(readln())
    }

    val result = getFreqWord(lines, trie)
    println(result)
}

fun getFreqWord(lines: MutableList<String>, trie: TrieF): String {
    var currentFreqWordCount = 0
    var currentFreqWord = ""

    for (word in lines) {
        val terminatedCount = trie.insert(word)
        if (terminatedCount > currentFreqWordCount ||
            (currentFreqWord.isNotEmpty() && word < currentFreqWord && terminatedCount == currentFreqWordCount)
        ) {
            currentFreqWordCount = terminatedCount
            currentFreqWord = word
        }
    }

    return currentFreqWord
}


class TrieNodeF {
    val children = mutableMapOf<Char, TrieNodeF>()
    var terminatedCount = 0
}

class TrieF {
    var root = TrieNodeF()

    fun insert(s: String): Int {
        var current = root

        for (char in s) {
            current = current.children.getOrPut(char) { TrieNodeF() }
        }
        current.terminatedCount += 1

        return current.terminatedCount
    }
}