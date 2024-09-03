package com.semenov.yandex.practicum.sprint4

fun main() {
    val string = readln()

    println(getMaxLength(string))
}

private fun getMaxLength(string: String): Int {
    var start = 0
    var max = 0
    val lastIndex = mutableMapOf<Char, Int>()

    for (i in string.indices) {
        val char = string[i]

        if (char in lastIndex && lastIndex[char]!! >= start) {
            start = i + 1
        }

        lastIndex[char] = i
        max = maxOf(max, i - start + 1)
    }
    return max
}

/**

На вход подается строка. Нужно определить длину наибольшей подстроки, которая не содержит повторяющиеся символы.

Формат ввода
Одна строка, состоящая из строчных латинских букв. Длина строки не превосходит 10 000.

Формат вывода
Выведите натуральное число —– ответ на задачу.

Пример 1
Ввод
abcabcbb

Вывод
3

Пример 2
Ввод
bbbbb

Вывод
1
 */