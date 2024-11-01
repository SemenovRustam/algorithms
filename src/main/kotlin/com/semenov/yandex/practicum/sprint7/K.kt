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

/**
 * K. Гороскопы
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.3 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
OpenJDK Java 11	0.5 секунд	64Mb
Python 3.12.1	2 секунды	64Mb
Java 21 (Temurin JDK)	0.5 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	0.5 секунд	64Mb
В мире последовательностей нет гороскопов. Поэтому когда две последовательности хотят понять,
могут ли они счастливо жить вместе, они оценивают свою совместимость как длину их наибольшей общей подпоследовательности.

Подпоследовательность получается из последовательности удалением некоторого (возможно, нулевого) числа элементов.
То есть элементы сохраняют свой относительный порядок, но не обязаны изначально идти подряд.

Найдите наибольшую общую подпоследовательность двух одиноких последовательностей и выведите её!

Формат ввода
В первой строке дано число n — количество элементов в первой последовательности (1 ≤ n ≤ 1000).
Во второй строке даны n чисел ai (0 ≤ |ai| ≤ 109) — элементы первой последовательности.
Аналогично в третьей строке дано m (1 ≤ m ≤ 1000) — число элементов второй последовательности.
В четвертой строке даны элементы второй последовательности через пробел bi (0 ≤ |bi| ≤ 109).

Формат вывода
Сначала выведите длину найденной наибольшей общей подпоследовательности, во второй строке выведите индексы элементов
первой последовательности, которые в ней участвуют, в третьей строке — индексы элементов второй последовательности.
Нумерация индексов с единицы, индексы должны идти в корректном порядке.

Если возможных НОП несколько, то выведите любую.

Пример 1
Ввод
5
4 9 2 4 6
7
9 4 0 0 2 8 4

Вывод
3
1 3 4
2 5 7

Пример 2
Ввод
4
1 1 1 1
2
2 2

Вывод
0

Пример 3
Ввод
8
1 2 1 9 1 2 1 9
5
9 9 1 9 9

Вывод
3
3 4 8
3 4 5
 * */
