package com.semenov.yandex.practicum.sprint2

import java.math.BigDecimal
import java.util.*

fun findLastKDigits(n: Int, k: Int): Int {
    val fibSequence = mutableListOf(BigDecimal(1), BigDecimal(1))
    for (i in 2..n) {
        fibSequence.add(fibSequence[i - 1] + fibSequence[i - 2])
    }
    val stringValue = fibSequence[n].toString()
    if (stringValue.length < k) {
        return stringValue.toInt()
    }
    val lastKDigits = stringValue.substring(stringValue.length - k)
    return lastKDigits.toInt()
}


fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()
    val findLastKDigits = findLastKDigits(n, k)
    println(findLastKDigits)
}