var max = 0

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    var inputs = br.readLine().split(" ").map { it.toInt() }

    dfs(depth = 1, inputs, sum = 0)

    bw.write("$max")


    bw.flush()
    br.close()
    bw.close()
}

fun dfs(depth: Int, inputs: List<Int>, sum: Int) {
    if (depth == inputs.size) {
        max = max.coerceAtLeast(sum)
        return
    }

    if (depth - 1 >= 0 && depth + 1 < inputs.size) {
        val sumResult = sum +(inputs[depth - 1] * inputs[depth + 1])
        val newInputs = inputs.toMutableList()
        newInputs.removeAt(depth)
        max = max.coerceAtLeast(sumResult)
        dfs(depth = 1, newInputs, sumResult)
    }

    dfs(depth + 1, inputs, sum)
}