package com.semenov.yandex.practicum.sprint7.final_task

import java.util.StringTokenizer

/**
 * https://contest.yandex.ru/contest/25597/run-report/123573442/
 *
 * Принцип работы:
 * isDivided:
 * Подсчитывется сумма всех очков, если сумма нечетная,  возвращается false, тк нечетное число не получится разделить
 * на 2.
 * Далее находится целевая сумма - это общая сумма, разделенная на 2.
 *
 * Создаю булевый массив dp:
 * 1) возможно ли собрать подмножество из элементов массива scores, сумма которого равна j.
 * 2) базовый случай - всегда можно собрать пустое подмножество
 * 3) от целевой суммы вычитаем score, если j - score = true, то это значит, что существует такое подмножество,
 * сумма которого равна j - score, добавление текущего элемента score позволяет получить j
 * 4) используется алгоритм по убыванию (от target к score)
 * 5) ответ на исходный вопрос будет располагаться в массиве под индексом 7.
 *
 * Для каждого элемента score обновляем массив dp в обратном порядке (от target до score).
 * Если dp[j - score] равно true, это означает, что существует подмножество,
 * сумма которого равна j - score, и добавление текущего score позволяет получить сумму j.
 *
 *
 * Временная сложность: O(n*t), где t - кол-во игр, t - целевая сумма(половина суммы всех элементов)
 * Пространственная сложность: O(t), где t - целевая сумма (храним данные в булевом массиве размера t)
 * */

fun main() {
    val n = readln().toInt()
    val tokenizer = StringTokenizer(readln())
    val records = IntArray(n) { tokenizer.nextToken().toInt() }

    val result = if (isDivided(records)) "True" else "False"

    println(result)
}

fun isDivided(scores: IntArray): Boolean {
    val totalSum = scores.sum()

    if (totalSum % 2 != 0) {
        return false
    }

    val target = totalSum / 2

    val dp = BooleanArray(target + 1)
    dp[0] = true

    for (score in scores) {
        for (j in target downTo score) {
            if (dp[j - score]) {
                dp[j] = true
            }
        }
    }
    return dp[target]
}
