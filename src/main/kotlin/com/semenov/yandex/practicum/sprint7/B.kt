package com.semenov.yandex.practicum.sprint7


fun main() {
    val n = readln().toInt()

    val lessons = buildList {
        repeat(n) {
            val (start, end) = readln().split(" ")
            add(Lesson(start, end))
        }
    }

    val scheduled = getMaxLessons(lessons)

    println(scheduled.size)
    scheduled.forEach { println("${it.start} ${it.end}") }
}

fun getMaxLessons(lessons: List<Lesson>): List<Lesson> {
    val comparator = compareBy<Lesson> { it.endTime }.thenBy { it.startTime }
    // Сортируем уроки по времени окончания
    val sortedLessons = lessons.sortedWith(comparator)

    val result = mutableListOf<Lesson>()
    var lastEndTime = -1

    for (lesson in sortedLessons) {
        // Изменяем условие на "больше или равно"
        if (lesson.startTime >= lastEndTime) {
            result.add(lesson)
            lastEndTime = lesson.endTime
        }
    }

    return result
}


fun parseTime(timeStr: String): Int {
    return if (timeStr.contains('.')) {
        val (h, m) = timeStr.split('.').map { it.toInt() }
        h * 60 + m
    } else {
        timeStr.toInt() * 60 // Если только часы, переводим в минуты
    }
}

data class Lesson(val start: String, val end: String) {
    // Преобразуем время в минуты для удобства
    val startTime: Int
        get() = parseTime(start)

    val endTime: Int
        get() = parseTime(end)
}