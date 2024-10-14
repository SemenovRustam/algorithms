package com.semenov.yandex.practicum.sprint6

private val result = mutableListOf<Int>()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    val start = readln().toInt()
    val colors = Array(n + 1) { Color.WHITE }

    dfs(start, graph, colors)
    println(result.joinToString(" "))
}

private fun dfs(start: Int, graph: List<List<Int>>, colors: Array<Color>) {
    colors[start] = Color.GREY
    result.add(start)
    for (w in graph[start].sorted()) {
        if (colors[w] == Color.WHITE) {
            dfs(w, graph, colors)
        }
    }
    colors[start] = Color.BLACK
}

enum class Color {
    WHITE,
    GREY,
    BLACK
}

/**
 * C. DFS
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1 секунда	256Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	2 секунды	256Mb
OpenJDK Java 11	2 секунды	256Mb
C# (MS .NET 6.0 + ASP)	2 секунды	256Mb
Python 3.12.1	2 секунды	128Mb
Java 21 (Temurin JDK)	2 секунды	256Mb
Kotlin 1.8.0 (JRE 11)	2 секунды	256Mb
C# (MS .NET 5.0 + ASP)	2 секунды	256Mb
Задан неориентированный граф. Обойдите с помощью DFS все вершины, достижимые из заданной вершины s,
и выведите их в порядке обхода, если начинать обход из s.

Формат ввода
В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 105). Далее в m строках описаны рёбра графа.
Каждое ребро описывается номерами двух вершин u и v (1 ≤ u, v ≤ n). В последней строке дан номер стартовой вершины
s (1 ≤ s ≤ n). В графе нет петель и кратных рёбер.

Формат вывода
Выведите вершины в порядке обхода, считая что при запуске от каждой конкретной вершины её соседи будут рассматриваться
в порядке возрастания (то есть если вершина 2 соединена с 1 и 3, то сначала обход пойдёт в 1, а уже потом в 3).

Пример 1
Ввод
4 4
3 2
4 3
1 4
1 2
3

Вывод
3 2 1 4

Пример 2
Ввод
2 1
1 2
1

Вывод
1 2
 * */