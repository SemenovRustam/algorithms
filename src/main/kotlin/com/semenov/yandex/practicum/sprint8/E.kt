package com.semenov.yandex.practicum.sprint8

fun main() {
    val original = readln()
    val strings = buildList {
        repeat(readln().toInt()) {
            val (str, index) = readln().split(" ")
            add(Data(str, index.toInt()))
        }
    }.sortedBy { it.index }

    val result = insertIntoString(original, strings)
    println(result)
}



fun insertIntoString(original: String, strings: List<Data>): String {
    val result = buildList {
        var lastIndex = 0
        for (data in strings) {
            add(original.substring(lastIndex, data.index))
            add(data.inputString)
            lastIndex = data.index
        }
        add(original.substring(lastIndex))
    }

    return result.joinToString("")
}

data class Data(val inputString: String, val index: Int)


/**
Пример 1
Ввод

abacaba
3
queue 2
deque 0
stack 7

Вывод
dequeabqueueacabastack

Пример 2
Ввод

kukareku
2
p 1
q 2

Вывод
kpuqkareku
 * */