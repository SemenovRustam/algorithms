package com.semenov.yandex.practicum.sprint6.final_task


import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val graphR = Array(n + 1) { mutableListOf<Int>() }
    val graphB = Array(n + 1) { mutableListOf<Int>() }

    for (i in 1 until n) {
        readln().toCharArray().forEachIndexed { index, char ->
            if (char == 'R') {
                graphR[i].add(index + i + 1)
            } else {
                graphB[i].add(index + i + 1)
            }
        }
    }

    if (isOptimalMap(n, graphR, graphB)) {
        println("YES")
    } else {
        println("NO")
    }
}

fun isOptimalMap(n: Int, graphR: Array<MutableList<Int>>, graphB: Array<MutableList<Int>>): Boolean {
    for (A in 1 until n) {
        for (B in A + 1..n) {
            if (canReach(A, B, graphR) && canReach(A, B, graphB)) {
                return false
            }
        }
    }
    return true
}

fun canReach(start: Int, end: Int, graph: Array<MutableList<Int>>): Boolean {
    val visited = BooleanArray(graph.size) { false }
    val planned = LinkedList<Int>()
    planned.add(start)
    visited[start] = true

    while (planned.isNotEmpty()) {
        val city = planned.poll()
        if (city == end) {
            return true
        }
        for (neighbor in graph[city]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                planned.add(neighbor)
            }
        }
    }
    return false
}


