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
    for (i in size / 2 downTo 0) {
        siftDown(comparator, i, size)
    }

    for (i in size - 1 downTo 1) {
        swap(this, 0, i)
        siftDown(comparator, 0, i)
    }
}

fun <T> MutableList<T>.siftDown(comparator: Comparator<T>, start: Int, end: Int) {
    val left = 2 * start + 1
    val right = left + 1

    if (left >= end) return

    val largestIndex = if (right < end && comparator.compare(this[left], this[right]) < 0) right else left

    if (comparator.compare(this[start], this[largestIndex]) < 0) {
        swap(this, start, largestIndex)
        siftDown(comparator, largestIndex, end)
    }
}

data class Person(
    val name: String,
    val solvedTask: Int,
    val fine: Int
)