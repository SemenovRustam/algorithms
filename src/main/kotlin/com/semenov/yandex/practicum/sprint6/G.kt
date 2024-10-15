package com.semenov.yandex.practicum.sprint6

import java.util.*


private val split = readln().split(" ").map { it.toInt() }
private val n = split[0]
private val m = split[1]
private val distance = MutableList(n + 1) { -1 }
private val previous = MutableList(n + 1) { -1 }

fun main() {
    val colors = MutableList(n + 1) { Color.WHITE }
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    val start = readln().toInt()


    bfsWithDistance(graph, colors, start)

    println(distance.max())

}

fun bfsWithDistance(graph: List<MutableList<Int>>, colors: MutableList<Color>, start: Int) {
    val planned = LinkedList<Int>()
    planned.add(start)
    colors[start] = Color.GREY
    distance[start] = 0

    while (planned.isNotEmpty()) {
        val u = planned.poll()
        for (v in graph[u]) {
            if (colors[v] == Color.WHITE) {
                distance[v] = distance[u] + 1
                previous[v] = u
                planned.add(v)
                colors[v] = Color.GREY
            }
        }
        colors[u] = Color.BLACK
    }
}

/**
 * G. Максимальное расстояние
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.5 секунд	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.7 секунд	128Mb
OpenJDK Java 11	1.5 секунд	256Mb
C# (MS .NET 6.0 + ASP)	1 секунда	256Mb
Python 3.12.1	1 секунда	64Mb
Java 21 (Temurin JDK)	1.5 секунд	256Mb
Kotlin 1.8.0 (JRE 11)	1.5 секунд	256Mb
C# (MS .NET 5.0 + ASP)	1 секунда	256Mb
Под расстоянием между двумя вершинами в графе будем понимать длину кратчайшего пути между ними в рёбрах.
Для данной вершины s определите максимальное расстояние от неё до другой вершины неориентированного графа.

Формат ввода
В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 105). Далее в m строках описаны рёбра графа.
Каждое ребро описывается номерами двух вершин u и v (1 ≤ u, v ≤ n). В последней строке дан номер вершины s (1 ≤ s ≤ n).
Гарантируется, что граф связный и что в нём нет петель и кратных рёбер.

Формат вывода
Выведите длину наибольшего пути от s до одной из вершин графа.

Пример 1
Ввод
5 4
2 1
4 5
4 3
3 2
2

Вывод
3

Пример 2
Ввод
3 3
3 1
1 2
2 3
1

Вывод
1

Пример 3
Ввод
6 8
6 1
1 3
5 1
3 5
3 4
6 5
5 2
6 2
4

Вывод
3
 */