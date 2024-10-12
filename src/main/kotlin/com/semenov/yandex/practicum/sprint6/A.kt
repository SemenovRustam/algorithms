package com.semenov.yandex.practicum.sprint6

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    buildMap<Int, MutableList<Int>> {
        repeat(m) {
            val (u, v) = readln().split(" ").map { it.toInt() }
            computeIfAbsent(u) { mutableListOf() }.add(v)
        }
        for (i in 1..n) {
            getOrPut(i) { mutableListOf() }
        }
    }.toSortedMap().forEach {
        val message = if (it.value.isNotEmpty()) {
            "${it.value.size} ${it.value.joinToString(" ")}"
        } else {
            "0"
        }
        println(message)
    }
}

