package com.semenov.yandex.practicum.sprint3

fun main() {
    readln().toInt()
    val ids = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()

    val result = getPopularUniverse(ids).take(k).joinToString(" ")
    println(result)
}

private fun getPopularUniverse(ids: List<Int>): List<Int> {
    val map = buildMap<Int, Int> {
        for (id in ids) {
            this[id] = getOrPut(id) { 0 } + 1
        }
    }

    return map.entries.sortedByDescending { it.value }
        .map { it.key }
}
