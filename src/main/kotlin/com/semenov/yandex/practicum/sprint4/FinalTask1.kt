package com.semenov.yandex.practicum.sprint4

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

private fun createWordIndex(documentCount: Int): MutableMap<String, MutableMap<Int, Int>> {
    val wordToDocFrequency = mutableMapOf<String, MutableMap<Int, Int>>()

    for (docNumber in 1..documentCount) {
        val words = readln().split(" ")
        val wordFrequency = words.groupingBy { it.lowercase() }.eachCount()

        for ((word, freq) in wordFrequency) {
            val docMap = wordToDocFrequency.getOrPut(word) { mutableMapOf() }
            docMap[docNumber] = freq
        }
    }
    return wordToDocFrequency
}

private fun handleRequest(
    wordToDocFrequency: MutableMap<String, MutableMap<Int, Int>>
): Map<Int, Int> {

    val documentScores = mutableMapOf<Int, Int>()
    val requestWords = readln().split(" ").map { it.lowercase() }.toSet()

    for (word in requestWords) {
        val docMap = wordToDocFrequency[word] ?: continue
        for ((docNumber, freq) in docMap) {
            documentScores[docNumber] = documentScores.getOrDefault(docNumber, 0) + freq
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

