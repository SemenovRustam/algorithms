package com.semenov.yandex.practicum.sprint4

fun main() {
    // Чтение входных данных
    val (n, k) = readln().split(" ").map(String::toInt)
    val inputString = readln().trim()

    val base = 47L
    val mod = 1_000_000_007L

    // Основная логика
    val hashToPos = mutableMapOf<Long, Int>()
    val counter = mutableMapOf<Long, Int>()
    val result = mutableListOf<Int>()
    val power = getPower(n, base, mod)

    // Вычисление начального хеша
    var hash = getHash(inputString.take(n), base, mod)
    counter[hash] = (counter[hash] ?: 0) + 1
    hashToPos[hash] = 0

    // Сдвиг хеша по строке
    for (i in 1..inputString.length - n) {
        // Обновление хеша: убираем символ str[i - 1] и добавляем str[i + n - 1]
        hash = (hash + mod - (inputString[i - 1].code * power % mod)) % mod
        hash = (hash * base % mod + inputString[i + n - 1].code) % mod

//        counter[hash] = (counter[hash] ?: 0) + 1
        counter[hash] = counter.getOrDefault(hash, 0) + 1

        // Если это первый раз, сохраняем позицию
        if (counter[hash] == 1) {
            hashToPos[hash] = i
        }

        // Если подстрока встречается k раз, добавляем позицию в результат
        if (counter[hash] == k) {
            result.add(hashToPos[hash]!!)
        }
    }

    // Вывод результата
    println(result.joinToString(" "))
}

// Функция для вычисления хеша подстроки
fun getHash(str: String, base: Long, mod: Long): Long {
    var hash = 0L
    for (i in str.indices) {
        hash = (hash * base % mod + str[i].code) % mod
    }
    return hash
}

// Функция для вычисления степени базы
fun getPower(n: Int, base: Long, mod: Long): Long {
    var power = 1L
    for (i in 1 until n) {
        power = (power * base) % mod
    }
    return power
}




