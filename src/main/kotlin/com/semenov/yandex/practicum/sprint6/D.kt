package com.semenov.yandex.practicum.sprint6

import java.util.LinkedList

private val result = mutableListOf<Int>()

fun main() {
    val (v, m) = readln().split(" ").map { it.toInt() }
    val colors = MutableList<Color>(v + 1) { Color.WHITE }
    val graph = List(v + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    val start = readln().toInt()

    bfs(graph, colors, start)
    println(result.joinToString(" "))
}

private fun bfs(graph: List<MutableList<Int>>, colors: MutableList<Color>, s: Int) {
    val planned = LinkedList<Int>()
    planned.add(s)
    result.add(s)
    colors[s] = Color.GREY

    while (planned.isNotEmpty()) {
        val u = planned.poll()
        for (w in graph[u].sorted()) {
            if (colors[w] == Color.WHITE) {
                planned.add(w)
                colors[w] = Color.GREY
                result.add(w)
            }
        }
        colors[s] = Color.BLACK
    }
}

/**
 * D. BFS
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.7 секунд	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	2.1 секунда	256Mb
OpenJDK Java 11	1.5 секунд	256Mb
C# (MS .NET 6.0 + ASP)	1.5 секунд	256Mb
Python 3.12.1	1.5 секунд	64Mb
Java 21 (Temurin JDK)	1.5 секунд	256Mb
Kotlin 1.8.0 (JRE 11)	1.5 секунд	256Mb
C# (MS .NET 5.0 + ASP)	1.5 секунд	256Mb
Задан неориентированный граф. Обойдите поиском в ширину все вершины, достижимые из заданной вершины s,
и выведите их в порядке обхода, если начинать обход из s.

Формат ввода
В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 105). Далее в m строках описаны рёбра графа.
Каждое ребро описывается номерами двух вершин u и v (1 ≤ u, v ≤ n).
В последней строке дан номер стартовой вершины s (1 ≤ s ≤ n).

Гарантируется, что в графе нет петель и кратных рёбер.

Формат вывода
Выведите вершины в порядке обхода, считая что при запуске от каждой конкретной вершины её соседи будут рассматриваться
в порядке возрастания (то есть если вершина 2 соединена с 1 и 3, то сначала обход пойдёт в 1, а уже потом в 3).

Пример 1
Ввод
4 4
1 2
2 3
3 4
1 4
3

Вывод
3 2 4 1

Пример 2
Ввод
2 1
2 1
1

Вывод
1 2
*/