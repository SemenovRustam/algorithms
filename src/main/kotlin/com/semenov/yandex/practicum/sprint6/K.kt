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
        graph[v].add(u to distance) // Since the graph is undirected
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


fun relax(u: Int, v: Int, distance: MutableList<Int>, weight: Int, previous: MutableList<Int?>) {
    if (distance[v] > distance[u] + weight) {
        distance[v] = distance[u] + weight
        previous[v] = u
    }
}


fun getMinDistNotVisitedVertex(distance: MutableList<Int>, visited: BooleanArray): Int? {
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