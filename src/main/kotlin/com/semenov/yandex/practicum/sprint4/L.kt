package com.semenov.yandex.practicum.sprint4

fun main() {
    val (length, count) = readln().split(" ").map { it.toInt() }
    val string = readln()

    buildList {
        getIndex(string, length)
            .filter {
                it.value.size >= count
            }
            .forEach {
                add(it.value.first())
            }
    }.also {
        println(it.joinToString(" "))
    }
}

fun getIndex(string: String, length: Int) = buildMap<Long, MutableList<Int>> {
    for (i in string.indices) {
        if (i + length <= string.length - 1) {
            val hash = string.substring(i, i + length).hashCode().toLong()
            computeIfAbsent(hash) { mutableListOf() }.add(i)
        }
    }
}





