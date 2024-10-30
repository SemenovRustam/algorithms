package com.semenov.yandex.practicum.sprint7

fun main() {
    // Чтение первой последовательности
    val n = readln().toInt()
    val firstSequence = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    // Чтение второй последовательности
    val m = readln().toInt()
    val secondSequence = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    // Вызов функции для нахождения НОП
    val (lcsLength, firstIndices, secondIndices) = findLCS(firstSequence, secondSequence)

    // Вывод результатов
    println(lcsLength) // Длина НОП
    println(firstIndices.joinToString(" ")) // Индексы из первой последовательности
    println(secondIndices.joinToString(" ")) // Индексы из второй последовательности
}

fun findLCS(firstSequence: IntArray, secondSequence: IntArray): Triple<Int, List<Int>, List<Int>> {
    val n = firstSequence.size
    val m = secondSequence.size

    // Создаем таблицу для хранения длин НОП
    val dp = Array(n + 1) { IntArray(m + 1) }
    val fromFirst = Array(n + 1) { IntArray(m + 1) }
    val fromSecond = Array(n + 1) { IntArray(m + 1) }

    // Заполняем таблицу
    for (i in 1..n) {
        for (j in 1..m) {
            if (firstSequence[i - 1] == secondSequence[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                fromFirst[i][j] = i - 1
                fromSecond[i][j] = j - 1
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j]
                    fromFirst[i][j] = i - 1
                    fromSecond[i][j] = j
                } else {
                    dp[i][j] = dp[i][j - 1]
                    fromFirst[i][j] = i
                    fromSecond[i][j] = j - 1
                }
            }
        }
    }

    // Длина НОП
    val lcsLength = dp[n][m]

    // Восстанавливаем НОП и индексы
    val firstIndices = mutableListOf<Int>()
    val secondIndices = mutableListOf<Int>()
    var i = n
    var j = m

    while (i > 0 && j > 0) {
        if (firstSequence[i - 1] == secondSequence[j - 1]) {
            firstIndices.add(i) // Добавляем индекс из первой последовательности
            secondIndices.add(j) // Добавляем индекс из второй последовательности
            i--
            j--
        } else if (dp[i - 1][j] >= dp[i][j - 1]) {
            i-- // Двигаемся вверх
        } else {
            j-- // Двигаемся влево
        }
    }

    firstIndices.reverse() // Переворачиваем, чтобы получить правильный порядок
    secondIndices.reverse() // Переворачиваем, чтобы получить правильный порядок

    return Triple(lcsLength, firstIndices, secondIndices)
}


