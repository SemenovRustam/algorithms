package com.semenov.yandex.practicum.sprint8

fun main() {
    val trie = Trie()
    val n = readln().toInt()
    val words = buildList {
        repeat(n) {
            val word = readln()
            add(word)
            trie.insert(word)
        }
    }

    val default = words.sorted().joinToString("\n")

    repeat(readln().toInt()) {
        val pattern = readln()

        val result = if (pattern.isBlank()) {
            default
        } else {
            getMatchingLines(pattern, trie).takeIf { it.isNotEmpty() }
                ?.sorted()
                ?.joinToString("\n")
                ?: ""
        }
        println(result)
    }
}

fun getMatchingLines(pattern: String, trie: Trie): List<String> {
    var current = trie.root
    var patternIndex = 0
    var matchIndex = 0
    for (char in pattern) {
        if (char in current.children) {
            current = current.children[char]!!
            matchIndex++
        }
        patternIndex++
    }
    return if (patternIndex <= matchIndex) current.result else emptyList()
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isTerminated: Boolean = false
    var result = mutableListOf<String>()
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        val pattern = word.filter { it.isUpperCase() }
        var current = root

        for (c in pattern) {
            current = current.children.getOrPut(c) { TrieNode() }
            current.result.add(word)
        }
        current.isTerminated = true
    }
}

/**
 * J. Случай верблюда
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1 секунда	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Python 3.7.3	5 секунд	64Mb
C# (MS .Net 5.0)+ASP	3 секунды	256Mb
Oracle Java 8	3 секунды	256Mb
OpenJDK Java 11	3 секунды	256Mb
В некоторых IDE поддерживается навигация по файлам через их сокращённые названия.
Если в языке принято называть классы CamelCase'ом (как в Java, например),
то по заглавным буквам названия можно быстро найти нужный класс.
Например, если название класса «MyFavouriteConfigurableScannerFactory», то его можно найти по строке «MFCSF».
Но если в проекте есть класс «theMultiFunctionalCommaSeparatedFile», то он тоже будет подходить под этот паттерн,
и при поиске надо будет выбрать между этими двумя вариантами.

Вам дан набор строк в CamelCase.
Далее будут поступать запросы в виде строк-паттернов из прописных букв английского алфавита.
Вам надо находить такие строки среди исходных, которые удовлетворяют заданному шаблону, и выводить их в лексикографическом порядке.

Также в паттерне может быть только несколько первых заглавных букв.
Например, если бы в указанном выше примере был бы паттерн «MFCS», то существующие две строки походили бы под него,
а также подходил бы, например, «MamaFicusCodingSouthWestNorth». А вот «MamaCodingSouthWestNorth» –— уже нет.

Формат ввода
В первой строке записано число — количество названий классов в исходном наборе n (1 ≤ n ≤ 105).
Все названия состоят из строчных и прописных букв английского алфавита.

В следующих n строках даны сами названия по одному в строке. Суммарная длина этих строк не превосходит 107.

Затем дано количество запросов m (1 ≤ m ≤ 100).

В следующих *m* строках даны сами запросы. Каждый запрос –— это шаблон, строка из прописных букв английского алфавита,
в длину не превышающая 105. Шаблон может быть пустым. Заметьте: шаблону из нуля прописных букв удовлетворяет любое название.

Формат вывода
Для каждого отдельного запроса (в порядке их поступления) выведите в лексикографическом порядке все строки,
которые подходят под данный шаблон. Если какие-то строки одинаковые, то выведите все экземпляры.
Если ни одна из строк не подходит под шаблон, то выведите для данного запроса пустую строку.

Пример 1

Ввод
3
MamaMilaRamu
MamaMia
MonAmi
2
MM
MA

Вывод
MamaMia
MamaMilaRamu
MonAmi

Пример 2
Ввод
2
AlphaBetaGgamma
AbcdBcdGggg
2
ABGG
ABG

Вывод
AbcdBcdGggg
AlphaBetaGgamma


Пример 3
Ввод
5
WudHnagkbhfwrbci
WCUkvoxboxufsdap
jdrxomezzrpuhbgi
ZcGHdrPplfoldemu
cylbtqwuxhiveznc
3
WGHV
NKVDT
ZGHU

Вывод

 * */