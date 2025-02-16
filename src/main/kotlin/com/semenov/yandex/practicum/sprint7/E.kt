package com.semenov.yandex.practicum.sprint7

fun main() {
    val coast = readln().toInt()
    readln()
    val nominal = readln().split(" ").map { it.toInt() }.sortedByDescending { it }

    println(getMinBanknotes(coast, nominal))
}

fun getMinBanknotes(coast: Int, nominals: List<Int>): Int {
    // Создаем массив для хранения минимального количества банкнот для каждой суммы от 0 до coast
    val dp = IntArray(coast + 1) { Int.MAX_VALUE }
    dp[0] = 0 // Для суммы 0 нужно 0 банкнот

    // Заполняем массив dp
    for (nominal in nominals) {
        for (j in nominal..coast) {
            if (dp[j - nominal] != Int.MAX_VALUE) {
                dp[j] = minOf(dp[j], dp[j - nominal] + 1) // Обновляем минимальное количество банкнот
            }
        }
    }

    return if (dp[coast] == Int.MAX_VALUE) -1 else dp[coast] // Если для coast не нашли решение, возвращаем -1
}

/**
 * E. Алла на Алгосах
Все языки	Python 3.7.3	Python 3.11.4
Ограничение времени	0.5 секунд	6 секунд	6 секунд
Ограничение памяти	64Mb	64Mb	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Алла хочет купить дом на Алгосах. Для этого ей надо много наличных, которые она собирается получить в банкомате.
Банкомат приличный, поэтому в нём есть бесконечно много банкнот каждого номинала. Всего номиналов k штук.
Дом мечты Аллы стоит x франков.

Найдите минимальное количество банкнот, которые в сумме дадут x франков.
Если в набор входит несколько банкнот одинакового номинала, то учитывать надо их все.

Например, если необходимо набрать 15 франков, а в банкомате купюры по 5 франков, то минимальное число купюр —- 3.

Формат ввода
В первой строке дана сумма, которую хочет получить Алла –— натуральное число x (1 ≤ x ≤ 104).
Во второй строке дано число различных номиналов k. В третьей строке даны k чисел (1 ≤ k ≤ 1000) —– номиналы купюр.
Все номиналы лежат в диапазоне от 1 до 104. Номиналы купюр могут повторяться.

Формат вывода
Выведите единственное число —– минимальное количество купюр, которыми можно набрать x франков.
Если нельзя набрать в точности x франков, то выведите -1.

Пример 1
Ввод
130
4
10 3 40 1

Вывод
4
Пример 2

Ввод
100
2
7 5

Вывод
16

Пример 3
Ввод
1
1
1

Вывод
1
 */