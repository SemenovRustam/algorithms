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

/**
 * B. Расписание
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	0.1 секунда	64Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Node.js 14.15.5	0.3 секунды	64Mb
OpenJDK Java 11	0.5 секунд	64Mb
C# (MS .NET 6.0 + ASP)	0.3 секунды	64Mb
Java 21 (Temurin JDK)	0.5 секунд	64Mb
Kotlin 1.8.0 (JRE 11)	0.5 секунд	64Mb
C# (MS .NET 5.0 + ASP)	0.3 секунды	64Mb
Дано количество учебных занятий, проходящих в одной аудитории. Для каждого из них указано время начала и конца.
Нужно составить расписание, в соответствии с которым в классе можно будет провести как можно больше занятий.

Если возможно несколько оптимальных вариантов, то выведите любой.
Возможно одновременное проведение более чем одного занятия нулевой длительности.

Формат ввода
В первой строке задано число занятий. Оно не превосходит 1000.
Далее для каждого занятия в отдельной строке записано время начала и конца, разделённые пробелом.
Время задаётся одним целым числом h, если урок начинается/заканчивается ровно в h часов.
Если же урок начинается/заканчивается в h часов m минут, то время записывается как h.m.
Гарантируется, что каждое занятие начинается не позже, чем заканчивается. Указываются только значащие цифры.

Формат вывода
Выведите в первой строке наибольшее число уроков, которое можно провести в аудитории.
Далее выведите время начала и конца каждого урока в отдельной строке в порядке их проведения.

Пример 1
Ввод
5
9 10
9.3 10.3
10 11
10.3 11.3
11 12

Вывод
3
9 10
10 11
11 12

Пример 2
Ввод
3
9 10
11 12.25
12.15 13.3

Вывод
2
9 10
11 12.25

Пример 3
Ввод
7
19 19
7 14
12 14
8 22
22 23
5 21
9 23

Вывод
3
7 14
19 19
22 23
 */

