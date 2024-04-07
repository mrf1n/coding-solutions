package com.github.mrf1n

import java.io.BufferedInputStream
import java.io.File
import java.io.PrintWriter
import kotlin.system.measureTimeMillis
import kotlin.math.absoluteValue
import kotlin.random.Random
import kotlin.random.nextInt

// 1. Modded
fun Int.adjust(): Int {
    if (this >= p) {
        return this - p
    } else if (this < 0) {
        return this + p
    }
    return this
}

fun Int.byMod(): Int {
    return if (this >= p) {
        this - p
    } else this
}

infix fun Int.modMultiply(b: Int): Int {
    return ((this.toLong() * b) % p).toInt()
}

infix fun Int.modPlus(b: Int): Int {
    val ans = this + b
    return if (ans >= p) ans - p else ans
}

infix fun Int.modSubtract(b: Int): Int {
    val ans = this - b
    return if (ans < 0) ans + p else ans
}

fun Long.modded(): Int = (this % p).toInt().adjust()
fun Int.inverse(): Int = intPow(this, p - 2)
fun Int.additiveInverse(): Int = if (this == 0) 0 else p - this
infix fun Int.modDivide(b: Int): Int {
    return this modMultiply (b.inverse())
}

fun intPow(initX: Int, initE: Int): Int {
    var x = initX
    var e = initE
    var result = 1
    while (e > 0) {
        if (e and 1 == 1) result = result modMultiply x
        x = x modMultiply x
        e = e shr 1
    }
    return result
}

// 2. DP initial values
const val plarge = 1_000_000_727
const val nlarge = -plarge
const val phuge = 2_727_000_000_000_000_000L
const val nhuge = -phuge

// 3. convenience conversions
val Boolean.toInt: Int get() = if (this) 1 else 0
val BooleanArray.toInts: IntArray get() = IntArray(this.size) { this[it].toInt }
val Char.alphabetCode: Int get() = this.code - 'a'.code

//3. hard to write stuff
fun IntArray.put(i: Int, v: Int) {
    this[i] = (this[i] + v).adjust()
}

val mint: MutableList<Int> get() = mutableListOf()
val mong: MutableList<Long> get() = mutableListOf()
val mchar: MutableList<Char> get() = mutableListOf()
fun IntArray.minindex(): Int = this.indexOf(this.minOrNull()!!)
fun IntArray.maxindex(): Int = this.indexOf(this.maxOrNull()!!)

//4. more outputs
fun List<Char>.concat(): String = this.joinToString("")
val CharArray.concat: String get() = this.concatToString()
val IntArray.concat: String get() = this.joinToString(" ")

@JvmName("concatInt")
fun List<Int>.concat(): String = this.joinToString(" ")
val LongArray.concat: String get() = this.joinToString(" ")

@JvmName("concatLong")
fun List<Long>.concat(): String = this.joinToString(" ")

@JvmName("concatString")
fun List<String>.concat(): String = this.joinToString("")
//5. Pair of ints
typealias pii = Pair<Int, Int>
typealias pll = Pair<Long, Long> //Nb perm is the worst

fun order(a: Int, b: Int): Pair<Int, Int> = Pair(minOf(a, b), maxOf(a, b))

//6. strings
val String.size get() = this.length
const val randCount = 100

//7. bits
fun Int.has(i: Int): Boolean = (this and (1 shl i) != 0)
fun Long.has(i: Int): Boolean = (this and (1L shl i) != 0L)

//8 Benchmark
inline fun benchmark(f: () -> Unit) {
    val t = measureTimeMillis { f() }
    println("$t ms")
}

//9 rand
fun rand(x: Int) = Random.nextInt(x)
fun rand(x: IntRange) = Random.nextInt(x)
fun dist(a: Int, b: Int): Int = (a - b).absoluteValue
fun dist(a: Long, b: Long): Long = (a - b).absoluteValue

//10 typing issues, rename
typealias Ints = IntArray
typealias Longs = LongArray
typealias Bools = BooleanArray

inline fun assert(x: Boolean, act: () -> Any = {}) {
    if (!x) error(act())
}

const val interactive = false

object Reader {
    private const val BS = 1 shl 16
    private const val NC = 0.toChar()
    private val buf = ByteArray(BS)
    private var bId = 0
    private var size = 0
    private var c = NC
    var warningActive = true
    var fakein = StringBuilder()
    private var IN: BufferedInputStream = BufferedInputStream(System.`in`, BS)
    val OUT: PrintWriter = PrintWriter(System.out)
    private val char: Char
        get() {
            if (interactive) {
                return System.`in`.read().toChar()
            }
            while (bId == size) {
                size = IN.read(buf) // no need for checked exceptions
                if (size == -1) return NC
                bId = 0
            }
            return buf[bId++].toChar()
        }

    fun nextInt(): Int {
        var neg = false
        if (c == NC) c = char
        while (c < '0' || c > '9') {
            if (c == '-') neg = true
            c = char
        }
        var res = 0
        while (c in '0'..'9') {
            res = (res shl 3) + (res shl 1) + (c - '0')
            c = char
        }
        return if (neg) -res else res
    }

    fun nextLong(): Long {
        var neg = false
        if (c == NC) c = char
        while (c < '0' || c > '9') {
            if (c == '-') neg = true
            c = char
        }
        var res = 0L
        while (c in '0'..'9') {
            res = (res shl 3) + (res shl 1) + (c - '0')
            c = char
        }
        return if (neg) -res else res
    }

    fun nextString(): String {
        val ret = StringBuilder()
        while (true) {
            c = char
            if (!isWhitespace(c)) {
                break
            }
        }
        ret.append(c)
        while (true) {
            c = char
            if (isWhitespace(c)) {
                break
            }
            ret.append(c)
        }
        return ret.toString()
    }

    fun isWhitespace(c: Char): Boolean {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t'
    }

    fun rerouteInput() {
        if (warningActive) {
//            put("Custom test enabled")
            println("Custom test enabled")
            warningActive = false
        }
        val S = fakein.toString()
        println("New Case ")
        println(S.take(80))
        println("...")
        fakein.clear()
        IN = BufferedInputStream(S.byteInputStream(), BS)
    }

    fun flush() {
        OUT.flush()
    }

    fun takeFile(name: String) {
        IN = BufferedInputStream(File(name).inputStream(), BS)
    }
}

const val p = 1_000_000_007


fun readString() = readLine()!!
fun readStrings() = readString().split(" ")
fun readInt() = readString().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readString().toLong()
fun readLongs() = readStrings().map { it.toLong() }
fun readDouble() = readString().toDouble()
fun readDoubles() = readStrings().map { it.toDouble() }

fun main() {
}