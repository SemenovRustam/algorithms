package com.semenov.yandex.practicum.sprint1

fun main() {
    val line = readln()
    println(if (isPalindrome(line)) "True" else "False")
}

private fun isPalindrome(line: String): Boolean {
    val filteredString = line
        .filter { isLetterOrDigit(it) }
        .lowercase()

    var start = 0
    var end = filteredString.lastIndex

    while (start < end) {
        if (filteredString[start] != filteredString[end]) {
            return false
        }
        start++
        end--
    }

    return true
}

fun isLetterOrDigit(c: Char): Boolean {
    return Regex("^[a-zA-Z0-9]$").matches(c.toString())
}

/**
 * F. Палиндром
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Помогите Васе понять, будет ли фраза палиндромом‎. Учитываются только буквы и цифры, заглавные и строчные буквы считаются одинаковыми.

Решение должно работать за O(N), где N — длина строки на входе.

Формат ввода
В единственной строке записана фраза или слово. Буквы могут быть только латинские. Длина текста не превосходит 20000 символов.

Фраза может состоять из строчных и прописных латинских букв, цифр, знаков препинания.

Формат вывода
Выведите «True», если фраза является палиндромом, и «False», если не является.

Пример 1
Ввод	                            Вывод
A man, a plan, a canal: Panama      True

Пример 2
Ввод	Вывод
zo      False
*/