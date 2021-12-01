import java.io.File

fun main() {
    val input = File("input.txt").readLines().map { it.toInt() }
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println("kotlin")
    println(answer)
}

fun solutionPart1(input: List<Int>): String {   // Stupid but works
    var lastValue = 0
    return input.sumOf { v ->
        var isLarger = 0
        if (v > lastValue) {
            isLarger = 1
        }
        lastValue = v
        isLarger
    }.minus(1).toString()
}

fun solutionPart2(input: List<Int>): String {
    return input.mapIndexed{ index, _ ->
        var isLarger = 0
        val lastSum = input.sumSlice(index-3, index)
        val currentSum = input.sumSlice(index-2, index+1)
        if (currentSum > lastSum) {
            isLarger = 1
        }
        isLarger
    }.sum().minus(1).toString()

}

fun List<Int>.sumSlice(index1: Int, index2: Int): Int {
    return if (index1 >= 0) subList(index1, index2).sum() else 0

}