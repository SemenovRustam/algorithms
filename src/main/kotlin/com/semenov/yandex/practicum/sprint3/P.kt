package com.semenov.yandex.practicum.sprint3

fun main() {
    val count = readln().toInt()
    val digits = readln().split(" ").map { it.toInt() }

    println(getMaxBlockCount(digits))

}

fun getMaxBlockCount(digits: List<Int>): Int {
    var min = 0
    var max = 0
    var count = 0

    for (digit in digits) {
        if (digit > max) {
            max = digit
        }
        if (digit == min) {
            min = max + 1
            count++
        }
    }

    return count
}

/**
 *
 *
 *
 *
 *
24
12 1 8 0 7 17 2 20 9 19 18 6 14 21 10 4 23 5 3 15 13 11 22 16
Вывод программы
2
Правильный ответ
1


5
1 0 2 3 4

4
0 1 3 2

Вывод
3



8
3 6 7 4 1 5 0 2

output
1
 */