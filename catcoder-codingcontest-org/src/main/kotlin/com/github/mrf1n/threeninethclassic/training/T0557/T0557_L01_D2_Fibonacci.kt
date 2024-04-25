package com.github.mrf1n.threeninethclassic.training.T0557

fun main() {
    val numbers = listOf(
        6,
        19,
        28,
        36,
        38,
    )
    numbers.forEach {
        println("$it ${fib(it)}")
    }
}

var cache: MutableMap<Int, Int> = HashMap()

fun fib(n: Int): Int {
    if (cache.containsKey(n)) {
        return cache[n]!!
    }

    val result = if (n < 2) {
        n
    } else {
        fib(n - 1) + fib(n - 2)
    }

    cache[n] = result
    return result
}
