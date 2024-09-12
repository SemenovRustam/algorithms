package com.semenov.yandex.practicum.sprint4

/**
https://contest.yandex.ru/contest/24414/run-report/117692917/

Принцип работы: по входящим документам составляю индекс: слово -> номер документа : кол-во слов
По словам из входящих запросов достаю из индекса номер документа и сколько раз в этом документе встречается это слово
В отдельную мапу складываю значение по номеру дока и частоту слова
С помощью компаратора сортирую сперва по ключу, затем по значению
Вывожу результат на экран


Временная сложность:
Создание индекса: n^2 = обработка строки + проход по мапе
Обработка запроса: n^2 = обработка строки + проход по строке + проход по мапе
Общая = n^2

Пространственная сложность:
Создание индекса - линейная, зависит от кол-ва документов
Обработка запросов - линейная(создание мапы documentScores), зависит от кол-ва запросов
Общая сложность - линейная

 * */

fun main() {
    val documentCount = readln().toInt()
    val wordToDocFrequency = createWordIndex(documentCount)

    val requestCount = readln().toInt()
    repeat(requestCount) {
        val documentScores = handleRequest(wordToDocFrequency)
        val sortedDocuments = getSortedDoc(documentScores)
        println(sortedDocuments.joinToString(" "))
    }
}

private fun createWordIndex(documentCount: Int): Map<String, MutableList<WordIndex>> {
    return buildMap {
        for (docNumber in 1..documentCount) {
            readln().split(" ")
                .groupingBy { it }
                .eachCount()
                .forEach { (word, freq) ->
                    getOrPut(word) { mutableListOf() }.add(WordIndex(docNumber, freq))
                }
        }
    }
}

private fun handleRequest(
    wordToDocFrequency: Map<String, MutableList<WordIndex>>
): Map<Int, Int> {
    return buildList {
        for (word in readln().split(" ").toSet()) {
            val wordInfoList = wordToDocFrequency[word] ?: continue
            add(wordInfoList)
        }
    }.flatten()
        .groupingBy { it.documentNumber }
        .aggregate { _, accumulator, element, _ ->
            accumulator?.plus(element.relevant) ?: element.relevant
        }
}

private fun getSortedDoc(documentScores: Map<Int, Int>): List<Int> {
    return documentScores.entries
        .sortedWith(compareByDescending<Map.Entry<Int, Int>> { it.value }.thenBy { it.key })
        .map { it.key }
        .take(5)
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

