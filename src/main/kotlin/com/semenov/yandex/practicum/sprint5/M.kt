package com.semenov.yandex.practicum.sprint5

fun siftUp(heap: IntArray, idx: Int): Int {
    if (idx == 1) return idx

    val parentIndex = idx / 2

    if (heap[parentIndex] < heap[idx]) {
        val temp = heap[parentIndex]
        heap[parentIndex] = heap[idx]
        heap[idx] = temp
        return siftUp(heap, parentIndex)
    }
    return -1
}

fun main() {
    val sample = intArrayOf(-1, 12, 6, 8, 3, 15, 7)
    val siftUp = siftUp(sample, 5)
    println(siftUp)
    assert(siftUp == 1)
}