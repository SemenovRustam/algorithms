package com.semenov.yandex.practicum.sprint4

/**
https://contest.yandex.ru/contest/24414/run-report/117925321/

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
    val comparator = compareByDescending<DocumentRelevant> { it.relevant }
        .thenBy { it.documentNumber }

    val result = buildString {
        repeat(requestCount) {
            val request = readln().split(" ").toSet()
            val sortedDocuments =  wordToDocFrequency.handleRequest(request)
                .getSortedDoc(comparator, 5)
                .map { it.documentNumber }
            appendLine(sortedDocuments.joinToString(" "))
        }
    }
    println(result)
}

private fun MutableMap<String, MutableList<DocumentRelevant>>.createWordIndex(document: List<String>, docNumber: Int) =
    document.groupingBy { it }
        .eachCount()
        .forEach { (word, freq) ->
            getOrPut(word) { mutableListOf() }.add(DocumentRelevant(docNumber, freq))
        }

private fun Map<String, MutableList<DocumentRelevant>>.handleRequest(request: Set<String>): List<DocumentRelevant> {
    return buildList {
        for (word in request) {
            val wordInfoList = this@handleRequest[word] ?: continue
            add(wordInfoList)
        }
    }.flatten()
        .groupBy { it.documentNumber }
        .map { (documentNumber, relevantList) ->
            DocumentRelevant(documentNumber, relevantList.sumOf { it.relevant })
        }
}

private fun <T> List<T>.getSortedDoc(comparator: Comparator<T>, k: Int): List<T> {
    val result = mutableListOf<T>()
    val selectedIndices = mutableSetOf<Int>()

    for (i in 0 until k.coerceAtMost(size)) {
        var maxIndex: Int? = null

        for (j in indices) {
            if (j in selectedIndices) continue

            val currentEntry = this[j]
            val currentMaxEntry = maxIndex?.let { this[it] }

            if (currentMaxEntry == null || comparator.compare(currentMaxEntry,currentEntry ) > 0) {
                maxIndex = j
            }
        }

        maxIndex?.let {
            result.add(this[it])
            selectedIndices.add(it)
        }
    }

    return result
}

data class DocumentRelevant(val documentNumber: Int, val relevant: Int)

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

