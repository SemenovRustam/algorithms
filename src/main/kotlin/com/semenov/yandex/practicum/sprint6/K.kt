package com.semenov.yandex.practicum.sprint6

private val split = readln().split(" ").map { it.toInt() }
private val n = split[0]
private val m = split[1]
val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }


fun main() {
    val matrix = MutableList(n) { MutableList(n) { -1 } }

    repeat(m) {
        val (u, v, distance) = readln().split(" ").map { it.toInt() }
        graph[u].add(v to distance)
        graph[v].add(u to distance) 
    }

    for (v in 1..n) {
        dijkstra(v, matrix)
    }

    val result = buildString {
        for (i in 0 until n) {
            for (j in 0 until n) {
                append("${matrix[i][j]} ")
            }
            appendLine()
        }
    }

    println(result)
}

fun dijkstra(v: Int, matrix: MutableList<MutableList<Int>>) {
    val distance = MutableList(n + 1) { Int.MAX_VALUE }
    val previous = MutableList<Int?>(n + 1) { null }
    val visited = BooleanArray(n + 1) { false }
    distance[v] = 0

    while (true) {
        val u = getMinDistNotVisitedVertex(distance, visited) ?: break

        visited[u] = true

        for ((neighbor, weight) in graph[u]) {
            relax(u, neighbor, distance, weight, previous)
        }
    }

    for (i in 1..n) {
        matrix[v - 1][i - 1] = if (distance[i] == Int.MAX_VALUE) -1 else distance[i]
    }
}


private fun relax(u: Int, neighbor: Int, distance: MutableList<Int>, weight: Int, previous: MutableList<Int?>) {
    if (distance[neighbor] > distance[u] + weight) {
        distance[neighbor] = distance[u] + weight
        previous[neighbor] = u
    }
}


private fun getMinDistNotVisitedVertex(distance: MutableList<Int>, visited: BooleanArray): Int? {
    var currentMin = Int.MAX_VALUE
    var currentMinVertex: Int? = null

    for (v in 1..n) {
        if (!visited[v] && distance[v] < currentMin) {
            currentMin = distance[v]
            currentMinVertex = v
        }
    }
    return currentMinVertex
}

/**
 *K. Достопримечательности
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.1 секунда	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.3 секунды	64Mb
OpenJDK Java 11	0.5 секунд	64Mb
C# (MS .NET 6.0 + ASP)	0.3 секунды	64Mb
Python 3.12.1	1.5 секунд	64Mb
Java 21 (Temurin JDK)	0.5 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	0.5 секунд	64Mb
C# (MS .NET 5.0 + ASP)	0.3 секунды	64Mb
Вы приехали на архипелаг Алгосы (наконец-то!). Здесь есть n достопримечательностей. Ваша лодка может высадить
вас у одной из них, забрать у какой-то другой, возможно, той же самой достопримечательности и увезти на материк.

Чтобы более тщательно спланировать свой маршрут, вы хотите узнать расстояния между каждой парой достопримечательностей
Алгосов. Некоторые из них соединены мостами, по которым вы можете передвигаться в любую сторону. Всего мостов m.

Есть вероятность, что карта архипелага устроена так, что нельзя добраться от какой-то одной достопримечательности
до другой без использования лодки.

Найдите кратчайшие расстояния между всеми парами достопримечательностей.

Формат ввода
В первой строке даны числа n (1 ≤ n ≤ 100) и m (0 ≤ m ≤ n (n-1)/2). В следующих m строках описаны мосты.
Каждый мост задаётся номерами двух достопримечательностей 1 ≤ u, v ≤ n и длиной дороги 1 ≤ L ≤ 103.

Формат вывода
Выведите матрицу n × n кратчайших расстояний. На пересечении i-й строки и j-го столбца должно стоять расстояние
от i-й до j-й достопримечательности. Если между какой-то парой нет пути, то в соответствующей клетке поставьте -1.

Пример 1
Ввод
4 4
1 2 1
2 3 3
3 4 5
1 4 2

Вывод
0 1 4 2
1 0 3 3
4 3 0 5
2 3 5 0

Пример 2
Ввод
3 2
1 2 1
1 2 2

Вывод
0 1 -1
1 0 -1
-1 -1 0


Пример 3
Ввод
2 0
Вывод
0 -1
-1 0
 * */