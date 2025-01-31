fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    val inputs = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(total) { false }
    var result = BooleanArray(2000001)
    dfs(result, inputs, total, depth = 0, visited, startIndex = 0, 0)

    for ((index, value) in result.withIndex()) {
        if (!value) {
            bw.write("${index}\n")
            break
        }
    }

    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    result: BooleanArray,
    inputs: List<Int>,
    total: Int,
    depth: Int,
    visited: BooleanArray,
    startIndex: Int,
    sum: Int
) {
    result[sum] = true

    for (index in startIndex..<inputs.size) {
        if (!visited[index]) {
            val value = inputs[index]
            visited[index] = true
            dfs(result, inputs, total, depth + 1, visited, index, sum + value)
            visited[index] = false
        }
    }

}