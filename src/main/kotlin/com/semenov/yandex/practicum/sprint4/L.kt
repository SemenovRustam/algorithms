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

fun getIndex(string: String, n: Int) = buildMap<String, MutableList<Int>> {
    for (i in 0 until string.length - n) {
        computeIfAbsent(string.substring(i, i + n)) { mutableListOf() }.add(i)
    }
}



/**

10 2
gggggooooogggggoooooogggggssshaa

3 4
allallallallalla

 */




