package com.semenov.yandex.practicum.sprint5.final_task

/**
 * https://contest.yandex.ru/contest/24810/run-report/119607509/
 *  Принцип работы:
 *  Создаю макс.кучу просеиванием вниз
 *  Сортирую список
 *
 * siftDown - функция просеивания:
 * Находит левый и правый индекс, если левый индекс больше размера списка, тогда ф-ия прекращается
 *
 * Берется максимальный индекс: если правый существует - берем правый, если правого нет - берем левый.
 * Если родительский элемент меньше своих потомков - происходит смена мест этих елементов и рекурсивно вызывается
 * ф-ия siftDown
 *
 * Временная сложность:
 * Построение кучи - O(log n)
 * Сортировка - O(n log n).
 * Общая - O(n log n).
 *
 * Пространственная сложность - константная O(1), тк алгоритм не создает дополнительные структуры данных, а
 * модифицирует исходный массив
 * */

fun main() {
    val count = readln().toInt()
    val person = Array(count) {
        val (name, solvedTask, fine) = readln().split(" ")
        Person(
            name = name,
            solvedTask = solvedTask.toInt(),
            fine = fine.toInt()
        )
    }

    val memberComparator = compareByDescending<Person> { it.solvedTask }
        .thenBy { it.fine }
        .thenBy { it.name }

    person.heapSort(memberComparator)

    val result = person.joinToString("\n") { it.name }
    println(result)
}

fun <T> Array<T>.heapSort(comparator: Comparator<T>) {
    for (i in size / 2 downTo 0) {
        siftDown(comparator, i, size)
    }

    for (i in size - 1 downTo 1) {
        swap(0, i)
        siftDown(comparator, 0, i)
    }
}

fun <T> Array<T>.siftDown(comparator: Comparator<T>, start: Int, end: Int) {
    val left = 2 * start + 1
    val right = left + 1

    if (left >= end) return

    val largestIndex = if (right < end && comparator.compare(this[left], this[right]) < 0) right else left

    if (comparator.compare(this[start], this[largestIndex]) > 0) return
    swap(start, largestIndex)
    siftDown(comparator, largestIndex, end)
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

data class Person(
    val name: String,
    val solvedTask: Int,
    val fine: Int
)