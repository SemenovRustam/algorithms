package com.semenov.yandex.practicum.sprint8.final_task


fun main() {
    val text = readln()
    val n = readln().toInt()

    val trie = Trie()
    repeat(n) {
        trie.insert(readln())
    }

    val result = if (canSegment(text, trie)) "YES" else "NO"
    println(result)
}

fun canSegment(text: String, trie: Trie): Boolean {
    val n = text.length
    val booleans = BooleanArray(n + 1)
    booleans[0] = true

    for (i in text.indices) {
        if (!booleans[i]) continue

        var current = trie.root
        for (j in i until n) {
            val char = text[j]
            current = current.children[char] ?: break

            if (current.terminated) {
                booleans[j + 1] = true
            }
        }
    }

    println(booleans.contentToString())
    return booleans[n]
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var terminated = false
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.terminated = true
    }
}