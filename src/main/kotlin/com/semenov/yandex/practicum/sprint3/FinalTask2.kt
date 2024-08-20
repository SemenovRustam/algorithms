package com.semenov.yandex.practicum.sprint3

/**
https://contest.yandex.ru/contest/23815/run-report/117005096/

В данном алгоритме используется способ быстрой сортировки

Функция quicksort рекурсивно сортирует массив участников.
Массив делится на две части, используя функцию partition, и затем сортирует каждую часть отдельно.

Функция partition:
Выбирается опорный элемент - случайный участник.
Используются два указателя: left (изначально указывает на low) и right (изначально указывает на high).
Указатель left движется слева направо, пока не найдет элемент, который больше или равен pivot.
Указатель right движется справа налево, пока не найдет элемент, который меньше или равен pivot.

Участники сортируются в порядке убывания по решенным задачам.
Если кол-во задач одинаково, сортируется по кол-ву штрафа в порядке возрастания.
Если решенные задачи и кол-во штрафов одинаково, то участники сортируются по имени.

Доказательство корректности:

В начале каждого рекурсивного вызова quicksort массив делится на две группы: меньшие и большие или равные опорному элементу.
Если массив содержит 0 или 1 элемент, он считается отсортированным.
Если массив содержит более одного элемента, выполняется рекурсивный вызов quicksort для каждой группы.
Поскольку каждая группа меньше исходного массива, можем предположить, что каждая группа будет отсортирована после рекурсивного вызова.
Когда рекурсия завершается, массив будет отсортирован.

Средняя временная сложность O(n log n) достигается благодаря тому,
что алгоритм делит массив на две примерно равные части на каждой итерации.
В худшем случае, когда массив делится на очень неравные части,
временная сложность увеличивается до O(n^2).

Т.к. алгоритм использует рекурсию, пространственная сложность быстрой сортировки будет:

Средний случай: O(log n)
Худший случай: O(n)
 */

fun main() {
    val count = readln().toInt()

    val members = Array(count) {
        val (name, solvedTask, fine) = readln().split(" ")
        Member(
            name = name,
            solvedTask = solvedTask.toInt(),
            fine = fine.toInt()
        )
    }

    val memberComparator: Comparator<Member> = compareByDescending<Member> { it.solvedTask }
        .thenBy { it.fine }
        .thenBy { it.name }

    members.quicksort(0, members.lastIndex, memberComparator)

    val result = members.joinToString("\n") { it.name }
    println(result)
}

private fun <T> Array<T>.quicksort(low: Int, high: Int, comparator: Comparator<T>) {
    if (low < high) {
        val pivotIndex = this.partition(low, high, comparator)
        quicksort(low, pivotIndex - 1, comparator)
        quicksort(pivotIndex, high, comparator)
    }
}

private fun <T> Array<T>.partition(low: Int, high: Int, comparator: Comparator<T>): Int {
    val randomIndex = (low..high).random()
    val pivot = this[randomIndex]
    var left = low
    var right = high

    while (left < right) {
        while (comparator.compare(this[left], pivot) < 0) {
            left++
        }
        while (comparator.compare(this[right], pivot) > 0) {
            right--
        }

        swap(left, right)
    }

    return left
}

private fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

data class Member(
    val name: String,
    val solvedTask: Int,
    val fine: Int
)

/**

B. Эффективная быстрая сортировка

5
alla 4 100
gena 6 1000
gosha 2 90
rita 2 90
timofey 4 80

Вывод:

gena
timofey
alla
gosha
rita


5
alla 0 0
gena 0 0
gosha 0 0
rita 0 0
timofey 0 0

Вывод:

alla
gena
gosha
rita
timofey
 */