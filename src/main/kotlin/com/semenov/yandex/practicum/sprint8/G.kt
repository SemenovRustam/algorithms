package com.semenov.yandex.practicum.sprint8

fun main() {
    readln()
    val text = readln().split(" ").map { it.toInt() }
    readln()
    val pattern = readln().split(" ").map { it.toInt() }

    val result = findAll(text, pattern).joinToString(" ")
    println(result)
}

fun findAll(text: List<Int>, pattern: List<Int>) = buildList {
    var start = 0
    while (true) {
        val pos = shiftSearch(text, pattern, start)
        if (pos == -1) break

        add(pos + 1)
        start = pos + 1
    }
}

private fun shiftSearch(text: List<Int>, pattern: List<Int>, startIndex: Int): Int {
    if (pattern.size > text.size) return -1

    for (pos in startIndex..text.size - pattern.size) {
        var shift = 0
        var match = true
        for (offset in pattern.indices) {
            if (offset == 0) {
                shift = text[pos + offset] - pattern[offset]
            } else {
                val difference = text[pos + offset] - pattern[offset]
                if (difference != shift) {
                    match = false
                    break
                }
            }
        }
        if (match) return pos
    }
    return -1
}

/**
 * G. Поиск со сдвигом
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1.5 секунд	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Swift 5.8.1	0.2 секунды	64Mb
GNU GCC 13.1 C++20	0.15 секунд	64Mb
GNU c++17 7.3	0.15 секунд	64Mb
Python 3.11.4	3 секунды	64Mb
Гоша измерял температуру воздуха n дней подряд. В результате у него получился некоторый временной ряд.
Теперь он хочет посмотреть, как часто встречается некоторый шаблон в получившейся последовательности.
Однако температура — вещь относительная, поэтому Гоша решил,
что при поиске шаблона длины m (a1, a2, ..., am) стоит также рассматривать сдвинутые на константу вхождения. Это значит,
что если для некоторого числа c в исходной последовательности нашёлся участок вида (a1 + c, a2 + c, ... , am + c),
то он тоже считается вхождением шаблона (a1, a2, ..., am).
По заданной последовательности измерений X и шаблону A=(a1, a2, ..., am) определите все вхождения A в X,
допускающие сдвиг на константу.
Подсказка: если вы пишете на питоне и сталкиваетесь с TL, то попробуйте заменить какие-то из циклов операциями со срезами.

Формат ввода
В первой строке дано количество сделанных измерений n — натуральное число, не превышающее 104.
Во второй строке через пробел записаны n целых чисел xi, 0 ≤ xi ≤ 103 –— результаты измерений.
В третьей строке дано натуральное число m –— длина искомого шаблона, 1≤ m ≤ n.
В четвёртой строке даны m целых чисел ai — элементы шаблона, 0 ≤ ai ≤ 103.

Формат вывода
Выведите через пробел в порядке возрастания все позиции,
на которых начинаются вхождения шаблона A в последовательность X.
Нумерация позиций начинается с единицы.

Пример 1
Ввод
9
3 9 1 2 5 10 9 1 7
2
4 10

Вывод
1 8
Пример 2
Ввод
5
1 2 3 4 5
3
10 11 12

Вывод
1 2 3
 */





































