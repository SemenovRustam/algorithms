package com.semenov.yandex.practicum.sprint3

fun main() {
    val size = readln().toInt()

    if (size == 0) {
        println(0)
        return
    }
    val array = readln().split(" ").map { it.toInt() }.toIntArray()

    val sortColors = sortColors(array, size)

    println(sortColors.joinToString(" "))

}

private fun sortColors(array: IntArray, size: Int): IntArray {
    var pink = 0
    var yellow = 0
    var green = 0

    for (color in array) {
        when (color) {
            0 -> ++pink
            1 -> ++yellow
            2 -> ++green
        }
    }

    val sortedArray = IntArray(size)
    var index = 0

    repeat(pink) {
        sortedArray[index++] = 0
    }

    repeat(yellow) {
        sortedArray[index++] = 1
    }

    repeat(green) {
        sortedArray[index++] = 2
    }

    return sortedArray
}

/**

Рита решила оставить у себя одежду только трёх цветов: розового, жёлтого и малинового.
После того как вещи других расцветок были убраны, Рита захотела отсортировать свой новый гардероб по цветам.
Сначала должны идти вещи розового цвета, потом —– жёлтого, и в конце —– зеленый.
Помогите Рите справиться с этой задачей.

Примечание: попробуйте решить задачу за один проход по массиву!

Формат ввода
В первой строке задано количество предметов в гардеробе: n –— оно не превосходит 1000000.
Во второй строке даётся массив, в котором указан цвет для каждого предмета.
Розовый цвет обозначен 0, жёлтый —– 1, зеленый –— 2.

Формат вывода
Нужно вывести в строку через пробел цвета предметов в правильном порядке.

Пример 1
Ввод
7
0 2 1 2 0 0 1
Вывод
0 0 0 1 1 2 2

Пример 2
Ввод
5
2 1 2 0 1
Вывод
0 1 1 2 2

Пример 3
Ввод
6
2 1 1 2 0 2
Вывод
0 1 1 2 2 2

 */