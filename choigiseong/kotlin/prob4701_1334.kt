import kotlin.math.abs

fun main(args: Array<String>) {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    val inputs = Array<IntArray>(total) { IntArray(4) }

    for (i in 0 until total) {
        inputs[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val result = mutableListOf<Int>()
    dfs(
        depth = 0,
        result = result,
        total = total,
        inputs = inputs,
        aArray = mutableListOf(),
        bArray = mutableListOf()
    )

    bw.write("${result.minOrNull()}\n")

    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    depth: Int,
    result: MutableList<Int>,
    total: Int,
    inputs: Array<IntArray>,
    aArray: MutableList<Int>,
    bArray: MutableList<Int>
) {

    if (depth == total) {
        var sumA = 0
        var sumB = 0
        for (index in 0 until total / 2) {
            for (jndex in index + 1 until total / 2) {
                sumA += inputs[aArray[index]][aArray[jndex]] + inputs[aArray[jndex]][aArray[index]]
                sumB += inputs[bArray[index]][bArray[jndex]] + inputs[bArray[jndex]][bArray[index]]
            }
        }
        result.add(abs(sumA - sumB))
        return
    }

    if (aArray.size < total / 2) {
        val newArray = aArray.toMutableList()
        newArray.add(depth)
        dfs(depth + 1, result, total, inputs, newArray, bArray)
    }

    if (bArray.size < total / 2) {
        val newArray = bArray.toMutableList()
        newArray.add(depth)
        dfs(depth + 1, result, total, inputs, aArray, newArray)
    }

}