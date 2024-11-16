package com.semenov.yandex.practicum.sprint8.final_task

import java.util.Stack

fun main() {
    val n = readln().toInt()
    val words = List(n) { unpack(readln()) }

    val maxPrefix = getMaxPrefix(words)

    words.forEach { println(it) }
//    println(maxPrefix)
}
//jwcnjwcnemguemgubzgy
private fun getMaxPrefix(words: List<String>): String {
    var prefix = words[0]

    for (i in 1 until words.size) {
        while (words[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
    }

    return prefix
}

fun unpack(s: String): String {
    val unpack = StringBuilder()
    val digit = Stack<Int>()
    val stringStack = Stack<String>()

    for (char in s) {
        when {
            char.isLetter() -> unpack.append(char)
            char.isDigit() -> digit.push(char.digitToInt())
            char == '[' -> {
                if (!unpack.isNullOrBlank()) {
                    stringStack.push(unpack.toString())
                    unpack.clear()
                }
            }

            char == ']' -> {
                val multiplier = digit.pop()
                val pop = if (stringStack.isNotEmpty()) stringStack.pop() else ""
                val newCurrent = unpack.repeat(multiplier) //tt
                unpack.clear()
                unpack.append(pop)
                    .append(newCurrent)

            }
        }
    }

    return unpack.toString()
}