package com.semenov.yandex.practicum.sprint3

fun main() {
    readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toIntArray()

    val sortedArr = sortForMaxValue(arr)

    val maxNum = buildString {
        sortedArr.forEach {
            append(it)
        }
    }

    println(maxNum)
}

private fun sortForMaxValue(arr: IntArray): IntArray {
    for (i in 1 until arr.size) {
        val element = arr[i]
        var j = i

        while (j > 0 && checkMaxValue(element, arr[j - 1])) {
            arr[j] = arr[j - 1]
            j--
        }
        arr[j] = element
    }

    return arr
}

private fun checkMaxValue(first: Int, second: Int): Boolean {
    val digit1 = first.toString()
    val digit2 = second.toString()

    return digit1 + digit2 > digit2 + digit1
}

/**
Вечером ребята решили поиграть в игру «Большое число».
Даны числа. Нужно определить, какое самое большое число можно из них составить.

Формат ввода
В первой строке записано n — количество чисел. Оно не превосходит 100.
Во второй строке через пробел записаны n неотрицательных чисел, каждое из которых не превосходит 1000.

Формат вывода
Нужно вывести самое большое число, которое можно составить из данных чисел.

Пример 1
Ввод
3
15 56 2

Вывод
56215

Пример 2
Ввод
3
1 783 2

Вывод
78321
Пример 3

Ввод
5
2 4 5 2 10

Вывод
542210

 */


