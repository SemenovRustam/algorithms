package com.semenov.yandex.practicum.sprint3


fun main() {
    val a = intArrayOf(1, 4, 9, 2, 10, 11)
    val b: IntArray = merge(a, 0, 3, 6)
    val expected = intArrayOf(1, 2, 4, 9, 10, 11)
    println(b.contentToString())
    assert(b.contentEquals(expected))
    val c = intArrayOf(1, 4, 2, 10, 1, 2)
    merge_sort(c, 0, 6)
    println(c.contentToString())
    val expected2 = intArrayOf(1, 1, 2, 2, 4, 10)
    assert(c.contentEquals(expected2))
}


fun merge(arr: IntArray, left: Int, mid: Int, right: Int): IntArray {
    val leftArr = arr.copyOfRange(left, mid)
    val rightArr = arr.copyOfRange(mid, right)


    var i = 0
    var j = 0
    var k = left

    while (i < leftArr.size && j < leftArr.size) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i]
            i++
        } else {
            arr[k] = rightArr[j]
            j++
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
        // Рекурсивно сортируем левую половину
        merge_sort(arr, left, mid)
        // Рекурсивно сортируем правую половину
        merge_sort(arr, mid, right)
        // Сливаем две отсортированные половины
        merge(arr, left, mid, right)
    }
}

