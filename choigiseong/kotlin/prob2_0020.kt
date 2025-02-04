import java.util.*
import kotlin.math.abs

var min: Long? = null
var max: Long? = null

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var total = br.readLine().toInt()
    val intInputs = br.readLine().split(" ").map { it.toLong() }
    val calInputs = br.readLine().split(" ").map { it.toInt() }
    dfs(
        depth = 1,
        total = total,
        intInputs = intInputs,
        sum = intInputs[0].toLong(),
        add = calInputs[0],
        minus = calInputs[1],
        multiply = calInputs[2],
        divide = calInputs[3],
    )

    bw.write("${max}\n")
    bw.write("${min}\n")


    bw.flush()
    br.close()
    bw.close()
}

fun dfs(depth: Int, total: Int, intInputs: List<Long>, sum: Long, add: Int, minus: Int, multiply: Int, divide: Int) {

    if (depth == total) {
        if (min == null) {
            min = sum
        } else if (min!! > sum) {
            min = sum
        }

        if (max == null) {
            max = sum
        } else if (max!! < sum) {
            max = sum
        }
        return
    }

    if (add > 0) {
        val sumResult = calculate(sum, intInputs[depth], "+")
        dfs(depth + 1, total, intInputs, sumResult, add - 1, minus, multiply, divide)
    }

    if (minus > 0) {
        val sumResult = calculate(sum, intInputs[depth], "-")
        dfs(depth + 1, total, intInputs, sumResult, add, minus - 1, multiply, divide)
    }

    if (multiply > 0) {
        val sumResult = calculate(sum, intInputs[depth], "*")
        dfs(depth + 1, total, intInputs, sumResult, add, minus, multiply - 1, divide)
    }

    if (divide > 0) {
        val sumResult = calculate(sum, intInputs[depth], "/")
        dfs(depth + 1, total, intInputs, sumResult, add, minus, multiply, divide - 1)
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