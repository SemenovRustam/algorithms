package com.semenov.yandex.practicum.sprint1

fun main() {
    val n = readInt()
    val digits = readInts()
    val k = readInt()
    val result = longAdd(digits, k, n)
    println(result.joinToString(" "))
}

private fun longAdd(digits: List<Int>, k: Int, digitsLength: Int): List<Int> {
    val listDigits1 = digits.toMutableList()
    val listDigits2 = k.toString()
        .map { it.digitToInt() }
        .toMutableList()

    if (listDigits2.size > digitsLength) {
        while (listDigits1.size != listDigits2.size) {
            listDigits1.add(0, 0)

        }
    } else if (listDigits2.size < digitsLength) {
        while (listDigits2.size != listDigits1.size) {
            listDigits2.add(0, 0)
        }
    }

    var trasfer = 0
    val result = mutableListOf<Int>()

    for (index in listDigits1.size - 1 downTo 0) {
        val sum = listDigits1[index] + listDigits2[index] + trasfer

        if (sum >= 10) {
            val sumString = sum.toString()
            trasfer = sumString[0].digitToInt()
            result.add(sumString[1].digitToInt())
        } else {
            trasfer = 0
            result.add(sum)
        }
    }

    if (trasfer != 0) {
        result.add(trasfer)
    }

    return result.reversed()

}

private fun readStr() = readln()
private fun readInt() = readStr().toInt()
private fun readStrings() = readStr().split(" ")
private fun readInts() = readStrings().map { it.toInt() }


/**
 * K. Списочная форма
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt


Вася просил Аллу помочь решить задачу. На этот раз по информатике.

Для неотрицательного целого числа X списочная форма –— это массив его цифр слева направо.
К примеру, для 1231 списочная форма будет [1,2,3,1]. На вход подается количество цифр числа Х,
списочная форма неотрицательного числа Х и неотрицательное число K. Число К не превосходят 10000.
Длина числа Х не превосходит 1000.

Нужно вернуть списочную форму числа X + K.

Не используйте встроенные средства языка для сложения длинных чисел.

Формат ввода
В первой строке — длина списочной формы числа X. На следующей строке — сама списочная форма с цифрами записанными через пробел.

В последней строке записано число K, 0 ≤ K ≤ 10000.

Формат вывода
Выведите списочную форму числа X+K.

Пример 1
Ввод	    Вывод
4           1 2 3 4
1 2 0 0
34

Пример 2
Ввод	    Вывод
2           1 1 2
9 5
17
 */