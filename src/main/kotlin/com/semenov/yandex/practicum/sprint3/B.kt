package com.semenov.yandex.practicum.sprint3

fun main() {
    val digits = readln()
    val combinations = getCombinations(digits)
    val result = combinations.joinToString(" ")
    println(result)
}

private fun getCombinations(digits: String) = buildList {
    if (digits.isEmpty()) return@buildList

    fun backtrack(combination: StringBuilder, nextIndex: Int) {
        if (nextIndex == digits.length) {
            add(combination.toString())
            return
        }

        val digit = digits[nextIndex]
        val letters = phoneMap[digit]
        if (letters != null) {
            for (letter in letters) {
                combination.append(letter)
                backtrack(combination, nextIndex + 1)
                combination.deleteCharAt(nextIndex)
            }
        }
    }

    backtrack(StringBuilder(), 0)
}

private val phoneMap = mapOf(
    '2' to "abc",
    '3' to "def",
    '4' to "ghi",
    '5' to "jkl",
    '6' to "mno",
    '7' to "pqrs",
    '8' to "tuv",
    '9' to "wxyz"
)


/**
 * B. Комбинации
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
На клавиатуре старых мобильных телефонов каждой цифре соответствовало несколько букв. Примерно так:

2:'abc',
3:'def',
4:'ghi',
5:'jkl',
6:'mno',
7:'pqrs',
8:'tuv',
9:'wxyz'

Вам известно в каком порядке были нажаты кнопки телефона, без учета повторов.
Напечатайте все комбинации букв, которые можно набрать такой последовательностью нажатий.

Формат ввода
На вход подается строка, состоящая из цифр 2-9 включительно. Длина строки не превосходит 10 символов.

Формат вывода
Выведите все возможные комбинации букв через пробел в лексикографическом (алфавитном) порядке по возрастанию.

Пример 1
Ввод
23

Вывод
ad ae af bd be bf cd ce cf

Пример 2
Ввод
92

Вывод
wa wb wc xa xb xc ya yb yc za zb zc

*/

