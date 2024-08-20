package com.semenov.yandex.practicum

import java.util.StringTokenizer


fun countPairsWithDiffLessOrEqual(mid: Int, arr: IntArray): Long {
    var count: Long = 0
    var left = 0
    val n = arr.size

    for (right in 1 until n) {
        while (arr[right] - arr[left] > mid) {
            ++left
        }
        count += (right - left).toLong()
    }

    return count
}

fun findKthMinDiff(arr: IntArray, k: Long): Int {
    arr.sort()

    var minDiff = 0
    var maxDiff = arr.last() - arr.first()

    while (minDiff < maxDiff) {
        val mid = (minDiff + maxDiff) / 2
        if (countPairsWithDiffLessOrEqual(mid, arr) >= k) {
            maxDiff = mid
        } else {
            minDiff = mid + 1
        }
    }

    return minDiff
}

fun main() {
    val arrSize = readln().toInt()
    val arrTokens = StringTokenizer(readln())
    val array = IntArray(arrSize) { arrTokens.nextToken().toInt() }

    val k = readln().toLong()

    val result = findKthMinDiff(array, k)
    println(result)
}

/**

Пример 1
Ввод
3
2 3 4
2
Вывод
1
Пример 2
Ввод
3
1 3 1
1
Вывод
0
Пример 3
Ввод
3
1 3 5
3
Вывод
4
 */

