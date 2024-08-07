package com.semenov.yandex.practicum.sprint3

fun main() {
    test()
}

fun merge(arr: IntArray, left: Int, mid: Int, right: Int): IntArray {
    val leftArr = arr.copyOfRange(left, mid)
    val rightArr = arr.copyOfRange(mid, right)

    var i = 0
    var j = 0
    var k = left

    while (i < leftArr.size && j < rightArr.size) {
        arr[k] = if (leftArr[i] <= rightArr[j]) {
            leftArr[i]
                .also { i++ }
        } else {
            rightArr[j]
                .also { j++ }
        }
        k++
    }

    while (i < leftArr.size) {
        arr[k] = leftArr[i]
        k++
        i++
    }

    while (j < rightArr.size) {
        arr[k] = rightArr[j]
        k++
        j++
    }

    return arr
}

fun merge_sort(arr: IntArray, left: Int, right: Int) {
    if (left < right - 1) {
        val mid = (left + right) / 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid, right)
        merge(arr, left, mid, right)
    }
}

fun test() {
    val a = intArrayOf(1, 4, 9, 2, 10, 11)
    val b: IntArray = merge(a, 0, 3, 6)
    val expected = intArrayOf(1, 2, 4, 9, 10, 11)
    assert(b.contentEquals(expected))
    val c = intArrayOf(1, 4, 2, 10, 1, 2)
    merge_sort(c, 0, 6)
    val expected2 = intArrayOf(1, 1, 2, 2, 4, 10)
    assert(c.contentEquals(expected2))
}

