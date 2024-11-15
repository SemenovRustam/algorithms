package com.semenov.yandex.practicum.sprint8

fun main() {
    val s = readln()
    val result = getMaxPalindrome(s)
    println(result)
}

fun getMaxPalindrome(s: String): String {
    val dictionary = s.groupingBy { it }.eachCount()
    var mid: Char? = null

    val left = buildString {
        for (char in dictionary.keys.sorted()) {
            val value = dictionary[char] ?: 0
            append(char.toString().repeat(value / 2))

            if (value % 2 != 0 && (mid == null || char < mid!!)) {
                mid = char
            }
        }
    }
    return left + (mid ?: "") + left.reversed()
}
