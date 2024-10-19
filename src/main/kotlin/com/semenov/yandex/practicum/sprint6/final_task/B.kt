package com.semenov.yandex.practicum.sprint6.final_task

import java.util.Stack

fun main() {
    val n = readln().toInt()
    val matrix = Array(n + 1) { mutableListOf<Int>() }
    val visited = Array(n + 1) { Color.WHITE }

    for (i in 1 until n) {
        readln().toCharArray().forEachIndexed { index, char ->
            val target = i + index + 1
            if (char == 'R') {
                matrix[i].add(target)
            } else {
                matrix[target].add(i)
            }
        }
    }

    val result = if (matrix.checkOptimal(visited, n)) "YES" else "NO"

    println(result)
}

fun Array<MutableList<Int>>.checkOptimal(visited: Array<Color>, n: Int): Boolean {
    for (i in 1..n) {
        val stack = Stack<Int>()
        stack.push(i)

        while (stack.isNotEmpty()) {
            val vertex = stack.peek()

            if (visited[vertex] == Color.WHITE) {
                visited[vertex] = Color.GRAY

                for (neighbor in this[vertex]) {
                    if (visited[neighbor] == Color.WHITE) {
                        stack.push(neighbor)
                    } else if (visited[neighbor] == Color.GRAY) {
                        return false
                    }
                }
            } else {
                visited[vertex] = Color.BLACK
                stack.pop()
            }
        }
    }

    return true
}

enum class Color {
    WHITE, GRAY, BLACK
}