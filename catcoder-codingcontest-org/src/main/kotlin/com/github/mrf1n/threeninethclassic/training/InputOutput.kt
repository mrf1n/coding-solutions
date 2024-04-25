package com.github.mrf1n.threeninethclassic.training

import java.io.*
import java.util.*

internal class InputReader private constructor(s: InputStream) {
    private val reader: BufferedReader = BufferedReader(InputStreamReader(s))
    private var tokenizer: StringTokenizer? = null

    init {
        initTokenizer()
    }

    private fun initTokenizer() {
        while (tokenizer == null || !tokenizer!!.hasMoreElements()) {
            try {
                tokenizer = StringTokenizer(reader.readLine())
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }

    fun next(): String {
        initTokenizer()
        return tokenizer!!.nextToken()
    }

    fun nextInt(): Int {
        return next().toInt()
    }

    fun nextLong(): Long {
        return next().toLong()
    }

    fun nextDouble(): Double {
        return next().toDouble()
    }

    fun nextLine(): String {
        var str = ""
        try {
            str = reader.readLine()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return str
    }

    fun hasNextToken(): Boolean {
        return tokenizer != null && tokenizer!!.hasMoreElements()
    }

    companion object {
        fun fromResource(path: String): InputReader {
            return InputReader(InputReader::class.java.getResourceAsStream(path)!!)
        }

        fun fromFile(path: String): InputReader {
            try {
                return InputReader(FileInputStream(path))
            } catch (e: FileNotFoundException) {
                throw RuntimeException(e)
            }
        }

        fun fromString(s: String): InputReader {
            return InputReader(ByteArrayInputStream(s.toByteArray()))
        }

        fun fromInputStream(`is`: InputStream?): InputReader {
            return InputReader(`is`!!)
        }

        fun fromSystemIn(): InputReader {
            return InputReader(System.`in`)
        }
    }
}

internal class OutputWriter: Closeable, Flushable {
    private var writer: Writer

    private constructor(os: OutputStream) {
        writer = PrintWriter(os, true)
    }

    private constructor(fw: Writer) {
        writer = fw
    }

    fun printStr(obj: String?) {
        try {
            obj?.let {
                writer.write(it)
                writer.flush()
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    fun print(obj: Any) {
        printStr(obj.toString())
    }

    fun println() {
        print(System.lineSeparator())
    }

    fun println(obj: Any) {
        print(obj)
        println()
    }

    override fun close() {
        try {
            writer.close()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    override fun flush() {
        try {
            writer.flush()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    companion object {

        fun fromOutputStream(os: OutputStream): OutputWriter {
            return OutputWriter(os)
        }

        fun fromSystemOut(): OutputWriter {
            return OutputWriter(System.out)
        }

        fun fromFile(path: String): OutputWriter {
            try {
                return OutputWriter(FileOutputStream(path))
            } catch (e: FileNotFoundException) {
                throw RuntimeException(e)
            }
        }

        @JvmOverloads
        fun fromResource(path: String, append: Boolean = false): OutputWriter {
            try {
                val fileName = Objects.requireNonNull(OutputWriter::class.java.getResource(path)).file
                val os = FileOutputStream(fileName)
                return OutputWriter(os)
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }
}
