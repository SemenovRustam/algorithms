package com.semenov.yandex.practicum.sprint8

fun main() {
    val strings = readln().split(" ")

    val result = buildString {
        for (i in strings.size - 1 downTo 0) {
            append("${strings[i]} ")
        }
    }

    println(result)

}

/**
 * A. Разворот строки
Ограничение времени	0.3 секунды
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
В некоторых языках предложения пишутся и читаются не слева направо, а справа налево.

Вам под руку попался странный текст –— в нём обычный (слева направо) порядок букв в словах. А вот сами слова идут в противоположном направлении. Вам надо преобразовать текст так, чтобы слова в нём были написаны слева направо.

Формат ввода
На ввод подаётся строка, состоящая из слов, разделённых пробелами (один пробел между соседними словами). Всего слов не более 1000, длина каждого из них —– от 1 до 100 символов. Слова состоят из строчных букв английского алфавита.

Формат вывода
Выведите строку с обратным порядком слов в ней.

Пример 1
Ввод
one two three
Вывод
three two one

Пример 2
Ввод
hello
Вывод
hello

Пример 3
Ввод
may the force be with you

Вывод
you with be force the may
 *
 */
