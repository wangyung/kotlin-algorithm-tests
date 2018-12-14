package idv.freddie.tests

import java.io.File

fun main(args: Array<String>) {

    val inputFile = File("advent2018_day8_input.txt")
    val content = inputFile.readLines()
    val input = content[0].split(" ").map { it.toInt() }

    AdventCode2018Day8().exec(input)
}
