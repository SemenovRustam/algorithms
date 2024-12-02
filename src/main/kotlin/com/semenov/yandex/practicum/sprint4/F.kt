package com.semenov.yandex.practicum.sprint4


val base = readln().toLong()
val module = readln().toLong()
val string = readln()
val hash = LongArray(string.length + 1)
val powers = LongArray(string.length + 1)

fun main() {
    val countsInterval = readln().toInt()
    powers[0] = 1

    for (i in string.indices) {
        hash[i + 1] = (hash[i] * base + string[i].code) % module
        powers[i + 1] = (powers[i] * base) % module
    }

    repeat(countsInterval) {
        val (start, end) = readln().split(" ").map(String::toInt)
        println(prefixHash(start, end))
    }
}

fun prefixHash(start: Int, end: Int): Long {
    val startIndex = start - 1
    return (hash[end] - (hash[startIndex] * powers[end - startIndex]) % module + module) % module
}

/**
F. Префиксные хеши

Алла не остановилась на достигнутом –— теперь она хочет научиться быстро вычислять хеши
произвольных подстрок данной строки. Помогите ей!

На вход поступают запросы на подсчёт хешей разных подстрок. Ответ на каждый запрос должен выполняться за O(1).
Допустимо в начале работы программы сделать предподсчёт для дальнейшей работы со строкой.

Напомним, что полиномиальный хеш считается по формуле



В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.

Формат ввода
В первой строке дано число a (1 ≤ a ≤ 1000) –— основание, по которому считается хеш.
Во второй строке дано число m (1 ≤ m ≤ 107) –— модуль. В третьей строке дана строка s (0 ≤ |s| ≤ 106),
состоящая из больших и маленьких латинских букв.

В четвертой строке дано число запросов t –— натуральное число от 1 до 105.
В каждой из следующих t строк записаны через пробел два числа l и r –— индексы начала и конца очередной подстроки. (1 ≤ l ≤ r ≤ |s|).

Формат вывода
Для каждого запроса выведите на отдельной строке хеш заданной в запросе подстроки.

Пример 1
Ввод
1000
1000009
abcdefgh
7
1 1
1 5
2 3
3 4
4 4
1 8
5 8

Вывод
97
225076
98099
99100
100
436420
193195

Пример 2
Ввод
100
10
a
1
1 1

Вывод
7
 */