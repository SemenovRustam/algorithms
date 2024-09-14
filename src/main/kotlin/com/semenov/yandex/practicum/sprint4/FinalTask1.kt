package com.semenov.yandex.practicum.sprint4

/**
https://contest.yandex.ru/contest/24414/run-report/117692917/

Принцип работы: по входящим документам составляю индекс: слово -> номер документа : кол-во слов
По словам из входящих запросов достаю из индекса номер документа и сколько раз в этом документе встречается это слово
В отдельную мапу складываю значение по номеру дока и частоту слова
С помощью компаратора сортирую сперва по ключу, затем по значению
Вывожу результат на экран


Временная сложность:
Создание индекса: O(n) = трижды проходимся по коллекции, что занимает O(n), добавление елемента  в список за О(1),
либо создание нового списка О(1)
Обработка запроса: О(n * k) = k - кол-во слов в запросе, n - кол-во елементов после flatten
Общая = кол-во документов * создание индекса + кол-во запросов * обработка запроса = О(n * k) + O(n)
(константы с кол-вом запросов сократил)

Пространственная сложность:
Создание индекса - O(n * k), где n — количество уникальных слов в документе, а k — количество документов.
Обработка запросов - O(n * k), где n — количество слов в наборе request, k - кол-во запросов
Общая сложность - O(n * k)

 * */

fun main() {
    val documentCount = readln().toInt()
    val wordToDocFrequency = buildMap {
        for (docNumber in 1..documentCount) {
            createWordIndex(readln().split(" "), docNumber)
        }
    }

    val requestCount = readln().toInt()
    repeat(requestCount) {
        val request = readln().split(" ").toSet()
        val documentScores = wordToDocFrequency.handleRequest(request)
        val sortedDocuments = getSortedDoc(documentScores, 5)
        println(sortedDocuments.joinToString(" "))
    }
}

private fun MutableMap<String, MutableList<WordIndex>>.createWordIndex(document: List<String>, docNumber: Int) =
    document.groupingBy { it }
        .eachCount()
        .forEach { (word, freq) ->
            getOrPut(word) { mutableListOf() }.add(WordIndex(docNumber, freq))
        }

private fun Map<String, MutableList<WordIndex>>.handleRequest(request: Set<String>): Map<Int, Int> {
    return buildList {
        for (word in request) {
            val wordInfoList = this@handleRequest[word] ?: continue
            add(wordInfoList)
        }
    }.flatten()
        .groupingBy { it.documentNumber }
        .aggregate { _, accumulator, element, _ ->
            accumulator?.plus(element.relevant) ?: element.relevant
        }
}


private fun getSortedDoc(documentScores: Map<Int, Int>, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    val remainingEntries = documentScores.entries.toMutableList()
    val comparator = compareByDescending<Map.Entry<Int, Int>> { it.value }.thenBy { it.key }

    for (i in 0 until k.coerceAtMost(remainingEntries.size)) {
        var maxIndex = 0

        for (j in 1 until remainingEntries.size) {
            val currentEntry = remainingEntries[j]
            val currentMaxEntry = remainingEntries[maxIndex]
            if (comparator.compare(currentMaxEntry, currentEntry) > 0) {
                maxIndex = j
            }
        }

        result.add(remainingEntries[maxIndex].key)

        remainingEntries.removeAt(maxIndex)
    }

    return result
}

data class WordIndex(val documentNumber: Int, val relevant: Int)

/**


3
i love coffee
coffee with milk and sugar
free tea for everyone
3
i like black coffee without milk
everyone loves new year
mary likes black coffee without milk



 * */

