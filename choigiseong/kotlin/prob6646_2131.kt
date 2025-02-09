import kotlin.math.abs

var max = 0

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    val v1 = BooleanArray(total * 2)
    val v2 = BooleanArray(total * 2)
    val v3 = BooleanArray(total * 2)

    dfs(depth = 0, total = total, v1 = v1, v2 = v2, v3 = v3)

    bw.write("$max")

    bw.flush()
    br.close()
    bw.close()
}

fun dfs(depth: Int, total: Int, v1: BooleanArray, v2: BooleanArray, v3: BooleanArray) {
    if (depth == total) {
        max++
        return
    }

    for (jndex in 0 until total) {
        if (!v1[jndex] && !v2[depth + jndex] && !v3[depth - jndex + total]) {
            v1[jndex] = true
            v2[depth + jndex] = true
            v3[depth - jndex + total] = true
            dfs(depth = depth + 1, total = total, v1 = v1, v2 = v2, v3 = v3)
            v1[jndex] = false
            v2[depth + jndex] = false
            v3[depth - jndex + total] = false
        }
    }
}