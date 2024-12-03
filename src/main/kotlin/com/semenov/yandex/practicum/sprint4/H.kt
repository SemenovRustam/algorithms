package com.semenov.yandex.practicum.sprint4

fun main() {
    val s = readln()

    val maxUniqueLength = getMaxUniqueLength(s)
    println(maxUniqueLength)
}

fun getMaxUniqueLength(s: String): Int {
    val position = mutableMapOf<Char, Int>()
    var result = 0
    var prev = 0

    for (i in s.indices) {
        prev = maxOf(prev, position[s[i]] ?: 0)
        position[s[i]] = i + 1
        result = maxOf(result, i + 1 - prev)
    }

    return result
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