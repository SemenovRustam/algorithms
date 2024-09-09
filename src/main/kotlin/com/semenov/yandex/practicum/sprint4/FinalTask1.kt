package com.semenov.yandex.practicum.sprint4

fun main() {
    val documentCount = readln().toInt()
    var count = 1
    val documents = buildList {
        repeat(documentCount) {
            add(
                Document(
                    dictionary = readln().split(" ")
                        .groupingBy { it.lowercase() }
                        .eachCount(),
                    number = count++
                )
            )
        }
    }

    val requestCount = readln().toInt()

    val requests = buildList {
        repeat(requestCount) {
            add(
                Request(
                    words = buildSet {
                        readln().split(" ").forEach { string ->
                            add(string)
                        }
                    }
                )
            )
        }
    }

    val comparator = compareByDescending<Map.Entry<Int, Int>> { it.value }
        .thenBy { it.key }

    for (request in requests) {
        val sortedEntries = getRelevantRequest(documents, request)
            .entries.sortedWith(comparator)
            .map { it.key }
            .take(5)

        println(sortedEntries.joinToString(" "))
    }
}

private fun getRelevantRequest(documents: List<Document>, request: Request): Map<Int, Int> {
    val result = buildMap<Int, Int> {
        for (word in request.words) {
            for (doc in documents) {
                if (word in doc.dictionary) {
                    this[doc.number] = getOrPut(doc.number) { 0 } + doc.dictionary[word]!!
                }
            }
        }
    }

    return result
}

private data class Document(
    val dictionary: Map<String, Int> = mutableMapOf(),
    val number: Int

)

private data class Request(
    val words: Set<String> = mutableSetOf()
)


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

