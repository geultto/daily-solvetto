import kotlin.math.abs

var result = 0
fun main(args: Array<String>) {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val opers = br.readLine().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    dfs(
        depth = 1,
        total = total,
        inputs = inputs,
        opers = opers,
        result = result,
        sum = inputs[0],
        plus = opers[0],
        minus = opers[1],
        mul = opers[2],
        div = opers[3]
    )

    result.sort()
    bw.write("${result.last()}\n")
    bw.write("${result.first()}\n")


    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    depth: Int,
    total: Int,
    inputs: List<Int>,
    opers: List<Int>,
    result: MutableList<Int>,
    sum: Int,
    plus: Int,
    minus: Int,
    mul: Int,
    div: Int
) {

    if (depth == total) {
        result.add(sum)
        return
    }

    if (plus > 0) {
        dfs(
            depth + 1,
            total,
            inputs,
            opers,
            result,
            sum + inputs[depth],
            plus - 1,
            minus,
            mul,
            div
        )
    }

    if (minus > 0) {
        dfs(
            depth + 1,
            total,
            inputs,
            opers,
            result,
            sum - inputs[depth],
            plus,
            minus - 1,
            mul,
            div
        )
    }

    if (mul > 0) {
        dfs(
            depth + 1,
            total,
            inputs,
            opers,
            result,
            sum * inputs[depth],
            plus,
            minus,
            mul - 1,
            div
        )
    }

    if (div > 0) {
        //c++  div
        val sumr = if (inputs[depth] < 0) {
            (sum / abs(inputs[depth])) * -1
        } else {
            sum / inputs[depth]
        }


        dfs(
            depth + 1,
            total,
            inputs,
            opers,
            result,
            sumr,
            plus,
            minus,
            mul,
            div - 1
        )
    }
}