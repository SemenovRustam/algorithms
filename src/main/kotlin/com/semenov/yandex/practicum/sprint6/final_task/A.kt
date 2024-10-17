package com.semenov.yandex.practicum.sprint6.final_task

/**
 * https://contest.yandex.ru/contest/25070/run-report/121322618/
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
 * Фильтрация и добавление рёбер в edges: 0(n log m)
 *
 * getMaxMst():
 * 0(E log V) - тк алгоритм использует приоритетную очередь для хранения ребер,
 * исходящих из собранного множества остова
 *
 * Общая сложность - 0(E log V)
 *
 * Пространственная сложность:
 * Тк алгоритм  используут память для хранения вершин и ребер, то пространственная сложность равна 0(e + m)
 *
 * */


import java.util.*

private val added = mutableSetOf<Int>()
private val notAdded = mutableSetOf<Int>()
private val edges = PriorityQueue<Pair<Int, Int>> { a, b -> b.second - a.second }
private val minimumSpanningTree = mutableListOf<Pair<Int, Int>>()
private val input = readln().split(" ").map { it.toInt() }
private val n = input[0]
private val m = input[1]
private val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }
private const val FAILED_MESSAGE = "Oops! I did it again"

fun main() {
    repeat(m) {
        val (u, v, weight) = readln().split(" ").map { it.toInt() }
        graph[u].add(v to weight)
        graph[v].add(u to weight)
        notAdded.add(u)
        notAdded.add(v)
    }

    if (n > 1 && m == 0) {
        println(FAILED_MESSAGE)
        return
    }
    if (m == 0) {
        println(m)
        return
    }

    if (notAdded.isEmpty()) {
        println(FAILED_MESSAGE)
        return
    }

    getMaxMst()

    val result = if (notAdded.isNotEmpty()) {
        FAILED_MESSAGE
    } else {
        minimumSpanningTree.sumOf { it.second }
    }

    println(result)
}

private fun getMaxMst() {
    val vertex = notAdded.first()
    addedVertex(vertex)

    while (notAdded.isNotEmpty() && edges.isNotEmpty()) {
        val maxEdge = edges.poll()

        if (maxEdge.first in notAdded) {
            minimumSpanningTree.add(maxEdge)
            addedVertex(maxEdge.first)
        }
    }
}

private fun addedVertex(vertex: Int) {
    added += vertex
    notAdded -= vertex
    graph[vertex].filter { it.first in notAdded }.forEach { edges.add(it) }
}
