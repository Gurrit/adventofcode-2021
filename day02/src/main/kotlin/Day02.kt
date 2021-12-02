import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println("kotlin")
    println(answer)
}

fun solutionPart1(input: List<String>): String {   // Stupid but works
    var elev = 0
    var horizontal = 0
    input.map { splitLine(it) }
        .forEach {
            val d = it.second.toInt()
            when(it.first) {
                "up" -> elev -= d
                "down" -> elev += d
                "forward" -> horizontal += d
            }
        }
    return (elev*horizontal).toString()
}

fun solutionPart2(input: List<String>): String {
    var depth = 0
    var horizontal = 0
    var aim = 0
    input.map { splitLine(it) }
        .forEach {
            val d = it.second.toInt()
            when (it.first) {
                "up" -> aim -= d
                "down" -> aim += d
                "forward" -> {
                    depth += d
                    horizontal += aim * d
                }
            }
        }
    return (depth*horizontal).toString()
}

fun splitLine(input: String): Pair<String, String> {
    val strList = input.split(" ")
    return strList[0] to strList[1]
}