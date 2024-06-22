package com.semenov.yandex.practicum.sprint2




import java.util.*
import kotlin.math.floor

fun main() {
    val split = readln().split(" ").toMutableList()

    val result = calculate(split)
    println(result)
}

private fun calculate(stringStack: MutableList<String>) = buildString {
    val intStack = Stack<Int>()

    for (index in stringStack.indices) {
        val operator = stringStack[index]

        if (operator !in operators) {
            intStack.push(operator.toInt())
        } else {
            val second = intStack.pop()
            val first = intStack.pop()

            val result = when (operator) {
                "+" -> first + second
                "-" -> first - second
                "*" -> first * second
                else -> {
                    floor(first.toFloat() / second.toFloat()) .toInt()
                }
            }
            if (stringStack.isEmpty()) {
                append(result)
                break
            }
            intStack.push(result)

        }
    }
    if (intStack.isNotEmpty()) {
        append(intStack.pop())
    }
}

val operators = listOf("/", "*", "-", "+")

/**

2 5 - 4 /
4 13 5 / +

2 1 + 3 *

7 2 + 4 * 2 +

4 13 5 / +
6

 */