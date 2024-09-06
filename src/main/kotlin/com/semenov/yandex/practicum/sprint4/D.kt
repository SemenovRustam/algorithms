package com.semenov.yandex.practicum.sprint4

fun main() {
    val base = readln().toLong()
    val module = readln().toLong()
    val string = readln()

    println(polynomialHash(base, module, string))
}

private fun polynomialHash(base: Long, module: Long, s: String): Long {
    var hashValue = 0L
    var currentPower = 1L // q^0 = 1
    val n = s.length

    // Идем по строке в обратном порядке
    for (i in n - 1 downTo 0) {
        val code = s[i].code
        val l = code * currentPower
        hashValue = (hashValue + l) % module
        // Убедитесь, что hashValue всегда положительный
        if (hashValue < 0) {
            hashValue += module
        }
        currentPower = (currentPower * base) % module
        // Убедитесь, что currentPower всегда положительный
        if (currentPower < 0) {
            currentPower += module
        }
    }

    return hashValue
}
/**
D. Полиномиальный хеш
Все языки	Python 3.11.4
Ограничение времени	0.5 секунд	0.65 секунд
Ограничение памяти	64Mb	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Алле очень понравился алгоритм вычисления полиномиального хеша.
Помогите ей написать функцию, вычисляющую хеш строки s.
В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.

Полиномиальный хеш считается по формуле:


Формат ввода
В первой строке дано число a (1 ≤ a ≤ 1000) –— основание, по которому считается хеш.

Во второй строке дано число m (1 ≤ m ≤ 109) –— модуль.

В третьей строке дана строка s (0 ≤ |s| ≤ 106), состоящая из больших и маленьких латинских букв.

Формат вывода
Выведите целое неотрицательное число –— хеш заданной строки.

Пример 1
Ввод
123
100003
a

Вывод
97

Пример 2
Ввод
123
100003
hash

Вывод
6080

Пример 3
Ввод
123
100003
HaSH

Вывод
56156
* */