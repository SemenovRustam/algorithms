package com.semenov.yandex.practicum.sprint6.final_task

/**
 * https://contest.yandex.ru/contest/25070/run-report/121585998/
 *
 * Принцип работы:
 * Считываю входные данные
 * Создаю граф: в зависимости от типа дороги создаю направленный граф
 *
 * Проверяю полученный граф на наличие циклов. Граф считается с циклом, если, при обходе в глубину, вершина указывает на
 * другую, уже посещенную вершину.
 * Суть задачи сводится к поиску наоличия цикла в графе.
 *
 * checkOptimal(visited: Array<Color>, n: Int) - обход в глубину:
 * В цикле: создается стек, для сохранения вершин, запланированных для обхода.
 * Добавляется вершина i - значение текущего цикла.
 * В цикле, пока стек не пуст, беру, но не удаляю вершину.
 *      Если текущая вершина не посещена - тогда помечаю ее посещенной.
 *          Проверяю все смежные вершины текущей вершины:
 *          Если смежная вершина - не обработана, помещаю в стек,
 *          иначе если вершина уже была посещена - это означает наличия цикла - завершаю работу алгоритма
 *      Иначе если вершина уже была посещена - помечаю ее обработанной и удаляю из стека.
 *
 *      Временная сложность: О(V + E) - dfs со списками смежности
 *      Пространственная сложность: О(V + E) тк использую списки смежности
 *      Использую массив для хранения цветов и списки смежноти = О(V + E) + 0(V) = О(2V + E) = О(V + E)
 *
 * */

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
        val planned = Stack<Int>()
        planned.push(i)

        while (planned.isNotEmpty()) {
            val vertex = planned.peek()

            if (visited[vertex] == Color.WHITE) {
                visited[vertex] = Color.GRAY

                for (neighbor in this[vertex]) {
                    if (visited[neighbor] == Color.WHITE) {
                        planned.push(neighbor)
                    } else if (visited[neighbor] == Color.GRAY) {
                        return false
                    }
                }
            } else {
                visited[vertex] = Color.BLACK
                planned.pop()
            }
        }
    }
    return true
}

enum class Color {
    WHITE, GRAY, BLACK
}