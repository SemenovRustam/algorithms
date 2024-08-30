package com.semenov.yandex.practicum.sprint4

import java.util.*

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


fun getDuplex(target: Int, ints: IntArray): Set<List<Int>> {
    val sumInfo = mutableMapOf<Int, List<Int>>()
    val duplex = mutableSetOf<List<Int>>()

    for (i in ints.indices) {
        for (j in (i + 1) until ints.size) {
            val localTarget = target - ints[i] - ints[j]
            if (localTarget in sumInfo.keys) {
                val (first, second) = sumInfo[localTarget]!!
                if (first != i && second != j) {
                    duplex.add(
                        listOf(ints[first], ints[second], ints[i], ints[j]).sorted()
                    )
                }
            }
            sumInfo[ints[i] + ints[j]] = listOf(i, j)
        }
    }

    return duplex
}


/**
 *
8
10
2 3 2 4 1 10 3 0
 *
 * */