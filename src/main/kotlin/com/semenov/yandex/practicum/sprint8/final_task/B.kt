package com.semenov.yandex.practicum.sprint8.final_task

/**
 * https://contest.yandex.ru/contest/26133/run-report/125830449/
 *
 * Принцип работы:
 *
 * Создаю TrieNode с полями для потомков и флагом, означающим, что слово заканчивается на текущей ноде.
 *
 * Класс Trie имеет поле: root хранит ноду
 * insert - заполняет текущим словом бор: берем текущую ноду, итерируемся по слову в текущей ноде у потомков ищем
 * тикущий символ, если если берем ноду потомка, если нет, создаем пустую ноду. По окончании итерации помечаем
 * в текущей ноде, что здесь оканчивается строка.
 *
 * canSegment - создаем булевый массив, инициализируем первое значение - тру, что бужет означать, что пустую строку можно разбить
 * Во внешнем цикле проходимся по индексам из строки, если в массиве по текущему индексу отрицательное значение - продолжать
 * далее цикл нет смысла, сразу перехдоим к следующей итерации, означает что строку разбить нельзя до этого индекса
 * Во внутреннем цикле итерируемся по символам
 * В текущей ноде ищем по символу потомков - если не находим, значит разбить нельзя - заканчиваем цикл
 *
 * Если terminated == true, то в массиве под индесом j + 1 - помечаем true, что будет означать, что текст можно разбить
 * в текущей позиции.
 *
 * Искомый результат будет лежать в последней ячейка массива.
 *
 * Временная сложность: заполнение бора: O(n), n - кол-во слов
 * canSegment: O(L * m), где L - длина текста, m - длина слова
 * Общая O(L * m)
 *
 * Пространственная сложность:
 * canSegment - хранит массив длинной n - O(n)
 * trie - худший случай (если символы не совпадают) O(m * n),  в лучшем случае при совпадении префикса - O(n)
 * Общая: O(m * n)
 *
 * */

fun main() {
    val text = readln()
    val n = readln().toInt()

    val trie = Trie()
    repeat(n) {
        trie.insert(readln())
    }

    val result = if (canSegment(text, trie)) "YES" else "NO"
    println(result)
}

fun canSegment(text: String, trie: Trie): Boolean {
    val n = text.length
    val booleans = BooleanArray(n + 1)
    booleans[0] = true

    for (i in text.indices) {
        if (!booleans[i]) continue

        var current = trie.root
        for (j in i until n) {
            val char = text[j]
            current = current.children[char] ?: break

            if (current.terminated) {
                booleans[j + 1] = true
            }
        }
        if (booleans[n]) return true
    }

    return booleans[n]
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var terminated = false
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.terminated = true
    }
}