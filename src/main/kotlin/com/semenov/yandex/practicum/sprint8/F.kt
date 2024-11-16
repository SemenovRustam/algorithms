package com.semenov.yandex.practicum.sprint8

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val frequencyMap = HashMap<String, Int>()

    for (i in 0 until n) {
        val word = reader.readLine()
        frequencyMap[word] = frequencyMap.getOrDefault(word, 0) + 1
    }

    var maxFrequency = 0
    var resultWord = ""

    for ((word, frequency) in frequencyMap) {
        if (frequency > maxFrequency || (frequency == maxFrequency && word < resultWord)) {
            maxFrequency = frequency
            resultWord = word
        }
    }

    println(resultWord)
}