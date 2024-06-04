package com.semenov.yandex.practicum.sprint1

import kotlin.math.sqrt

fun main() {
    val number = readInt()
    val factorization = factorize(number)
    println(factorization.joinToString(" "))
}

private fun factorize(number: Int): List<Int> {
    val result = mutableListOf<Int>()
    var num = number
    if (isPrime(number)) {
        result.add(number)
    } else {
        var divider = 2
        while (num != 1) {
            if (num % divider == 0) {
                num /= divider
                result.add(divider)
                divider = 2
            } else {
                divider++
            }
        }
    }

    return result
}

private fun isPrime(n: Int): Boolean {
    // Проверка на простоту числа
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

private fun readStr() = readln()
private fun readInt() = readStr().toInt()


/**
 * J. Факторизация
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.052 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.4 секунды	64Mb
Python 3.7.3	0.2 секунды	64Mb
OpenJDK Java 11	0.4 секунды	64Mb
C# (MS .NET 6.0 + ASP)	0.4 секунды	64Mb
Python 3.12.1	0.2 секунды	64Mb
Java 21 (Temurin JDK)	0.4 секунды	64Mb
Kotlin 1.8.0 (JRE 11)	0.4 секунды	64Mb
C# (MS .NET 5.0 + ASP)	0.4 секунды	64Mb
Основная теорема арифметики говорит: любое число раскладывается на произведение простых множителей единственным образом, с точностью до их перестановки. Например:

Число 8 можно представить как 2 × 2 × 2.
Число 50 –— как 2 × 5 × 5 (или 5 × 5 × 2, или 5 × 2 × 5). Три варианта отличаются лишь порядком следования множителей.
Разложение числа на простые множители называется факторизацией числа.

Напишите программу, которая производит факторизацию переданного числа.

Формат ввода
В единственной строке дано число n (2 ≤ n ≤ 109), которое нужно факторизовать.

Формат вывода
Выведите в порядке неубывания простые множители, на которые раскладывается число n.

Пример 1
Ввод	Вывод
8       2 2 2

Пример 2
Ввод	Вывод
13      13

Пример 3
Ввод	Вывод
100     2 2 5 5
*/