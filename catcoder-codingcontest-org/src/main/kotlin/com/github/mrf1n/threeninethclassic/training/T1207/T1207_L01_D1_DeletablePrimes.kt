package com.github.mrf1n.threeninethclassic.training.T1207

import java.util.stream.IntStream
import kotlin.math.sqrt

fun main() {
    val numbers = listOf(
        "4125673",
        "41256793",
        "337424981",
        "537430451",
        "200899998",
        "537499093",
        "2147483059",
        "410256793",
        "567629137",
        "46216567629137",
    )
    numbers.forEach {
        println(it + " " + countSubPrimes(it))
    }
}

fun countSubPrimes(number: String): Int {
    return if (number.isNotEmpty() && number.isPrime()) {
        when {
            number.length == 1 -> 1
            number.length > 1 -> {
                var count = 0
                for (i in number.indices) {
                    val subNumber = number.removeRange(IntRange(i, i))
                    count += countSubPrimes(subNumber)
                }
                count
            }

            else -> 0
        }
    } else 0
}

fun String.isPrime(): Boolean = isPrime(this.toLong())

fun isPrime(number: Long): Boolean {
    return if (number > 1) IntStream.rangeClosed(2, sqrt(number.toDouble()).toInt())
        .noneMatch { n: Int -> (number % n == 0L) } else false
}

