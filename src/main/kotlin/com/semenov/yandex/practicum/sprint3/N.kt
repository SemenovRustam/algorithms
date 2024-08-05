package com.semenov.yandex.practicum.sprint3

fun main() {
    val count = readln().toInt()
    val pairs = buildSet<Pair> {
        for (i in 0 until count) {
            val (start, end) = readln().split(" ").map { it.toInt() }
            add(Pair(start, end))
        }
    }.sortedWith { a, b ->
        if (a.start != b.start) {
            a.start.compareTo(b.start);
        } else {
            a.end.compareTo(b.end);
        }
    }

    val clumbs = createClumbs(pairs)
    for (clumb in clumbs) {
        println("${clumb.start} ${clumb.end}")
    }

}

private fun createClumbs(pairs: List<Pair>) = buildList {
    var currentInterval = pairs.first()

    for (index in 1 until pairs.size) {
        val nextInterval = pairs[index]

        currentInterval = if (currentInterval.end >= nextInterval.start) {
            Pair(currentInterval.start, maxOf(currentInterval.end, nextInterval.end))
        } else {
            add(currentInterval)
            nextInterval
        }
    }

    add(currentInterval)

}

private fun createPairs(left: Pair, right: Pair): Pair {
    var start = left.start
    var end = if (left.end < right.start) {
        left.end
    } else {
        maxOf(left.end, right.end)
    }
    return Pair(start, end)
}

private data class Pair(val start: Int, val end: Int)

/**
 *
 *

Ввод
4
7 8
7 8
2 3
6 10

Вывод
2 3
6 10


Ввод
4
2 3
5 6
3 4
3 4

Вывод
2 4
5 6

 */