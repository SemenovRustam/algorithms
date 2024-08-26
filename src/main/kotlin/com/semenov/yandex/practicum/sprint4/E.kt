package com.semenov.yandex.practicum.sprint4

fun main() {
    findCollision()
}

// Параметры хеш-функции
const val q = 1000L
const val R = 123987123L

// Функция для вычисления хеша строки
fun hashString(s: String): Long {
    var h = 0L
    var power = 1L
    for (char in s.reversed()) {
        h = (h + char.code * power) % R
        power = (power * q) % R
    }
    return h
}

// Генерация случайной строки
fun generateRandomString(length: Int): String {
    val chars = "abcdefghijklmnopqrstuvwxyz"
    return (1..length)
        .map { chars.random() }
        .joinToString("")
}

// Поиск коллизий
fun findCollision() {
    while (true) {
        val s1 = generateRandomString(10)  // Вы можете изменить длину строки
        val s2 = generateRandomString(10)

        val hash1 = hashString(s1)
        val hash2 = hashString(s2)

        if (s1 != s2 && hash1 == hash2) {
            println(s1)
            println(s2)
            return
        }
    }
}

/**
 *
E. Сломай меня
Гоша написал программу, которая сравнивает строки исключительно по их хешам.
Если хеш равен, то и строки равны.
Тимофей увидел это безобразие и поручил вам сломать программу Гоши, чтобы остальным неповадно было.

В этой задаче вам надо будет лишь найти две различные строки,
которые для заданной хеш-функции будут давать одинаковое значение.

Гоша использует следующую хеш-функцию:


для a = 1000 и m = 123 987 123.
В данной задаче необходимо использовать в качестве значений отдельных символов их коды в таблице ASCII.

Формат ввода
В задаче единственный тест без ввода

Формат вывода
Отправьте две строки, по одной в строке.
Строки могут состоять только из маленьких латинских букв и не должны превышать в длину 1000 знаков каждая.
Код отправлять не требуется. Строки из примера использовать нельзя.

Пример вывода:

ezhgeljkablzwnvuwqvp

gbpdcvkumyfxillgnqrv

 */

