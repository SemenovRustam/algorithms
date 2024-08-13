package com.semenov.yandex.practicum.sprint3

fun main() {
    val count = readln().toInt()
    val members = buildList {
        for (index in 0 until count) {
            val info = readln().split(" ")
            add(
                Member(
                    name = info[0],
                    solvedTask = info[1].toInt(),
                    fine = info[2].toInt()
                )
            )
        }
    }.toTypedArray()

    quicksort(members, 0, members.size - 1)

    members.forEach {
        println(it)
    }
}

fun quicksort(arr: Array<Member>, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quicksort(arr, low, pivotIndex - 1)
        quicksort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: Array<Member>, low: Int, high: Int): Int {
    val solvedTaskPivot = arr[high].solvedTask
    val finePivot = arr[high].fine
    var i = low - 1

    for (j in low until high) {
        if (arr[j].solvedTask > solvedTaskPivot) {
            i++
            swap(arr, i, j)
        } else if (arr[j].solvedTask == solvedTaskPivot) {
            if (arr[j].fine <= finePivot) {
                i++
                swap(arr, i, j)
            }
        }
    }
    swap(arr, i + 1, high)
    return i + 1
}

fun swap(arr: Array<Member>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

data class Member(
    val name: String,
    val solvedTask: Int,
    val fine: Int
) {
    override fun toString(): String {
        return "$name $solvedTask $fine"
    }
}

/**
5
alla 4 100
gena 6 1000
gosha 2 90
rita 2 90
timofey 4 80
 */