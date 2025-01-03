package com.semenov.yandex.practicum.sprint8

import kotlin.math.absoluteValue

fun main() {
    val s1 = readln()
    val s2 = readln()

    val result = if (isValidData(s1, s2)) "OK" else "FAIL"
    println(result)
}

fun isValidData(s1: String, s2: String): Boolean {
    if ((s1.length - s2.length).absoluteValue > 1) return false
    var count = 0

    if (s1.length == s2.length) {
        for (i in s1.indices) {
            if (s1[i] != s2[i]) ++count
            if (count > 1) return false
        }
    } else {
        var (more, less) = s1.getStringByDescending(s2)
        for (i in more.indices) {
            if (more[i] != less[i]) {
                ++count
                less = buildString {
                    val prefix = less.substring(0, i)
                    val insert = more[i]
                    val suffix = less.substring(i)
                    append(prefix)
                    append(insert)
                    append(suffix)
                }
                if (count > 1) return false
            }
        }
    }

    return true
}

private fun String.getStringByDescending(s2: String) = if (length > s2.length) this to s2 else s2 to this

/**
 * B. Пограничный контроль
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.2 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
OpenJDK Java 11	0.4 секунды	64Mb
C# (MS .NET 6.0 + ASP)	0.4 секунды	64Mb
Java 21 (Temurin JDK)	0.4 секунды	64Mb
Kotlin 1.8.0 (JRE 11)	0.4 секунды	64Mb
C# (MS .NET 5.0 + ASP)	0.4 секунды	64Mb
Представьте, что вы работаете пограничником и постоянно проверяете документы людей по записи из базы.
При этом допустима ситуация, когда имя человека в базе отличается от имени в паспорте на одну замену,
одно удаление или одну вставку символа. Если один вариант имени может быть получен из другого удалением одного символа,
то человека пропустят через границу. А вот если есть какое-либо второе изменение,
то человек грустно поедет домой или в посольство.

Например, если первый вариант —– это «Лена», а второй — «Лера», то девушку пропустят.
Также человека пропустят, если в базе записано «Коля», а в паспорте — «оля».

Однако вариант, когда в базе числится «Иннокентий», а в паспорте написано «ннакентий», уже не сработает.
Не пропустят также человека, у которого в паспорте записан «Иинннокентий», а вот «Инннокентий» спокойно пересечёт границу.

Напишите программу, которая сравнивает имя в базе с именем в паспорте и решает, пропускать человека или нет.
В случае равенства двух строк — путешественника, естественно, пропускают.

Формат ввода
В первой строке дано имя из паспорта.

Во второй строке —- имя из базы.

Обе строки состоят из строчных букв английского алфавита.
Размер каждой строки не превосходит 100 000 символов.

Формат вывода
Выведите «OK», если человека пропустят, или «FAIL» в противном случае.

Пример 1
Ввод
abcdefg
abdefg

Вывод
OK

Пример 2
Ввод
helo
hello

Вывод
OK

Пример 3
Ввод
dog
fog

Вывод
OK

Пример 4
Ввод
mama
papa

Вывод
FAIL
 * */

