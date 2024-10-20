package com.semenov.yandex.practicum.sprint6.final_task

/**
 * https://contest.yandex.ru/contest/25070/run-report/121708319/
 * Принцип работы:
 *
 * Инициализация:
 * Считываем количество вершин n и количество рёбер m.
 * Создаем булев массив added для отслеживания добавленных в дерево вершин.
 * Создаем приоритетную очередь edges для хранения рёбер, отсортированных по убыванию весов.
 * Создаем граф graph в виде списка смежности.
 *
 * Загрузка графа:
 * Считываем рёбра и добавляем их в граф в обе стороны (так как граф неориентированный).
 *
 * Начало построения MST:
 * Добавляем первую вершину (например, вершину 1) в дерево.
 * Добавляем все исходящие рёбра из этой вершины в приоритетную очередь.
 *
 * Построение MST:
 * Пока не все вершины добавлены в дерево и очередь рёбер не пуста:
 * Извлекаем ребро с наибольшим весом из приоритетной очереди.
 * Если конечная вершина этого ребра ещё не добавлена в дерево:
 * Добавляем вес этого ребра к общему весу MST.
 * Добавляем конечную вершину в дерево.
 * Добавляем все исходящие рёбра из этой вершины в приоритетную очередь.
 *
 * Проверка на связность:
 * Если количество добавленных вершин меньше общего количества вершин, граф не является связным, и возвращаем сообщение об ошибке.
 * Иначе возвращаем общий вес MST.
 *
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
 * Док-во корректности:
 * Ребра всегда сортируются по убыванию, что гарантирует, что мы всегда берем самое большое ребро из кучи.
 * Ребра берутся только те, которые не образуют цикл, это гарантирует, что мы полуаем дерево и оно остовное
 * Тк мы всегда берем ребра с наибольшим весом, гарантирует, что это будет максимальное остовное дерево
 *
 * Временная сложность:
 * addedVertex() - добавление и удаление из - 0(1),
 * Фильтрация и добавление рёбер в edges: 0(E log V)
 *
 * getMaxMst():
 * 0(V log E) - тк алгоритм использует приоритетную очередь для хранения ребер,
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
