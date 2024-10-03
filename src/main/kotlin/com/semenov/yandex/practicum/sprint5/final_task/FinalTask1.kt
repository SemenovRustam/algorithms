package com.semenov.yandex.practicum.sprint5.final_task

import java.util.Collections.swap

fun main() {
    val count = readln().toInt()

    val person = Array(count) {
        val (name, solvedTask, fine) = readln().split(" ")
        Person(
            name = name,
            solvedTask = solvedTask.toInt(),
            fine = fine.toInt()
        )
    }.toMutableList()

    val memberComparator = compareByDescending<Person> { it.solvedTask }
        .thenBy { it.fine }
        .thenBy { it.name }


    person.heapSort(memberComparator)

    val result = person.joinToString("\n") { it.name }
    println(result)

}

fun <T> MutableList<T>.heapSort(comparator: Comparator<T>) {
// Построение кучи
    for (i in size / 2 - 1 downTo 0) {
        siftDown(comparator, i, size)
    }

    // Извлечение элементов из кучи
    for (i in size - 1 downTo 1) {
        swap(this, 0, i)
        siftDown(comparator, 0, i)
    }
}

fun <T> MutableList<T>.siftDown(comparator: Comparator<T>, start: Int, end: Int) {
    var root = start
    while (true) {
        var child = 2 * root + 1
        if (child >= end) break

        // Если у корня есть правый дочерний элемент и он больше левого, используем правый
        if (child + 1 < end && comparator.compare(this[child], this[child + 1]) < 0) {
            child++
        }

        // Если корень меньше дочернего элемента, меняем их местами
        if (comparator.compare(this[root], this[child]) < 0) {
            swap(this, root, child)
            root = child
        } else {
            break
        }
    }
}


data class Person(
    val name: String,
    val solvedTask: Int,
    val fine: Int
)