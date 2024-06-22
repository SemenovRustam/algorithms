package com.semenov.yandex.practicum.sprint2

import java.util.*

fun main() {
    val stack = Stack<String>()
    val split = readln().split(" ")

    for (index in split.lastIndex downTo 0) {
        stack.push(split[index])
    }

    val result = calculate(stack)
    println(result)
}

private fun calculate(stack: Stack<String>) = buildString {
    if (stack.size == 1) {
        append(stack.pop())
        return@buildString
    }
    if (stack.size == 2) {
        append(stack.firstElement())
        return@buildString
    }

    while (stack.isNotEmpty()) {
        var first = stack.pop().toInt()
        var second = stack.pop().toInt()
        lateinit var operator: String

        val check = stack.peek().toIntOrNull()

        if (check != null) {
            val tempFirst = first
            first = second
            second = stack.pop().toInt()
            operator = stack.pop()
            stack.push(tempFirst.toString())
        } else {
            operator = stack.pop()
        }

        val result = when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            else -> first / second
        }
        if (stack.isEmpty()) {
            append(result)
            break
        }
        stack.push(result.toString())
    }
}

/**
4 13 5 / +

2 1 + 3 *

7 2 + 4 * 2 +

 */