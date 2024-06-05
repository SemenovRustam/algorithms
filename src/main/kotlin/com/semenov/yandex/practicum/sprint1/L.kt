package com.semenov.yandex.practicum.sprint1

fun main() {
    val firstString = readln()
    val secondString = readln()
    val oddLetter = getOddLetter(firstString, secondString)
    println(oddLetter)

}

private fun getOddLetter(firstString: String, secondString: String): Char {
    val firstChars = firstString.toCharArray().sorted()
    val secondChars = secondString.toCharArray().sorted()

    for (index in secondChars.indices) {
        if (index == secondChars.lastIndex) {
            return secondChars[index]
        }
        if (firstChars[index] != secondChars[index]) {
            return secondChars[index]
        }
    }
    return firstChars[1]
}

/**
L. Лишняя буква
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt


Васе очень нравятся задачи про строки, поэтому он придумал свою. Есть 2 строки s и t, состоящие только из строчных букв.
Строка t получена перемешиванием букв строки s и добавлением 1 буквы в случайную позицию. Нужно найти добавленную букву.

Формат ввода
На вход подаются строки s и t, разделённые переносом строки. Длины строк не превосходят 1000 символов. Строки не бывают пустыми.

Формат вывода
Выведите лишнюю букву.

Пример 1
Ввод	Вывод
abcd    e
abcde

Пример 2
Ввод	Вывод
go      g
ogg

Пример 3
Ввод	Вывод
xtkpx   c
xkctpx

 */