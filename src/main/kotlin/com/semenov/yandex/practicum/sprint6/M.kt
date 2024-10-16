package com.semenov.yandex.practicum.sprint6

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val colors = MutableList(n + 1) { Color.WHITE }

    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    val result = if (isBipartite(graph, colors, n)) "YES" else "NO"
    println(result)
}

fun isBipartite(graph: Array<MutableList<Int>>, colors: MutableList<Color>, n: Int): Boolean {

    fun dfs(vertex: Int, color: Color): Boolean {
        colors[vertex] = color

        for (neighbor in graph[vertex]) {
            if (colors[neighbor] == color) return false

            if (colors[neighbor] == Color.WHITE && !dfs(neighbor, if (color == Color.BLACK) Color.GREY else Color.BLACK)) {
                return false
            }
        }
        return true
    }

    for (vertex in 0 until n) {
        if (colors[vertex] == Color.WHITE) {
            if (!dfs(vertex, Color.BLACK)) {
                return false
            }
        }
    }
    return true
}

/**
 * M. Проверка на двудольность
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1 секунда	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
OpenJDK Java 11	2 секунды	128Mb
C# (MS .NET 6.0 + ASP)	1 секунда	128Mb
Java 21 (Temurin JDK)	2 секунды	128Mb
Kotlin 1.8.0 (JRE 11)	2 секунды	128Mb
C# (MS .NET 5.0 + ASP)	1 секунда	128Mb
Немножко теории...

Определение: неориентированный граф называется двудольным (англ. bipartite), если его вершины можно разбить
на два непересекающихся множества таким образом, что рёбра будут проведены только между вершинами из разных множеств.
Эти два множества вершин ещё называют долями.

На рисунке ниже вершины первой доли покрашены в голубой цвет, а второй доли – в красный.

Гоша узнал, что двудольными могут быть не только графы, но и растения (например, сирень).
Теперь он в них путается и не может проверить граф на двудольность без мыслей о цветочках.
Помогите Гоше: проверьте, является ли заданный неориентированный граф двудольным.

Формат ввода
В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 105).
В каждой из следующих m строк записано по ребру в виде пары вершин 1 ≤ u, v ≤ n.

Гарантируется, что в графе нет петель и кратных рёбер.

Формат вывода
Выведите «YES», если граф является двудольным, и «NO» в ином случае.

Пример 1
Ввод
3 2
1 2
2 3

Вывод
YES

Пример 2
Ввод
3 3
1 2
2 3
1 3

Вывод
NO
*/
