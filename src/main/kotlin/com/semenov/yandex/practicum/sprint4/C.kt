package com.semenov.yandex.practicum.sprint4

fun main() {
    val word1 = readln()
    val word2 = readln()

    val result = if (canBeReplaced(word1, word2)) {
        "YES"
    } else {
        "NO"
    }

    println(result)
}

fun canBeReplaced(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val associate1 = mutableMapOf<Char, Char>()
    val associate2 = mutableMapOf<Char, Char>()

    for (i in word1.indices) {
        val char1 = word1[i]
        val char2 = word2[i]

        if (char1 in associate1) {
            val value = associate1[char1]
            if (char2 != value) {
                return false
            }
        } else {
            associate1[char1] = char2
        }

        if (char2 in associate2) {
            val value = associate2[char2]
            if (value != char1) {
                return false
            }
        } else {
            associate2[char2] = char1
        }
    }
    return true
}


/**
Жители Алгосского архипелага придумали новый способ сравнения строк.
Две строки считаются равными, если символы одной из них можно заменить на символы другой так,
что первая строка станет точной копией второй строки. При этом необходимо соблюдение двух условий:

Порядок вхождения символов должен быть сохранён.
Одинаковым символам первой строки должны соответствовать одинаковые символы второй строки. Разным символам —– разные.
Например, если строка s = «abacaba», то ей будет равна строка t = «xhxixhx»,
так как все вхождения «a» заменены на «x», «b» –— на «h», а «c» –— на «i».
Если же первая строка s=«abc», а вторая t=«aaa», то строки уже не будут равны,
так как разные буквы первой строки соответствуют одинаковым буквам второй.

Формат ввода
В первой строке записана строка s, во второй –— строка t. Длины обеих строк не превосходят 106.
Обе строки содержат хотя бы по одному символу и состоят только из маленьких латинских букв.

Строки могут быть разной длины.

Формат вывода
Выведите «YES», если строки равны (согласно вышеописанным правилам), и «NO» в ином случае.

Пример 1
Ввод
mxyskaoghi
qodfrgmslc

Вывод
YES

Пример 2

Ввод
agg
xdd

Вывод
YES

Пример 3
Ввод
agg
xda

Вывод
NO
 */