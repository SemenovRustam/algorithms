package com.semenov.yandex.practicum.sprint3

fun main() {
    val (count, amount) = readln().split(" ").map(String::toInt)

    val homes = readln().split(" ").map { it.toInt() }

    println(checkMaxHomes(amount, homes))
}

private fun checkMaxHomes(amount: Int, homes: List<Int>): Int {
    val sortedHomes = homes.sorted()
    var sum = 0
    var quantity = 0

    for (home in sortedHomes) {
        if (sum + home <= amount) {
            sum += home
            ++quantity
        } else {
            break
        }
    }
    return quantity
}

/**
Тимофей решил купить несколько домов на знаменитом среди разработчиков Алгосском архипелаге.
Он нашёл n объявлений о продаже, где указана стоимость каждого дома в алгосских франках.
А у Тимофея есть k франков.
Помогите ему определить, какое наибольшее количество домов на Алгосах он сможет приобрести за эти деньги.

Формат ввода
В первой строке через пробел записаны натуральные числа n и k.

n — количество домов, которые рассматривает Тимофей, оно не превосходит 100000;

k — общий бюджет, не превосходит 100000;

В следующей строке через пробел записано n стоимостей домов.
Каждое из чисел не превосходит 100000. Все стоимости — натуральные числа.

Формат вывода
Выведите одно число —– наибольшее количество домов, которое может купить Тимофей.

Пример 1
Ввод
3 300
999 999 999
Вывод
0

Пример 2
Ввод
3 1000
350 999 200

Вывод
2

 * */
