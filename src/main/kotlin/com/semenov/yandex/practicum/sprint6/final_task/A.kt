package com.semenov.yandex.practicum.sprint6.final_task


import java.util.*

private val added = mutableSetOf<Int>()  // Множество вершин, уже добавленных в остов.
private val notAdded = mutableSetOf<Int>()  // Множество вершин, ещё не добавленных в остов.
private val edges = PriorityQueue<Pair<Int, Int>> { a, b -> b.second - a.second }
private val minimumSpanningTree = mutableListOf<Pair<Int, Int>>()  // Массив рёбер, входящих в MST.
private val input = readln().split(" ").map { it.toInt() }
private val n = input[0]
private val m = input[1]
private val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }  // Граф в виде списка смежности.

fun main() {
    repeat(m) {
        val (u, v, weight) = readln().split(" ").map { it.toInt() }
        graph[u].add(v to weight)
        graph[v].add(u to weight)
        notAdded.add(u)
        notAdded.add(v)
    }


    if (notAdded.isEmpty()) {
        println("Oops! I did it again")
        return
    }
    getMaxMst()

    val result = if (notAdded.isNotEmpty()) {
        "Oops! I did it again"
    } else {
        minimumSpanningTree.sumOf { it.second }.toString()
    }

    println(result)
}

private fun getMaxMst() {
    val v = notAdded.first()
    addedVertex(v)

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
