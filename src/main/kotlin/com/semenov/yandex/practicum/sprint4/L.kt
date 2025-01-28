package com.semenov.yandex.practicum.sprint4

fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val inputString = readln()

    val base = 345L
    val mod = 5608713984039443L

    val hashToPos = mutableMapOf<Long, Int>()
    val counter = mutableMapOf<Long, Int>()
    val result = mutableListOf<Int>()
    val power = getPower(n, base, mod)

    var hash = getHash(inputString.take(n), base, mod)
    counter[hash] = 1
    hashToPos[hash] = 0

    for (i in 1..(inputString.length - n)) {
        hash = (hash + mod - inputString[i - 1].code * power % mod) % mod
        hash = (hash * base % mod + inputString[i + n - 1].code) % mod

        counter[hash] = counter.getOrDefault(hash, 0) + 1

        if (counter[hash] == 1) {
            hashToPos[hash] = i
        }

        if (counter[hash] == k) {
            result.add(hashToPos[hash]!!)
        }
    }

    println(result.joinToString(" "))
}

private fun getHash(str: String, base: Long, mod: Long): Long {
    var hash = 0L
    for (i in str.indices) {
        hash = (hash * base % mod + str[i].code) % mod
    }
    return hash
}

private fun getPower(n: Int, base: Long, mod: Long): Long {
    var power = 1L
    for (i in 1 until n) {
        power = (power * base) % mod
    }
    return power
}




