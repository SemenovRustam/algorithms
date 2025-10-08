package com.semenov.yandex.leetcode


/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * Дан неотсортированный массив целых чисел. Нужно найти длину наибольшей последовательности из идущих подряд чисел.
 *
 * Решение должно работать за O(N).
 *
 * Например:
 * Для [100,4,200,1,3,2] - Ответ 4. Это последовательность: [1, 2, 3, 4]
 *
 * Для [1,0,1,2] - Ответ 3. Это последовательно
 * сть: [0, 1, 2]
 *
 *
 */


fun main() {
    val intArrayOf = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)

    println(longestConsecutive(intArrayOf))
}

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val set = buildSet {
        for (i in nums) {
            add(i)
        }
    }

    var result = 1
    for (num in set) {
        if (!set.contains(num - 1)) {
            var current = num
            var currentLength = 1
            while (set.contains(current + 1)) {
                current++
                currentLength++
            }
            result = maxOf(currentLength, result)
        }
    }

    return result
}

/**
 * fun longestConsecutive(nums: IntArray): Int {
 *     if (nums.isEmpty()) return 0
 *     nums.sort()
 *
 *     var result = 1
 *     var currentSequence = 1
 *
 *     for (i in 1 until nums.size) {
 *         if (nums[i] == nums[i - 1]) continue
 *         if (nums[i] == nums[i - 1] + 1) {
 *             currentSequence++
 *         } else {
 *             currentSequence = 1
 *         }
 *         result = maxOf(result, currentSequence)
 *     }
 *
 *     return result
 * }
 * */

