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