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
    val visited = Array(n + 1) { 0 } // 0 - не посещен, 1 - посещен по R, 2 - посещен по B

    for (i in 1 until n) {
        if (visited[i] == 0) {
            if (!dfs(graphR, i, visited, 1) || !dfs(graphB, i, visited, 2)) {
                return false
            }
        }
    }
    return true
}

fun dfs(graph: Array<MutableList<Int>>, start: Int, visited: Array<Int>, type: Int): Boolean {
    visited[start] = type
    for (neighbor in graph[start]) {
        if (visited[neighbor] == 0) {
            if (!dfs(graph, neighbor, visited, type)) {
                return false }
        } else if (visited[neighbor] != type) {
            // Если сосед уже был посещен другим типом дороги
            return false
        }
    }
    return true
}