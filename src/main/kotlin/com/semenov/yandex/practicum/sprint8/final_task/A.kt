package com.semenov.yandex.practicum.sprint8.final_task


/**
 * https://contest.yandex.ru/contest/26133/run-report/125821730/
 *
 *  Принцип работы:
 *  unpack() - распаковывает строку.
 *  Итерируется по символам: если число, кладем в стек чисел, если буква, записываем в текущую строку,
 *  если открывающаяся скобка, берет строку, которую необходимо распаковать, путем рекурсивного вызова метода распаковки,
 *  достается множитель и ранее полученную строку добавляем в текущую n-ое кол-во раз
 *  если закрывающаяся скобка - возвращаем текущую строку.
 *
 *  getMaxPrefix - инициализируем первым словом из списка строк две переменные first & last - самая первая и последняя
 *  строки по лексикографическому значению из данного списка, далее посимвольно сравниваем эти строки, находим крайний индекс
 *  общего префикса этих строк, возвращаем от первой строки подстроку от 0 до индекса - что и будет искомым результатом.
 *
 *  Временная сложность:
 *  unpack - O(m), m - длина строки
 *  getMaxPrefix - 0(n + L) - первый  цикл проходит по списку слов, второй цикл проходит по строке до первого несовпадения
 *  символов
 *  Общая: 0(n)
 *
 *  Пространственная сложность:
 *  unpack() - использует стек и стрингбилдер О(m) + О(m) = O(m)
 *  getMaxPrefix() - использует две переменные для хранения префикса = O(m)
 *  main() - хранит список строк O(n * m)
 *  Общая O(n * m)
 * */


fun main() {
    val n = readln().toInt()
    val words = List(n) { getUnpackString(readln()) }

    val maxPrefix = getMaxPrefix(words)

    println(maxPrefix)
}

fun getMaxPrefix(strings: List<String>): String {
    val first = strings.minBy { it }
    val last = strings.maxBy { it }

    var index = 0
    for (i in first.indices) {
        if (first[i] != last[i]) break
        index++
    }

    return first.substring(0 until index)
}

private fun getUnpackString(s: String) = buildString {
    s.unpack(this)
}


private fun String.unpack(accumulator: StringBuilder, startIndex: Int = 0): Int {
    var index = startIndex
    var multiplier = 0

    while (index < this.length) {
        val char = this[index]
        index++

        when {
            char.isDigit() -> multiplier = char.digitToInt()
            char.isLetter() -> accumulator.append(char)
            char == '[' -> {
                val nestedStartIndex = accumulator.length
                index = this.unpack(accumulator, index)

                val repeatedSegment = accumulator.substring(nestedStartIndex, accumulator.length)
                repeat(multiplier - 1) {
                    accumulator.append(repeatedSegment)
                }
            }

            char == ']' -> return index
        }
    }
    return index
}