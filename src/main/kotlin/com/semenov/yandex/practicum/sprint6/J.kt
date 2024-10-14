package com.semenov.yandex.practicum.sprint6


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = List(n + 1) { mutableListOf<Int>() }
    val colors = Array(n + 1) { Color.WHITE }
    val stack = mutableListOf<Int>()

    repeat(m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        graph[from].add(to)
    }

    // Perform topological sort
    for (i in 1..n) {
        if (colors[i] == Color.WHITE) {
            topologicalSort(graph, colors, i, stack)
        }
    }

    // Print the result
    println(stack.reversed().joinToString(" "))
}

fun topologicalSort(
    graph: List<MutableList<Int>>,
    colors: Array<Color>,
    v: Int,
    stack: MutableList<Int>
) {
    colors[v] = Color.GREY
    for (w in graph[v].sorted()) {
        if (colors[w] == Color.WHITE) {
            topologicalSort(graph, colors, w, stack)
        }
    }
    colors[v] = Color.BLACK
    stack.add(v) // Add to the beginning of the stack
}

/**
 * J. Топологическая сортировка
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.3 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.7 секунд	128Mb
OpenJDK Java 11	1 секунда	128Mb
C# (MS .NET 6.0 + ASP)	0.7 секунд	128Mb
Python 3.12.1	1 секунда	64Mb
Java 21 (Temurin JDK)	1 секунда	128Mb
Kotlin 1.8.0 (JRE 11)	1 секунда	128Mb
C# (MS .NET 5.0 + ASP)	0.7 секунд	128Mb
Дан ациклический ориентированный граф (так называемый DAG, directed acyclic graph).
Найдите его топологическую сортировку, то есть выведите его вершины в таком порядке,
что все рёбра графа идут слева направо. У графа может быть несколько подходящих перестановок вершин.
Вам надо найти любую топологическую сортировку.

Формат ввода
В первой строке даны два числа – количество вершин n (1 ≤ n ≤ 105) и количество рёбер m (0 ≤ m ≤ 105).
В каждой из следующих m строк описаны рёбра по одному на строке. Каждое ребро представлено парой вершин (from, to),
1≤ from, to ≤ n, соответственно номерами вершин начала и конца.

Формат вывода
Выведите номера вершин в требуемом порядке.

Пример 1
Ввод
5 3
3 2
3 4
2 5

Вывод
1 3 2 4 5

Пример 2
Ввод
6 3
6 4
4 1
5 1

Вывод
2 3 5 6 4 1

Пример 3
Ввод
4 0
Вывод
1 2 3 4
 * */