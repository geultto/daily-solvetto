fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    val sign = br.readLine().split(" ")

    val visited = BooleanArray(11)
    val result = mutableListOf<String>()
    dfs(depth = 0, total = total, sign = sign, visited = visited, result = result, previous = 0, sum = "")


    bw.write(result.max() + "\n")
    bw.write(result.min())

    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    depth: Int,
    total: Int,
    sign: List<String>,
    visited: BooleanArray,
    result: MutableList<String>,
    previous: Int,
    sum: String
) {
    val inputs = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    if (depth == total + 1) {
        result.add(sum)
        return
    }

    for ((index, value) in inputs.withIndex()) {
        if (!visited[index]) {
            visited[index] = true
            if (depth == 0) {
                dfs(
                    depth + 1,
                    total,
                    sign,
                    visited,
                    result,
                    value,
                    "$value"
                )
            } else {
                val singleSign = sign[depth - 1]
                if (singleSign == ">") {
                    if (previous > value) {
                        dfs(
                            depth + 1,
                            total,
                            sign,
                            visited,
                            result,
                            value,
                            sum + "$value"
                        )
                    }
                }

                if (singleSign == "<") {
                    if (previous < value) {
                        dfs(
                            depth + 1,
                            total,
                            sign,
                            visited,
                            result,
                            value,
                            sum + "$value"
                        )
                    }
                }
            }


            visited[index] = false
        }
    }

}