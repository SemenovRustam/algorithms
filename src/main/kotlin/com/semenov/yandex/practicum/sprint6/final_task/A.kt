package com.semenov.yandex.practicum.sprint6.final_task

/**
 * https://contest.yandex.ru/contest/25070/run-report/121708319/
 * Принцип работы:
 *
 * addedVertex(vertex: Int) - добавляет вершину в множество добавленных вершин,
 * удаляет из множества не добавленных вершин,
 * из графа по текущей вершине находит список инцидентных ребер,
 * фильтрует ребра, первая вершина которых входит в множество не добавленных,
 * добавляет такие ребра в очередь edges
 *
 * getMaxMst() - Из множества не добавленных в остов вершин берет первую,
 * вызывает метод addedVertex с данной вершиной.
 * В цикле, при условии, пока очередь не пуста и множество
 * ребер не пустое достает максимальное ребро из очереди.
 * Если начальная вершина этого ребра в множестве не добавленных ребер,
 * тогда добавляет это ребро в остов и вызывает с
 * начальное вершиной ребра функцию addedVertex.
 *
 * Временная сложность:
 * addedVertex() - добавление и удаление из - 0(1),
 * Фильтрация и добавление рёбер в edges: 0(E log V)
 *
 * getMaxMst():
 * 0(E log V) - тк алгоритм использует приоритетную очередь для хранения ребер,
 * исходящих из собранного множества остова
 *
 * Общая сложность - 0(E log V)
 *
 * Пространственная сложность:
 * Тк алгоритм  используeт память для хранения вершин и ребер, то пространственная сложность равна 0(V + E)
 *
 * */


import java.util.PriorityQueue


private var maxSpanningTreeWeight = 0
private var addedCount = 0
private const val FAILED_MESSAGE = "Oops! I did it again"

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val added = BooleanArray(n + 1) { false }
    val edges = PriorityQueue<Edge> { a, b -> b.weight - a.weight }
    val graph = List(n) { mutableListOf<Edge>() }

    repeat(m) {
        val (u, v, weight) = readln().split(" ").map { it.toInt() }
        graph[u - 1].add(Edge(u, v, weight))
        graph[v - 1].add(Edge(v, u, weight))
    }

    graph.getMaxMst(added, edges)

    val result = if (addedCount < n) {
        FAILED_MESSAGE
    } else {
        maxSpanningTreeWeight
    }

    println(result)
}

private fun List<MutableList<Edge>>.getMaxMst(added: BooleanArray, edges: PriorityQueue<Edge>) {
    addedVertex(1, added, edges)
    while (addedCount < added.size - 1 && edges.isNotEmpty()) {
        val maxEdge = edges.poll()

        if (!added[maxEdge.to]) {
            maxSpanningTreeWeight += maxEdge.weight
            addedVertex(maxEdge.to, added, edges)
        }
    }
}

private fun List<MutableList<Edge>>.addedVertex(vertex: Int, added: BooleanArray, edges: PriorityQueue<Edge>) {
    added[vertex] = true
    ++addedCount
    this[vertex - 1].forEach {
        if (!added[it.to]) {
            edges.add(it)
        }
    }
}

private data class Edge(val from: Int, val to: Int, val weight: Int)
