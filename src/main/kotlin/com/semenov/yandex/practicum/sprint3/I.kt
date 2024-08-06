package com.semenov.yandex.practicum.sprint3

fun main() {
    readln().toInt()
    val ids = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()

    val result = getPopularUniversities(ids, k)

    println(result.joinToString(" "))
}

private fun getPopularUniversities(ids: List<Int>, k: Int): List<Int> {
    val frequencyMap = ids.groupingBy { it }.eachCount()

    return frequencyMap.entries
        .sortedWith(compareByDescending<Map.Entry<Int, Int>> { it.value }.thenBy { it.key })
        .take(k)
        .map { it.key }
}

/**
На IT-конференции присутствовали студенты из разных вузов со всей страны.
Для каждого студента известен ID университета, в котором он учится.

Тимофей предложил Рите выяснить, из каких k вузов на конференцию пришло больше всего учащихся.

Формат ввода
В первой строке дано количество студентов в списке —– n (1 ≤ n ≤ 15 000).

Во второй строке через пробел записаны n целых чисел —– ID вуза каждого студента.
Каждое из чисел находится в диапазоне от 0 до 10 000.

В третьей строке записано одно число k.

Формат вывода
Выведите через пробел k ID вузов с максимальным числом участников.
Они должны быть отсортированы по убыванию популярности (по количеству гостей от конкретного вуза).
Если более одного вуза имеет одно и то же количество учащихся, то выводить их ID нужно в порядке возрастания.

Пример 1
Ввод
7
1 2 3 1 2 3 4
3

Вывод
1 2 3


Пример 2
Ввод
6
1 1 1 2 2 3
1

Вывод
1

* */