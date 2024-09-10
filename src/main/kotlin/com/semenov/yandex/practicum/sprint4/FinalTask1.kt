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

private fun createWordIndex(documentCount: Int) = buildMap<String, MutableMap<Int, Int>> {
    for (docNumber in 1..documentCount) {
        val wordFrequency = readln().split(" ")
            .groupingBy { it.lowercase() }
            .eachCount()

        for ((word, freq) in wordFrequency) {
            val docMap = getOrPut(word) { mutableMapOf() }
            docMap[docNumber] = freq
        }
    }
}

private fun handleRequest(
    wordToDocFrequency: Map<String, MutableMap<Int, Int>>
): Map<Int, Int> {
    val documentScores = mutableMapOf<Int, Int>()
    val requestWords = readln().split(" ").map { it.lowercase() }.toSet()

    for (word in requestWords) {
        val docMap = wordToDocFrequency[word] ?: continue
        for ((docNum, freq) in docMap) {
            documentScores[docNum] = documentScores.getOrDefault(docNum, 0) + freq
        }
    }
    return documentScores
}

private fun getSortedDoc(documentScores: Map<Int, Int>): List<Int> {
    return documentScores.entries
        .sortedWith(compareByDescending<Map.Entry<Int, Int>> { it.value }.thenBy { it.key })
        .map { it.key }
        .take(5)
}


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

