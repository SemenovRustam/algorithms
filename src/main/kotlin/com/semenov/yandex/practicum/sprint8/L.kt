package com.semenov.yandex.practicum.sprint8

fun main() {
    val text = readln()

    val result = getPrefixIndecies(text)

    println(result.joinToString(" "))
}

fun getPrefixIndecies(s: String): IntArray {
    val n = s.length
    val pi = IntArray(n)

    for (i in 1 until n) {
        var k = pi[i - 1]

        while (k > 0 && s[k] != s[i]) {
            k = pi[k - 1]
        }

        if (s[i] == s[k]) {
            k++
        }
        pi[i] = k
    }

    return pi
}

/**
 * L. Подсчёт префикс-функции
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1 секунда	128Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Swift 5.8.1	0.4 секунды	64Mb
GNU GCC 13.1 C++20	0.4 секунды	64Mb
Python 3.11.4	1.6 секунд	128Mb
GNU c++17 7.3	0.4 секунды	64Mb
В этой задаче вам необходимо посчитать префикс-функцию для заданной строки.

Формат ввода
На вход подаётся строка, состоящая из строчных латинских букв. Длина строки не превосходит 106.

Формат вывода
Если длина входной строки L, то выведите через пробел L целых неотрицательных чисел —– массив
значений префикс-функции исходной строки.

Пример 1
Ввод
abracadabra

Вывод
0 0 0 1 0 1 0 1 2 3 4

Пример 2
Ввод
xxzzxxz

Вывод
0 1 0 0 1 2 3

Пример 3
Ввод
aaaaa

Вывод
0 1 2 3 4
*/
