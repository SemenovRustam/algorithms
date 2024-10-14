package com.semenov.yandex.practicum.sprint6

private var componentCount = 1
private const val NOT_COLOR = -1
private val relations = mutableMapOf<Int, MutableList<Int>>()


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val colors = MutableList(n + 1) { NOT_COLOR }
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }


    for (i in 1..n) {
        if (colors[i] == NOT_COLOR) {
            dfs(graph, colors, i, componentCount)
            componentCount++
        }
    }

    println(relations.keys.size)
    val result = buildString {
        for (index in 1 until componentCount) {
            appendLine(relations[index]?.sorted()?.joinToString(" "))
        }
    }
    println(result)
}

private fun dfs(graph: List<MutableList<Int>>, colors: MutableList<Int>, v: Int, componentCount: Int) {
    colors[v] = componentCount
    for (w in graph[v]) {
        if (colors[w] == NOT_COLOR) {
            dfs(graph, colors, w, componentCount)
        }
    }
    relations.computeIfAbsent(componentCount) { mutableListOf() }.add(v)
}

/**
 * E. Компоненты связности
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.5 секунд	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	1 секунда	128Mb
OpenJDK Java 11	1.5 секунд	128Mb
C# (MS .NET 6.0 + ASP)	1 секунда	128Mb
Python 3.12.1	1.5 секунд	64Mb
Java 21 (Temurin JDK)	1.5 секунд	128Mb
Kotlin 1.8.0 (JRE 11)	1.5 секунд	128Mb
C# (MS .NET 5.0 + ASP)	1 секунда	128Mb
Вам дан неориентированный граф. Найдите его компоненты связности.

Формат ввода
В первой строке дано количество вершин n (1≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 2 ⋅ 105). В каждой из следующих m строк
записано по ребру в виде пары вершин 1 ≤ u, v ≤ n.

Гарантируется, что в графе нет петель и кратных рёбер.

Формат вывода
Выведите все компоненты связности в следующем формате: в первой строке выведите общее количество компонент.

Затем на отдельных строках выведите вершины каждой компоненты, отсортированные по возрастанию номеров.
Компоненты между собой упорядочивайте по номеру первой вершины.

Пример 1
Ввод
6 3
1 2
6 5
2 3

Вывод
3
1 2 3
4
5 6

Пример 2
Ввод
2 0
2

Вывод
1
2

Пример 3
Ввод
4 3
2 3
2 1
4 3

Вывод
1
1 2 3 4
 */
