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

    val minLength = minOf(word1.length, word2.length)
    buildMap<Char, Char> {
        for (index in 0 until minLength) {
            if (!this.containsKey(word1[index]) && this.containsValue(word2[index])) {
                return false
            }
            this[word1[index]] = word2[index]
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