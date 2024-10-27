package com.semenov.yandex.practicum.sprint7


private const val U = "U"
private const val R = "R"


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val matrix = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        readln().forEachIndexed { j, char ->
            matrix[i][j] = char.digitToInt()
        }
    }

    val (maxFlowers, path) = getMaxFlowersWithPath(matrix, n, m)
    println(maxFlowers)
    println(path)
}

fun getMaxFlowersWithPath(matrix: Array<IntArray>, n: Int, m: Int): Pair<Int, String> {
    val dp = Array(n) { IntArray(m) }
    val path = Array(n) { Array(m) { "" } } // Массив для отслеживания пути

    // Начальная точка (нижний левый угол)
    dp[n - 1][0] = matrix[n - 1][0]

    // Заполняем первую колонку
    for (i in n - 2 downTo 0) {
        dp[i][0] = dp[i + 1][0] + matrix[i][0]
        path[i][0] = U
    }

    // Заполняем первую строку
    for (j in 1 until m) {
        dp[n - 1][j] = dp[n - 1][j - 1] + matrix[n - 1][j]
        path[n - 1][j] = R
    }

    // Заполнение остальной части dp массива
    for (i in n - 2 downTo 0) {
        for (j in 1 until m) {
            if (dp[i + 1][j] > dp[i][j - 1]) {
                dp[i][j] = dp[i + 1][j] + matrix[i][j]
                path[i][j] = U
            } else {
                dp[i][j] = dp[i][j - 1] + matrix[i][j]
                path[i][j] = R
            }
        }
    }

    // Восстановление маршрута
    var i = 0
    var j = m - 1

    val route = buildString {
        while (i < n - 1 || j > 0) {
            if (path[i][j] == U) {
                append(U)
                ++i
            } else {
                append(R)
                --j
            }
        }
    }

    return Pair(dp[0][m - 1], route.reversed())
}

/**
I. Сложное поле с цветочками
Все языки	Python 3.11.4
Ограничение времени	1 секунда	2 секунды
Ограничение памяти	64Mb	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Теперь черепашке Кондратине надо узнать не только, сколько цветочков она может собрать,
но и как ей построить свой маршрут для этого. Помогите ей!

Напомним, что Кондратине надо дойти от левого нижнего до правого верхнего угла,
а передвигаться она умеет только вверх и вправо.

Формат ввода
В первой строке даны размеры поля n и m (через пробел). Оба числа лежат в диапазоне от 1 до 1000.
В следующих n строках задано поле. Каждая строка состоит из m символов 0 или 1 и завершается переводом строки.
Если в клетке записана единица, то в ней растет цветочек.

Формат вывода
Выведите в первой строке максимальное количество цветочков, которое сможет собрать Кондратина.
Во второй строке выведите маршрут в виде последовательности символов «U» и «R», где «U» означает передвижение вверх,
а «R» – передвижение вправо.

Если возможных оптимальных путей несколько, то выведите любой.

Пример 1
Ввод
2 3
101
110

Вывод
3
URR

Пример 2
Ввод
3 3
100
110
001

Вывод
2
UURR

 */