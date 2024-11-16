package com.semenov.yandex.practicum.work

import com.semenov.yandex.practicum.sprint3.test


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

    for (i in 0 until n) {
        if (!booleans[i]) continue

        var node = trie.root
        for (j in i until n) {
            val char = text[j]
            node = node.children[char] ?: break
            if (node.terminated) {
                booleans[j + 1] = true
            }
        }
    }

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


/**
Пример 1

Ввод

examiwillpasstheexam
5
will
pass
the
exam
i

Вывод
YES

Пример 2
Ввод

abacaba
2
abac
caba

Вывод
NO


Пример 3
Ввод

abacaba
3
abac
caba
aba

Вывод
YES

 */