package com.semenov.yandex.practicum.sprint1


fun main() {
    val (a, x, b, c) = readInts()
    println(calc(a, b, c, x))
}

private fun calc(a: Int, b: Int, c: Int, x: Int): Int {
    val y = a * (x * x) + (b * x) + c
    return y
}

private fun readStr() = readln()
private fun readStrings() = readStr().split(" ")
private fun readInts() = readStrings().map { it.toInt() }


/**
 * Вася делает тест по математике: вычисляет значение функций в различных точках.
 * Стоит отличная погода, и друзья зовут Васю гулять. Но мальчик решил сначала закончить
 * тест и только после этого идти к друзьям. К сожалению, Вася пока не умеет программировать.
 * Зато вы умеете. Помогите Васе написать код функции, вычисляющей y = ax2 + bx + c.
 * Напишите программу, которая будет по коэффициентам a, b, c и числу x
 * выводить значение функции в точке x.
 */