package com.semenov.yandex.practicum.sprint6


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = List(n + 1) { mutableListOf<Int>() }
    val colors = Array(n + 1) { Color.WHITE }
    val entry = IntArray(n + 1) { -1 }
    val leave = IntArray(n + 1) { -1 }
    var time = intArrayOf(0)

    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    dfsWithTime(graph, colors, 1, entry, leave, time)

    for (i in 1..n) {
        println("${entry[i]} ${leave[i]}")
    }
}

fun dfsWithTime(
    graph: List<MutableList<Int>>,
    colors: Array<Color>,
    v: Int,
    entry: IntArray,
    leave: IntArray,
    time: IntArray
) {
    entry[v] = time[0]++
    colors[v] = Color.GREY
    for (w in graph[v]) {
        if (colors[w] == Color.WHITE) {
            dfsWithTime(graph, colors, w, entry, leave, time)
        }
    }
    leave[v] = time[0]++
    colors[v] = Color.BLACK
}

/**
 * H. Время выходить
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1.5 секунд	128Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	4 секунды	128Mb
OpenJDK Java 11	2 секунды	128Mb
Python 3.12.1	2.5 секунд	128Mb
Java 21 (Temurin JDK)	2 секунды	128Mb
Kotlin 1.8.0 (JRE 11)	2 секунды	128Mb
Вам дан ориентированный граф. Известно, что все его вершины достижимы из вершины s=1. Найдите время входа и
выхода при обходе в глубину, производя первый запуск из вершины s.
Считайте, что время входа в стартовую вершину равно 0.
Соседей каждой вершины обходите в порядке увеличения номеров.

Формат ввода
В первой строке дано число вершин n (1 ≤ n ≤ 2⋅ 105) и рёбер (0 ≤ m ≤ 2 ⋅ 105). В каждой из следующих m строк записаны
рёбра графа в виде пар (from, to), 1 ≤ from ≤ n — начало ребра, 1 ≤ to ≤ n — его конец.
Гарантируется, что в графе нет петель и кратных рёбер.

Формат вывода
Выведите n строк, в каждой из которых записана пара чисел tini, touti — время входа и выхода для вершины i.

Пример 1
Ввод
6 8
2 6
1 6
3 1
2 5
4 3
3 2
1 2
1 4

Вывод
0 11
1 6
8 9
7 10
2 3
4 5

Пример 2
Ввод
3 2
1 2
2 3

Вывод
0 5
1 4
2 3
 */





