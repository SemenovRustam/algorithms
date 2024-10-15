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
    val (start, end) = readln().split(" ").map { it.toInt() }

    bfs(start, graph, colors)

    println(distance[end] - distance[start])
}

private fun bfs(start: Int, graph: List<MutableList<Int>>, colors: MutableList<Color>) {
    val planned = LinkedList<Int>()
    planned.add(start)
    colors[start] = Color.GREY
    distance[start] = 0

    while (planned.isNotEmpty()) {
        val u = planned.poll()
        for (w in graph[u]) {
            if (colors[w] == Color.WHITE) {
                planned.add(w)
                distance[w] = distance[u] + 1
                previous[w] = u
                colors[w] = Color.GREY
            }
        }
        colors[u] = Color.BLACK
    }
}

/**
 * F. Расстояние между вершинами
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.2 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.6 секунд	128Mb
OpenJDK Java 11	0.7 секунд	128Mb
C# (MS .NET 6.0 + ASP)	0.6 секунд	128Mb
Python 3.12.1	1 секунда	64Mb
Java 21 (Temurin JDK)	0.7 секунд	128Mb
Kotlin 1.8.0 (JRE 11)	0.7 секунд	127Mb
C# (MS .NET 5.0 + ASP)	0.6 секунд	128Mb
Найдите кратчайшее расстояние между парой вершин в неориентированном графе. Граф может быть несвязным.

Формат ввода
В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (1 ≤ m ≤ 105).
Далее в m строках описаны рёбра графа. Каждое ребро описывается номерами двух вершин u и v (1 ≤ u, v ≤ n).
В последней строке дан номер стартовой вершины s (1 ≤ s ≤ n) и конечной t (1 ≤ t ≤ n).
Гарантируется, что в графе нет петель и кратных рёбер.

Формат вывода
Выведите длину кратчайшего пути (в рёбрах) между заданной парой вершин.
Если пути не существует, то выведите -1.

Пример 1
Ввод
5 5
2 4
3 5
2 1
2 3
4 5
1 5

Вывод
3

Пример 2
Ввод
4 3
2 3
4 3
2 4
1 3

Вывод
-1

Пример 3
Ввод
2 1
2 1
1 1

Вывод
0
 */