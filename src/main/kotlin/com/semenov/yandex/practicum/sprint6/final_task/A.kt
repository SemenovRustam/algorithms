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
    val vertices = PriorityQueue<Vertex> { a, b -> b.weight - a.weight }
    val graph = List(n) { mutableListOf<Vertex>() }

    repeat(m) {
        val (u, v, weight) = readln().split(" ").map { it.toInt() }
        graph[u - 1].add(Vertex(v, weight))
        graph[v - 1].add(Vertex(u, weight))
    }

    graph.getMaxMst(added, vertices)

    val result = if (addedCount < n) {
        FAILED_MESSAGE
    } else {
        maxSpanningTreeWeight
    }

    println(result)
}

private fun List<MutableList<Vertex>>.getMaxMst(added: BooleanArray, vertices: PriorityQueue<Vertex>) {
    addedVertex(1, added, vertices)
    while (addedCount < added.size - 1 && vertices.isNotEmpty()) {
        val maxEdge = vertices.poll()

        if (!added[maxEdge.v]) {
            maxSpanningTreeWeight += maxEdge.weight
            addedVertex(maxEdge.v, added, vertices)
        }
    }
}

private fun List<MutableList<Vertex>>.addedVertex(vertex: Int, added: BooleanArray, vertices: PriorityQueue<Vertex>) {
    added[vertex] = true
    ++addedCount
    this[vertex - 1].forEach {
        if (!added[it.v]) {
            vertices.add(it)
        }
    }
}

private data class Vertex(val v: Int, val weight: Int)
