package com.semenov.yandex.practicum.sprint3

fun main() {
    val childrens = readln().toInt()
    val greedFactor = readln().split(" ").map { it.toInt() }
    val cookies = readln().toInt()
    val cookiesSize = readln().split(" ").map { it.toInt() }

    val happyChildrens = getHappyChildrens(childrens, greedFactor, cookies, cookiesSize)

    println(happyChildrens)
}

private fun getHappyChildrens(childrens: Int, greedFactor: List<Int>, cookies: Int, cookiesSize: List<Int>): Int {
    var happyCount = 0
    val sortedGreedFactor = greedFactor.sorted()
    val sortedCookies = cookiesSize.sorted()
    var cookiesIndex = 0

    for (greed in sortedGreedFactor) {
        for (index in cookiesIndex until sortedCookies.size) {
            cookiesIndex++
            if (sortedCookies[index] >= greed) {
                happyCount++
                break
            }
        }
    }
    return happyCount
}


/**

К Васе в гости пришли одноклассники. Его мама решила угостить ребят печеньем.

Но не всё так просто. Печенья могут быть разного размера.
А у каждого ребёнка есть фактор жадности —– минимальный размер печенья, которое он возьмёт.
Нужно выяснить, сколько ребят останутся довольными в лучшем случае, когда они действуют оптимально.

Каждый ребёнок может взять не больше одного печенья.

Формат ввода
В первой строке записано n —– количество детей.

Во второй —– n чисел, разделённых пробелом, каждое из которых –— фактор жадности ребёнка.
Это натуральные числа, не превосходящие 1000.

В следующей строке записано число m –— количество печенек.

Далее —– m натуральных чисел, разделённых пробелом —– размеры печенек.
Размеры печенек не превосходят 1000.

Оба числа n и m не превосходят 10000.

Формат вывода
Нужно вывести одно число –— количество детей, которые останутся довольными

Пример 1
Ввод
2
1 2
3
2 1 3
Вывод
2

Пример 2
Ввод
3
2 1 3
2
1 1

Вывод
1
 */
