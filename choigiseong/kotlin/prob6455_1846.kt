import java.util.ArrayDeque
import java.util.LinkedList

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    while (true) {
        var input = br.readLine().split(" ").map { it.toInt() }
        if (input[0] == 0) {
            break
        }
        input = input.subList(1, input.size)
        val visited = BooleanArray(input.size) { false }
        val result = mutableListOf<String>()
        dfs(result, 0, input, visited, mutableListOf(), 0)
        for (value in result) {
            bw.write("$value\n")
        }
        bw.write("\n")
    }


    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    result: MutableList<String>,
    depth: Int,
    input: List<Int>,
    visited: BooleanArray,
    userInput: MutableList<Int>,
    startIndex: Int
) {
    if (depth == 6) {
        result.add(userInput.joinToString(" "))
        return
    }

    for (index in startIndex ..<input.size) {
        val value = input[index]
        if (!visited[index]) {
            visited[index] = true
            val newUserInput = userInput.toMutableList()
            newUserInput.add(value)
            dfs(result, depth + 1, input, visited, newUserInput, index)
            visited[index] = false
        }
    }
}