package com.semenov.yandex.practicum.sprint4

import java.util.StringTokenizer

fun main() {
    val count = readln().toInt()
    if (count == 0) {
        println(count)
        return
    }

    val target = readln().toInt()
    val tokenizer = StringTokenizer(readln())
    val ints = IntArray(count) { tokenizer.nextToken().toInt() }

    val duplex = getDuplex(target, ints)
        .sortedBy { it.first() }

    println(duplex.size)
    for (list in duplex) {
        println(list.joinToString(" "))
    }
}


fun getDuplex(A: Int, ints: IntArray): Set<List<Int>> {
    val history = mutableSetOf<Int>()
    ints.sort()
    val duplex = mutableSetOf<List<Int>>()

    for (i in ints.indices) {
        for (j in (i + 1) until ints.size) {
            for (k in (j + 1) until ints.size) {
                val target = A - ints[i] - ints[j] - ints[k]
                if (target in history) {
                    duplex.add(listOf(target, ints[i], ints[j], ints[k]))
                }
            }
        }
        history.add(ints[i])
    }

    return duplex
}
