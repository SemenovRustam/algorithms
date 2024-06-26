package com.semenov.yandex.practicum.sprint2


import java.util.Stack

fun main() {
    val balanced = isBalanced(readln())

    if (balanced) {
        println("True")
    } else {
        println("False")
    }
}

private fun isBalanced(brackets: String): Boolean {
    val stack = Stack<Char>()
    val bracketsMap = mapOf('(' to ')', '{' to '}', '[' to ']')

    for (char in brackets) {
        if (bracketsMap.containsKey(char)) {
            stack.add(char)
        } else if (stack.isEmpty() || bracketsMap[stack.pop()] != char) {
            return false
        }
    }

    return stack.isEmpty()
}
/**
 *
 * H. Скобочная последовательность
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.1 секунда	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	1 секунда	64Mb
Python 3.7.3	1 секунда	64Mb
OpenJDK Java 11	1 секунда	64Mb
C# (MS .NET 6.0 + ASP)	1 секунда	64Mb
Kotlin 1.8.0 (JRE 11)	1 секунда	64Mb
Python 3.11.4	1 секунда	64Mb
C# (MS .NET 5.0 + ASP)	1 секунда	64Mb
Вот какую задачу Тимофей предложил на собеседовании одному из кандидатов. Если вы с ней ещё не сталкивались,
то наверняка столкнётесь –— она довольно популярная.

Дана скобочная последовательность. Нужно определить, правильная ли она.

Будем придерживаться такого определения:

пустая строка —– правильная скобочная последовательность;
правильная скобочная последовательность, взятая в скобки одного типа, –— правильная скобочная последовательность;
правильная скобочная последовательность с приписанной слева или справа правильной скобочной
последовательностью —– тоже правильная.
На вход подаётся последовательность из скобок трёх видов: [], (), {}.
Напишите функцию is_correct_bracket_seq, которая принимает на вход скобочную последовательность и возвращает True,
если последовательность правильная, а иначе False.


Пример 1

Ввод
{[()]}

Вывод
True

Пример 2

Ввод
()

Вывод
True

 */