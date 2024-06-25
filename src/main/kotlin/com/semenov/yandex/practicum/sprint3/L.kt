package com.semenov.yandex.practicum.sprint3


fun main() {
    readln().toInt() // Прочитать количество элементов (не используется)
    val money = readln().split(" ").map(String::toInt)
    val coast = readln().toInt()

    val day1 = getHappyDays(money, coast, 0, money.size)
        ?.let { it + 1 }
        ?: -1
    val day2 = getHappyDays(money, 2 * coast, 0, money.size)
        ?.let { it + 1 }
        ?: -1

    println("$day1 $day2")
}

private fun getHappyDays(
    array: List<Int>,
    target: Int,
    left: Int,
    right: Int
): Int? {
    if (left >= right) {
        return null // Если диапазон поиска пуст, возвращаем -1
    }
    val mid = left + (right - left) / 2
    val midValue = array[mid]

    return when {
        midValue >= target -> {
            // Если значение в середине больше или равно искомому, проверяем, не является ли оно первым таким значением
            if (mid == left || array[mid - 1] < target) {
                mid // Нашли первое значение, большее или равное искомому
            } else {
                getHappyDays(array, target, left, mid) // Идем влево
            }
        }

        else -> getHappyDays(array, target, mid + 1, right) // Идем вправо
    }
}

/**
Ввод
6
1 2 4 4 6 8
3

Вывод
3 5

Ввод
6
1 2 4 4 4 4
3

Вывод
3 -1

Ввод
6
1 2 4 4 4 4
10

Вывод
-1 -1

Ввод
7
1 1 4 4 4 4 8
4

Вывод
3 7

 */