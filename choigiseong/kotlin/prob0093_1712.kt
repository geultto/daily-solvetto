import java.util.ArrayDeque
import java.util.LinkedList

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine()!!.split(" ").map { it.toInt() }
    val array = Array(m) { IntArray(n) { 0 } }
    val visited = Array(m) { BooleanArray(n) { false } }
    var result = 100000
    val q = ArrayDeque<Triple<Int, Int, Int>>()

    for (i in 0..<m) {
        array[i] = br.readLine()!!.split("").filter { it != "" }.map { it.toInt() }.toIntArray()
    }
    q.add(Triple(0, 0, 0))
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val (i, j, cnt) = q.pollLast()
        if (i == m - 1 && j == n - 1) {
            result = minOf(result, cnt)
            continue
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && array[i - 1][j] == 0) {
            visited[i - 1][j] = true
            q.addLast(Triple(i - 1, j, cnt))
        }
        if (i + 1 < m && !visited[i + 1][j] && array[i + 1][j] == 0) {
            visited[i + 1][j] = true
            q.addLast(Triple(i + 1, j, cnt))
        }

        if (j - 1 >= 0 && !visited[i][j - 1] && array[i][j - 1] == 0) {
            visited[i][j - 1] = true
            q.addLast(Triple(i, j - 1, cnt))
        }
        if (j + 1 < n && !visited[i][j + 1] && array[i][j + 1] == 0) {
            visited[i][j + 1] = true
            q.addLast(Triple(i, j + 1, cnt))
        }

        if (i - 1 >= 0 && !visited[i - 1][j] && array[i - 1][j] == 1) {
            visited[i - 1][j] = true
            q.addFirst(Triple(i - 1, j, cnt + 1))
        }

        if (i + 1 < m && !visited[i + 1][j] && array[i + 1][j] == 1) {
            visited[i + 1][j] = true
            q.addFirst(Triple(i + 1, j, cnt + 1))
        }

        if (j - 1 >= 0 && !visited[i][j - 1] && array[i][j - 1] == 1) {
            visited[i][j - 1] = true
            q.addFirst(Triple(i, j - 1, cnt + 1))
        }
        if (j + 1 < n && !visited[i][j + 1] && array[i][j + 1] == 1) {
            visited[i][j + 1] = true
            q.addFirst(Triple(i, j + 1, cnt + 1))
        }
    }

    bw.write("$result")

    bw.flush()
    br.close()
    bw.close()
}