package com.semenov.yandex.practicum.sprint6.final_task


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
    for (i in 1 until n) {
        val visitedR = BooleanArray(n + 1)
        val visitedB = BooleanArray(n + 1)

        dfs(graphR, i, visitedR)
        dfs(graphB, i, visitedB)

        for (j in (i + 1)..n) {
            if (visitedR[j] && visitedB[j]) {
                return false
            }
        }
    }
    return true
}

fun dfs(graph: Array<MutableList<Int>>, start: Int, visited: BooleanArray) {
    visited[start] = true
    for (neighbor in graph[start]) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited)
        }
    }
}


