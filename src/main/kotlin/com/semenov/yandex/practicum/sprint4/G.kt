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


fun getDuplex(target: Int, ints: IntArray): Set<List<Int>> {
    val sumInfo = mutableMapOf<Int, Index>()
    ints.sort()
    val duplex = mutableSetOf<List<Int>>()

    for (i in ints.indices) {
        for (j in (i + 1) until ints.size) {
            val localTarget = target - ints[i] - ints[j]
            sumInfo[localTarget]?.also {
                duplex.add(listOf(ints[it.i], ints[it.j], ints[i], ints[j]).sorted())
            }
            sumInfo[ints[i] + ints[j]] = Index(i, j)
        }
    }

    return duplex
}

//data class SumInfo(val i: Int, val j: Int, val sum: Int)

data class Index(val i: Int, val j: Int)

/**
 *
8
10
2 3 2 4 1 10 3 0
 *
 * */