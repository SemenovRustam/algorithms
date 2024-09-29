package com.semenov.yandex.practicum.sprint5


fun siftDown(heap: IntArray, idx: Int): Int {
    val left = idx * 2
    val right = idx * 2 + 1

    if (left >= heap.size) return idx

    val indexLargest = if (right < heap.size && heap[right] > heap[left]) right else left

    if (heap[indexLargest] > heap[idx]) {
        val temp = heap[indexLargest]
        heap[indexLargest] = heap[idx]
        heap[idx] = temp
        return siftDown(heap, indexLargest)
    }

    return idx
}


fun main() {
    val sample = intArrayOf(-1, 12, 1, 8, 3, 4, 7)
    val siftDown = siftDown(sample, 2)
    println(siftDown)
    assert(siftDown == 5)
}