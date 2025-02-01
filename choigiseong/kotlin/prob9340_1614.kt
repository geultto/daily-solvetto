import java.util.ArrayDeque
import java.util.LinkedList

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, s) = br.readLine().split(" ").map { it.toLong() }
    val inputs = br.readLine().split(" ").map { it.toLong() }
    val visited = BooleanArray(n.toInt()) { false }
    val result = mutableListOf<List<Long>>()
    dfs(0, n, s, inputs, visited, result, mutableListOf(), startIndex = 0)
    bw.write("${result.size}\n")

    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    depth: Long,
    n: Long,
    s: Long,
    inputs: List<Long>,
    visited: BooleanArray,
    result: MutableList<List<Long>>,
    userInputs: MutableList<Long>,
    startIndex: Int
) {
    if (userInputs.sum() == s && userInputs.isNotEmpty()) {
        result.add(userInputs)
    }
    if (depth == n) {
        return
    }

//    for ((index,value) in inputs.withIndex()) {
    for (index in startIndex ..<inputs.size) {
        val value = inputs[index]
        if (!visited[index]) {
            visited[index] = true
            val newUserInput = userInputs.toMutableList()
            newUserInput.add(value)
            dfs(depth + 1, n, s, inputs, visited, result, newUserInput, index)
            visited[index] = false
        }
    }
}