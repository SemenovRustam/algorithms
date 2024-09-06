package com.semenov.yandex.practicum.sprint4


fun main() {
    readln()
    val team1 = readln().split(" ").map { it.toInt() }.toIntArray()
    readln()
    val team2 = readln().split(" ").map { it.toInt() }.toIntArray()

    println(longestCommonSubarray(team1, team2))
}


fun longestCommonSubarray(team1: IntArray, team2: IntArray): Int {
    val n = team1.size
    val m = team2.size
    var dpPrev = IntArray(m + 1)
    var maxLength = 0

    for (i in 1..n) {
        val dpCurr = IntArray(m + 1)
        for (j in 1..m) {
            if (team1[i - 1] == team2[j - 1]) {
                dpCurr[j] = dpPrev[j - 1] + 1
                println(dpCurr.contentToString())
                maxLength = maxOf(maxLength, dpCurr[j])
            }
        }
        dpPrev = dpCurr
    }

    return maxLength
}
/**
В двух вложенных циклах ищу элементы, которые совпадают
Храню значения длины отрезков в двух массивах(текущий массив объявляю во внешнем цикле, другой массив объявляю вне циклов
При нахождении совпадений сравниваю значение максимальное длины и значение в моем массиве
 */