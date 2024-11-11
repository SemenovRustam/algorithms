package com.semenov.yandex.practicum.sprint8


fun main() {
    val text = readln()
    val pattern = readln()
    val newPattern = readln()

    val result = text.globalReplaced(pattern, newPattern)

    println(result)
}

fun String.globalReplaced(pattern: String, newPattern: String): String {
    val sb = StringBuilder(this)
    val n = pattern.length
    val pi = IntArray(n) { 0 }
    val s = "$pattern#$this"
    var kPrev = 0
    var diff = 0

    for (i in 1 until s.length) {
        var k = kPrev

        while (k > 0 && s[i] != s[k]) {
            k = pi[k - 1]
        }
        if (s[i] == s[k]) {
            k++
        }

        kPrev = k

        if (k == n) {
            val index = i - 2 * n + diff
            sb.replace(index, index + n, newPattern)
            diff += newPattern.length - pattern.length
        }
    }
    return sb.toString()
}
/**
 * H. Глобальная замена
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Напишите программу, которая будет заменять в тексте все вхождения строки s на строку t.
Гарантируется, что никакие два вхождения шаблона s не пересекаются друг с другом.

Формат ввода
В первой строке дан текст —– это строка из строчных букв английского алфавита, длина которой не превышает 106.

Во второй строке записан шаблон s, вхождения которого будут заменены.

В третьей строке дана строка t, которая будет заменять вхождения.

Обе строки s и t состоят из строчных букв английского алфавита, длина каждой строки не превосходит 105.
Размер итоговой строки не превосходит 2⋅ 106.

Формат вывода
В единственной строке выведите результат всех замен — текст, в котором все вхождения s заменены на t.

Пример 1
Ввод
pingpong
ng
mpi

Вывод
pimpipompi

Пример 2
Ввод
aaa
a
ab

Вывод
ababab
*/

