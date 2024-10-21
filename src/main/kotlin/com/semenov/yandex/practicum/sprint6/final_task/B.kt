package com.semenov.yandex.practicum.sprint6.final_task

/**
 * https://contest.yandex.ru/contest/25070/run-report/121585998/
 *
 * Принцип работы:
 * Считываю входные данные
 * Создаю граф: в зависимости от типа дороги создаю направленный граф: Если тип дороги R создаю дорогу от А - B, если тип
 * дороги B, создаю дорогу от точки  B - A.
 *
 * Проверяю полученный граф на наличие циклов. Граф считается с циклом, если, при обходе в глубину, вершина указывает на
 * другую, уже посещенную вершину.
 * Суть задачи сводится к поиску наоличия цикла в графе.
 *    1 --R---> 2 ---R-> 3
 *    |                  |
 *    |                  |
 *    1<---------B-------3
 *
 *   3
 *   RB
 *   R
 *
 *   из города 1 до годоа 2 по дороге типа В
 *   из 2 до 3 по типу В
 *   и из 1 до 3 по типу R
 *
 *   при моей модификации:
 *   из 1 до 2 тип R
 *   из 2 до 3 тип R
 *   из 3 до 1 - тип в, что означает цикл
 *
 *   При N > 3:
 *   неоптимальный граф - в один город можем добраться по двум типам дорог,
 *   если используем  прямое и обратное направление - получается цикл
 *
 * checkOptimal(visited: Array<Color>, n: Int) - обход в глубину:
 * В цикле: создается стек, для сохранения вершин, запланированных для обхода.
 * Добавляется вершина i - значение текущего цикла.
 * В цикле, пока стек не пуст, беру, но не удаляю вершину.
 *  Если текущая вершина не посещена - тогда помечаю ее посещенной.
 *  Проверяю все смежные вершины текущей вершины:
 *  Если смежная вершина - не обработана, помещаю в стек,
 *  иначе если вершина уже была посещена - это означает наличия цикла - завершаю работу алгоритма
 *  Иначе если вершина уже была посещена - помечаю ее обработанной и удаляю из стека.
 *
 *  Временная сложность: О(V^2), так как граф полный
 *  Пространственная сложность: О(V + E) -> O(V + V^2) = O(V^2) тк использую списки смежности
 *  Использую массив для хранения цветов и списки смежноти = О(V + E) + 0(V) = О(2V + E) = О(V + E)
 *
 * */

import java.util.Stack

fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { mutableListOf<Int>() }
    val visited = Array(n) { Color.WHITE }

    for (i in 1 until n) {
        readln().forEachIndexed { index, char ->
            val target = i + index + 1
            if (char == 'R') {
                matrix[i - 1].add(target)
            } else {
                matrix[target - 1].add(i)
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

            if (visited[vertex - 1] == Color.WHITE) {
                visited[vertex - 1] = Color.GRAY

                for (neighbor in this[vertex - 1]) {
                    if (visited[neighbor - 1] == Color.WHITE) {
                        planned.push(neighbor)
                    } else if (visited[neighbor - 1] == Color.GRAY) {
                        return false
                    }
                }
            } else {
                visited[vertex - 1] = Color.BLACK
                planned.pop()
            }
        }
    }
    return true
}

enum class Color {
    WHITE, GRAY, BLACK
}