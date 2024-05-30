package com.semenov.yandex.practicum.sprint1

fun main() {
    val n = readInt()
    val arr = readInts()
    val chaosFactor = getChaosFactor(n, arr)
    println(chaosFactor)
}

private fun getChaosFactor(n: Int, arr: List<Int>): Int {
    var chaosFactor = 0
    if (arr.size == 1) return 1
    for (index in 1..arr.size - 2) {
        val currentTemp = arr[index]
        if (currentTemp > arr[index - 1] && currentTemp > arr[index + 1]) {
            chaosFactor++
        }
    }
    if (arr.first() > arr[1]) {
        chaosFactor++
    }

    if (arr[arr.lastIndex] > arr[arr.lastIndex - 1]) {
        chaosFactor++
    }

    return chaosFactor
}


private fun readStr() = readln()
private fun readInt() = readStr().toInt()
private fun readStrings() = readStr().split(" ")
private fun readInts() = readStrings().map { it.toInt() } // list of ints

/**
 * D. Хаотичность погоды
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.2 секунды	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
OpenJDK Java 11	0.5 секунд	64Mb
C# (MS .NET 6.0 + ASP)	0.5 секунд	64Mb
Java 21 (Temurin JDK)	0.5 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	0.6 секунд	64Mb
C# (MS .NET 5.0 + ASP)	0.5 секунд	64Mb
Метеорологическая служба вашего города решила исследовать погоду новым способом.

Под температурой воздуха в конкретный день будем понимать максимальную температуру в этот день.
Под хаотичностью погоды за n дней служба понимает количество дней, в которые температура строго больше,
чем в день до (если такой существует) и в день после текущего (если такой существует).
Например, если за 5 дней максимальная температура воздуха составляла [1, 2, 5, 4, 8] градусов, то хаотичность за этот период равна 2: в 3-й и 5-й дни выполнялись описанные условия.
Определите по ежедневным показаниям температуры хаотичность погоды за этот период.

Заметим, что если число показаний n=1, то единственный день будет хаотичным.

Формат ввода
В первой строке дано число n –— длина периода измерений в днях, 1 ≤ n≤ 105.
Во второй строке даны n целых чисел –— значения температуры в каждый из n дней. Значения температуры не превосходят 273 по модулю.

Формат вывода
Выведите единственное число — хаотичность за данный период.

Пример 1
Ввод	                Вывод
7                       3
-1 -10 -8 0 2 0 5

Пример 2
Ввод	        Вывод
5               2
1 2 5 4 8

 */