import kotlin.math.abs

var result = 0
fun main(args: Array<String>) {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val total = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    val strings = mutableListOf<String>()

    for (index in 0 until total) {
        val input = br.readLine()
        strings.add(input)
        var pow = 1

        val splits = input.split("").filter { it != "" }
        for (index in splits.size - 1 downTo 0) {
            val word = splits[index]
            map[word] = map.getOrDefault(word, 0) + pow
            pow *= 10
        }
    }

    val intMap = mutableMapOf<String, Int>()
    val entries = map.entries
    val sortedEntries = entries.sortedBy { it.value }.reversed()
    var max = 9

    for (entry in sortedEntries) {
        intMap[entry.key] = max
        max--
    }

    var sum = 0
    for (string in strings) {
        var intString = ""
        string.split("").filter { it != "" }.forEach {
            intString += intMap[it].toString()
        }
        sum += intString.toInt()
    }


    bw.write("$sum\n")


    bw.flush()
    br.close()
    bw.close()
}