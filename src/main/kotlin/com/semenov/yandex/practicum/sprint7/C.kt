package com.semenov.yandex.practicum.sprint7

fun main() {
    val m = readln().toLong()
    val n = readln().toInt()

    val heaps = mutableListOf<GoldHeap>()
    repeat(n) {
        val (coast, volume) = readln().split(" ").map { it.toLong() }
        heaps.add(GoldHeap(coast, volume))
    }

    val maxSum = getMaxSum(m, heaps)

    println(maxSum)
}

fun getMaxSum(m: Long, heaps: List<GoldHeap>): Long {
    var result = 0L
    var freePlace = m
    val goldHeapsSorted = heaps.sortedWith(compareByDescending { it.coast })

    for (heap in goldHeapsSorted) {
        if (heap.weight <= freePlace) {
            freePlace -= heap.weight
            result += heap.weight * heap.coast
        } else {
            result += freePlace * heap.coast
            freePlace -= heap.weight - freePlace

            break
        }

    }

    return result
}


data class GoldHeap(val coast: Long, val weight: Long)

/**
 *C. Золотая лихорадка
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Гуляя по одному из островов Алгосского архипелага, Гоша набрёл на пещеру, в которой лежат кучи золотого песка.
К счастью, у Гоши есть с собой рюкзак грузоподъёмностью до M килограмм, поэтому он может унести
с собой какое-то ограниченное количество золота.

Всего золотых куч n штук, и все они разные. В куче под номером i содержится mi килограммов золотого песка,
а стоимость одного килограмма — ci алгосских франков.

Помогите Гоше наполнить рюкзак так, чтобы общая стоимость золотого песка в пересчёте на алгосские франки была максимальной.

Формат ввода
В первой строке задано целое число M — грузоподъёмность рюкзака Гоши (0 ≤ M ≤ 108).

Во второй строке дано количество куч с золотым песком — целое число n (1 ≤ n ≤ 105).

В каждой из следующих n строк описаны кучи: i-ая куча задаётся двумя целыми числами ci и mi,
записанными через пробел (1 ≤ ci ≤ 107, 1 ≤ mi ≤ 108).

Формат вывода
Выведите единственное число —– максимальную сумму (в алгосских франках), которую
Гоша сможет вынести из пещеры в своём рюкзаке.

Пример 1
Ввод
10
3
8 1
2 10
4 5

Вывод
36

Пример 2
Ввод
10000
1
4 20

Вывод
80
 */