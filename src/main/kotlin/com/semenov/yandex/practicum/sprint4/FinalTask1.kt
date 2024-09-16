package com.semenov.yandex.practicum.sprint4

/**
https://contest.yandex.ru/contest/24414/run-report/117925321/

Принцип работы: по входящим документам составляю индекс: слово -> номер документа : кол-во слов
По словам из входящих запросов достаю из индекса номер документа и сколько раз в этом документе встречается это слово
В отдельную мапу складываю значение по номеру дока и частоту слова
С помощью компаратора сортирую сперва по ключу, затем по значению
Вывожу результат на экран


Временная сложность:
d -- кол-во документов
d_w -- кол-во слов в документе
q -- кол-во запросов
q_w -- кол-во слов в запросе

1. Функция createWordIndex обрабатывает каждое слово в документе. Она использует методы groupingBy, eachCount, и forEach.

groupingBy и eachCount проходит по каждому слову документа один раз и группирует их по частоте. Это операция O(d_w ),
где d_w  — количество слов в документе.
forEach вызывает добавление объекта в список через getOrPut,
что работает за O(1) в среднем для каждой операции (так как это доступ по ключу для хэш-таблицы).
Для каждого документа сложность построения индекса будет O(d_w), где d_w — количество слов в документе.
Если у нас D документов и W слов в каждом, общая сложность будет:
O(d×d_w)

2. Обработка запроса handleRequest:
    - Добавление всех элементов:  O(m), где m — это количество документов, содержащих искомое слово.
    - Группировка по номеру документа: Это группировка списка по номеру документа с использованием метода groupBy,
      что работает за O(d), где d — количество документов в списке.
    - Суммирование релевантности для каждого документа:  Это также будет O(d), где d — количество уникальных документов.

Cложность выполнения одного запроса  будет O(d), где d — количество документов,
которые содержат хотя бы одно слово из запроса.

3. Сортировка документов getSortedDoc
Т.к внешний цикл выполняется k раз, то общая сложность будет  O(k*n), ассимптотическая сложность - O(n)

4. Общая временная сложность
O(d×d_w + q * d)


Пространственная сложность:
Создание индекса - O(n * k), где n — количество уникальных слов в документе, а k — количество документов.
Обработка запросов - O(n * k), где n — количество слов в наборе request, k - кол-во запросов
Общая сложность - O(n * k)

createWordIndex: O(d_w\d)
handleRequest: O(d)
getSortedDoc: O(d)

Общая: O(d_w\d + d + d)

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

