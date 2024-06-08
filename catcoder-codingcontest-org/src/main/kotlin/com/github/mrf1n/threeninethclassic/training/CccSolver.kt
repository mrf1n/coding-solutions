package com.github.mrf1n.threeninethclassic.training

import java.io.File

interface CccSolver {
    val solutionWrapper: CccSolutionWrapper
    fun solve()
}

class CccSolutionWrapper(taskCode: String, taskName: String, level: Int, val checkAnswer: Boolean = true) {
    private var levelFolder = File(initIOFolders(taskCode, level), "level$level")

    fun runLevel(action: (fileName: String, inputStream: InputReader, outputStream: OutputWriter) -> Unit) {
        val inFolder = File(levelFolder, "in")
        val outFolder = File(levelFolder, "out")
        val ansFolder = File(levelFolder, "ans")
        val inList = inFolder.listFiles { _, name -> name.endsWith(".in") } ?: arrayOf()

        for (inputFile in inList) {
            val outputFile = File(outFolder, "${inputFile.nameWithoutExtension}.out")

            val inputStream = inputFile.inputStream()
            val outputStream = outputFile.outputStream()
            inputStream.use {
                outputStream.use {
                    action(
                        inputFile.nameWithoutExtension,
                        InputReader.fromInputStream(inputStream),
                        OutputWriter.fromOutputStream(outputStream)
                    )
                }
            }

            val answerFile = File(ansFolder, "${inputFile.nameWithoutExtension}.out")
            if (answerFile.exists() && checkAnswer) {
                compareOutAndAns(outputFile, answerFile)
            }
        }
    }

    companion object {
        private fun initIOFolders(taskCode: String, numberOfLevels: Int): File {
            val rootPath = {}.javaClass.getResource("")?.file
                ?.replace("build/classes/kotlin/main", "src/main/resources")
                ?: ""
            val rootFolder = File(rootPath)
            rootFolder.createIfNotExists()

            val taskFamilyFolder = File(rootFolder, taskCode)
            taskFamilyFolder.createIfNotExists()

            for (i in 1 until numberOfLevels + 1) {
                val levelXFolder = File(taskFamilyFolder, "level$i")
                levelXFolder.createIfNotExists()
                val levelXInFolder = File(levelXFolder, "in")
                levelXInFolder.createIfNotExists()
                val levelXOutFolder = File(levelXFolder, "out")
                levelXOutFolder.createIfNotExists()
                val levelXAnsFolder = File(levelXFolder, "ans")
                levelXAnsFolder.createIfNotExists()
            }
            return taskFamilyFolder
        }

        private fun compareOutAndAns(outputFile: File, answerFile: File) {
            val outLines = outputFile.readLines()
            val ansLines = answerFile.readLines()

            val minLength = minOf(outLines.size, ansLines.size)

            var differencesFound = false

            for (i in 0 until minLength) {
                if (outLines[i] != ansLines[i]) {
                    println("Difference found at line ${i + 1}:")
                    println("Output: \"${outLines[i]}\"")
                    println("Answer: \"${ansLines[i]}\"")
                    println()
                    differencesFound = true
                }
            }

            if (differencesFound) {
                println("Files ${outputFile.nameWithoutExtension}.out are different.")
            } else {
                println("Files ${outputFile.nameWithoutExtension}.out are identical.")
            }
        }

        private fun File.createIfNotExists() {
            if (!this.exists()) {
                this.mkdirs()
            }
        }
    }
}
