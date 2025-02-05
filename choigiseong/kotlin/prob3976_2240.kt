var min: Int? = null

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = Array<Array<String>>(n) { Array(m) { "" } }
    var coin1: Pair<Int, Int>? = null
    var coin2: Pair<Int, Int>? = null
    for (index in 0 until n) {
        array[index] = br.readLine().split("").filter { it != "" }.toTypedArray()
        for ((jndex, value) in array[index].withIndex()) {
            if (value == "o") {
                if (coin1 == null) {
                    coin1 = Pair(index, jndex)
                } else {
                    coin2 = Pair(index, jndex)
                }
            }
        }
    }


    dfs(depth = 1, n, m, coin1!!, coin2!!, array)


    bw.write("${min}")



    bw.flush()
    br.close()
    bw.close()
}

fun dfs(
    depth: Int,
    n: Int,
    m: Int,
    coin1: Pair<Int, Int>,
    coin2: Pair<Int, Int>,
    array: Array<Array<String>>
) {

    if (depth > 10) {
        if (min == null) {
            min = -1
        }
        return
    }

    //상
    if (coin1.first - 1 < 0 && coin2.first - 1 < 0) {
        //do nothing
    } else if (coin1.first - 1 < 0 || coin2.first - 1 < 0) {
        if (min != -1) {
            min = min?.coerceAtMost(depth) ?: depth
        } else {
            min = depth
        }
    } else {
        var newCoin1 = Pair(coin1.first, coin1.second)
        var newCoin2 = Pair(coin2.first, coin2.second)
        if (array[newCoin1.first - 1][coin1.second] != "#") {
            newCoin1 = Pair(coin1.first - 1, coin1.second)
        }

        if (array[newCoin2.first - 1][coin2.second] != "#") {
            newCoin2 = Pair(coin2.first - 1, coin2.second)
        }
        dfs(depth + 1, n, m, newCoin1, newCoin2, array)
    }
    //하
    if (coin1.first + 1 >= n && coin2.first + 1 >= n) {
        //do nothing
    } else if (coin1.first + 1 >= n || coin2.first + 1 >= n) {
        if (min != -1) {
            min = min?.coerceAtMost(depth) ?: depth
        } else {
            min = depth
        }
    } else {
        var newCoin1 = Pair(coin1.first, coin1.second)
        var newCoin2 = Pair(coin2.first, coin2.second)
        if (array[newCoin1.first + 1][coin1.second] != "#") {
            newCoin1 = Pair(coin1.first + 1, coin1.second)
        }

        if (array[newCoin2.first + 1][coin2.second] != "#") {
            newCoin2 = Pair(coin2.first + 1, coin2.second)
        }
        dfs(depth + 1, n, m, newCoin1, newCoin2, array)
    }

    //좌
    if (coin1.second - 1 < 0 && coin2.second - 1 < 0) {
        //do nothing
    } else if (coin1.second - 1 < 0 || coin2.second - 1 < 0) {
        if (min != -1) {
            min = min?.coerceAtMost(depth) ?: depth
        } else {
            min = depth
        }
    } else {
        var newCoin1 = Pair(coin1.first, coin1.second)
        var newCoin2 = Pair(coin2.first, coin2.second)
        if (array[coin1.first][newCoin1.second - 1] != "#") {
            newCoin1 = Pair(coin1.first, coin1.second - 1)
        }

        if (array[coin2.first][newCoin2.second - 1] != "#") {
            newCoin2 = Pair(coin2.first, coin2.second - 1)
        }
        dfs(depth + 1, n, m, newCoin1, newCoin2, array)
    }

    //우
    if (coin1.second + 1 >= m && coin2.second + 1 >= m) {
        //do nothing
    } else if (coin1.second + 1 >= m || coin2.second + 1 >= m) {
        if (min != -1) {
            min = min?.coerceAtMost(depth) ?: depth
        } else {
            min = depth
        }
    } else {
        var newCoin1 = Pair(coin1.first, coin1.second)
        var newCoin2 = Pair(coin2.first, coin2.second)
        if (array[coin1.first][newCoin1.second + 1] != "#") {
            newCoin1 = Pair(coin1.first, coin1.second + 1)
        }

        if (array[coin2.first][newCoin2.second + 1] != "#") {
            newCoin2 = Pair(coin2.first, coin2.second + 1)
        }
        dfs(depth + 1, n, m, newCoin1, newCoin2, array)
    }


}