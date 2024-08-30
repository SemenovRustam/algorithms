package com.semenov.yandex.practicum.sprint4

import java.util.*

fun main() {
    val count = readln().toInt()
    if (count == 0) {
        println(count)
        return
    }

    val target = readln().toInt()
    val tokenizer = StringTokenizer(readln())
    val ints = LongArray(count) { tokenizer.nextToken().toLong() }

    val duplex = getDuplex(target, ints)
        .sortedWith(Comparator { list1, list2 ->
            for (i in list1.indices) {
                if (i >= list2.size) return@Comparator 1
                val cmp = list1[i].compareTo(list2[i])
                if (cmp != 0) return@Comparator cmp
            }
            list1.size.compareTo(list2.size)
        })


    println(duplex.size)
    for (list in duplex) {
        println(list.joinToString(" "))
    }
}


fun getDuplex(target: Int, nums: LongArray): Set<List<Long>> {
    val sumInfo = mutableMapOf<Long, MutableList<Pair<Int, Int>>>()
    val duplex = mutableSetOf<List<Long>>()

    for (i in nums.indices) {
        for (j in (i + 1) until nums.size) {
            val localTarget = target - nums[i] - nums[j]
            if (sumInfo.containsKey(localTarget)) {
                val pairs = sumInfo[localTarget]!!
                for ((first, second) in pairs) {
                    if (first != i && first != j && second != i && second != j) {
                        duplex.add(
                            listOf(nums[first], nums[second], nums[i], nums[j]).sorted()
                        )
                    }
                }
            }
            sumInfo.computeIfAbsent(nums[i] + nums[j]) { mutableListOf() }.add(Pair(i, j))
        }
    }

    return duplex
}

/**
 *
8
10
2 3 2 4 1 10 3 0
 *
 * */