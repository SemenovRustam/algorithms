package com.semenov.yandex.practicum.sprint3

fun quicksort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quicksort(arr, low, pivotIndex - 1)
        quicksort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            swap(arr, i, j)
        }
    }
    swap(arr, i + 1, high)
    return i + 1
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}


fun main() {
    val arr = intArrayOf(10, 7, 8, 9, 1, 5)
    println("Исходный массив: ${arr.joinToString(", ")}")
    quicksort(arr, 0, arr.size - 1)
    println("Отсортированный массив: ${arr.joinToString(", ")}")
}