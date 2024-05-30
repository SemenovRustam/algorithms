package com.semenov.yandex.practicum.algorithms.algorithms.sprint1

data class Matrix(val n: Int, val m: Int, val data: List<IntArray>)

fun main() {
    val matrix = readMatrix()
    val x = readln().toInt()
    val y = readln().toInt()
    val neighbours = getNeighbours(matrix, x, y)
    neighbours.forEach { print("$it ") }
}

private fun getNeighbours(matrix: Matrix, x: Int, y: Int): List<Int> {
    val left = matrix.getLeft(x, y)
    val right = matrix.getRight(x, y)
    val up = matrix.getUp(x, y)
    val down = matrix.getDown(x, y)

    return listOfNotNull(left, right, up, down).sorted()
}

fun readMatrix(): Matrix {
    val n = readInt()
    val m = readInt()
    val matrix = buildList(n) {
        for (i in 0 until n) {
            add(readInts().toIntArray())
        }
    }
    return Matrix(n, m, matrix)
}

private fun Matrix.getLeft(x: Int, y: Int): Int? {
    return if (y - 1 < 0) {
        null
    } else {
        this.data[x][y - 1]
    }
}

private fun Matrix.getRight(x: Int, y: Int): Int? {
    return if (y + 1 > this.m - 1) {
        null
    } else {
        this.data[x][y + 1]
    }
}

private fun Matrix.getUp(x: Int, y: Int): Int? {
    return if (x - 1 < 0) {
        null
    } else {
        this.data[x - 1][y]
    }
}

private fun Matrix.getDown(x: Int, y: Int): Int? {
    return if (x + 1 > this.n - 1) {
        null
    } else {
        this.data[x + 1][y]
    }
}


private fun readStr() = readln()
private fun readInt() = readStr().toInt()
private fun readStrings() = readStr().split(" ")
private fun readInts() = readStrings().map { it.toInt() } // list of ints

/**
Дана матрица. Нужно написать функцию, которая для элемента возвращает всех его соседей.
Соседним считается элемент, находящийся от текущего на одну ячейку влево, вправо,
вверх или вниз. Диагональные элементы соседними не считаются.

Например, в матрице A соседними элементами для (0, 0) будут 2 и 0. А для (2, 1) –— 1, 2, 7, 7.



Формат ввода
В первой строке задано n — количество строк матрицы. Во второй — количество столбцов m.
Числа m и n не превосходят 1000. В следующих n строках задана матрица.
Элементы матрицы — целые числа, по модулю не превосходящие 1000.
В последних двух строках записаны координаты элемента, соседей которого нужно найти.
Индексация начинается с нуля.

Формат вывода
Напечатайте нужные числа в возрастающем порядке через пробел.

Пример 1
Ввод	Вывод
4       7 7
3
1 2 3
0 2 6
7 4 1
2 7 0
3
0

Пример 2
Ввод	Вывод
4       0 2
3
1 2 3
0 2 6
7 4 1
2 7 0
0
0

 * */