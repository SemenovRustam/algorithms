package com.semenov.yandex.practicum.sprint1

/**
H. Двоичная система
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt


Тимофей записал два числа в двоичной системе счисления и попросил Гошу вывести их сумму, также в двоичной системе.
Встроенную в язык программирования возможность сложения двоичных чисел применять нельзя. Помогите Гоше решить задачу.

Решение должно работать за O(N), где N –— количество разрядов максимального числа на входе.

Формат ввода
Два числа в двоичной системе счисления, каждое на отдельной строке. Длина каждого числа не превосходит 10 000 символов.

Формат вывода
Одно число в двоичной системе счисления.

Пример 1
Ввод	Вывод
1010    10101
1011

Пример 2
Ввод	Вывод
1       10
1

 */

fun main() {
    val firstNumber = readln()
    val secondNumber = readln()
    println(getSum(firstNumber, secondNumber))
}

private fun getSum(firstNumber: String, secondNumber: String): String {
    val sb1 = StringBuilder(firstNumber)
    val sb2 = StringBuilder(secondNumber)
    val result = StringBuilder(firstNumber.length)

    align(firstNumber, secondNumber, sb2, sb1)

    var transfer = 0
    for (index in sb1.length - 1 downTo 0) {
        val int1 = sb1[index].digitToInt()
        val int2 = sb2[index].digitToInt()
        val bit = int1 + int2 + transfer

        transfer = if (bit == 2) {
            result.append(0)
            1
        } else if (bit > 2) {
            result.append(1)
            1
        } else {
            result.append(bit)
            0
        }
    }
    if (transfer == 1) {
        result.append(1)
    }

    return result.reverse().toString()
}

private fun align(
    firstNumber: String,
    secondNumber: String,
    sb2: StringBuilder,
    sb1: StringBuilder
) {
    if (firstNumber.length > secondNumber.length) {
        sb2.clear()
        val n = firstNumber.length - secondNumber.length
        sb2.append("0".repeat(n))
        sb2.append(secondNumber)
    } else if (secondNumber.length > firstNumber.length) {
        sb1.clear()
        sb1.append("0".repeat(secondNumber.length - firstNumber.length))
        sb1.append(firstNumber)
    }
}
