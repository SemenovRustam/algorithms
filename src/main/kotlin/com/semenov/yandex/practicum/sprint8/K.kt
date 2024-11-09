package com.semenov.yandex.practicum.sprint8

fun main() {
    val chars = listOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    )

    val filterChars = buildList {
        chars.forEachIndexed { index, c ->
            if ((index % 2) == 1) add(c)
        }
    }

    val s1 = readln()
    val s2 = readln()

    println(getCustomCompare(s1, s2, filterChars))
}

fun getCustomCompare(s1: String, s2: String, filterChars: List<Char>): Int {
    val filtersStr1 = s1.normalizeByFilterChars(filterChars)
    val filtersStr2 = s2.normalizeByFilterChars(filterChars)

    val comparisonResult = filtersStr1.compareTo(filtersStr2)
    return when {
        comparisonResult > 0 -> 1
        comparisonResult < 0 -> -1
        else -> 0
    }
}

private fun String.normalizeByFilterChars(filterChars: List<Char>): String {
    val result = mutableListOf<Char>()
    this.forEach {
        if (it in filterChars)
            result.add(it)
    }

    return result.joinToString("")
}

/**
 * K. Сравнить две строки
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Алла придумала новый способ сравнивать две строки: чтобы сравнить строки a и b, в них надо оставить только те буквы,
которые в английском алфавите стоят на четных позициях. Затем полученные строки сравниваются по обычным правилам.
Помогите Алле реализовать новое сравнение строк.

Формат ввода
На вход подаются строки a и b по одной в строке. Обе строки состоят из маленьких латинских букв,
не бывают пустыми и не превосходят 105 символов в длину.

Формат вывода
Выведите -1, если a < b, 0, если a = b, и 1, если a > b.

Пример 1
Ввод
gggggbbb
bbef

Вывод
-1

Пример 2
Ввод
z
aaaaaaa

Вывод
1

Пример 3
Ввод
ccccz
aaaaaz

Вывод
0
 * */