import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var total = br.readLine().toInt()
    val intInputs = br.readLine().split(" ").map { it.toLong() }
    val calInputs = br.readLine().split(" ").map { it.toInt() }
    val calToList = mutableListOf<String>()
    for (i in 0 until calInputs[0].toInt()) {
        calToList.add("+")
    }
    for (i in 0 until calInputs[1].toInt()) {
        calToList.add("-")
    }
    for (i in 0 until calInputs[2].toInt()) {
        calToList.add("*")
    }
    for (i in 0 until calInputs[3].toInt()) {
        calToList.add("/")
    }
    val visited = BooleanArray(calToList.size) { false }
    val result = mutableListOf<Long>()

    dfs(
        depth = 0,
        total = total - 1,
        result = result,
        calToList = calToList,
        visited = visited,
        intInputs = intInputs,
        sum = intInputs[0].toLong(),
        startIndex = 0
    )

    bw.write("${result.maxOrNull()}\n")
    bw.write("${result.minOrNull()}\n")


    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    depth: Int,
    total: Int,
    result: MutableList<Long>,
    calToList: MutableList<String>,
    visited: BooleanArray,
    intInputs: List<Long>,
    sum: Long,
    startIndex: Int
) {
    if (depth == total) {
        result.add(sum)
        return
    }

//    for (index in startIndex until calToList.size) {
    for ((index,expression ) in calToList.withIndex()) {
        if (!visited[index]) {
            visited[index] = true
//            val expression = calToList[index]
            val target = intInputs[depth + 1]
            val sumResult = calculate(sum, target, expression)
            dfs(depth + 1, total, result, calToList, visited, intInputs, sumResult, index + 1)
            visited[index] = false
        }
    }
}

fun calculate(target1: Long, target2: Long, expression: String): Long {
    when (expression) {
        "+" -> return target1 + target2
        "-" -> return target1 - target2
        "*" -> return target1 * target2
        "/" -> {
            return if (target1 < 0) {
                -(abs(target1) / target2)
            } else {
                target1 / target2
            }
        }
    }
    return 0
}