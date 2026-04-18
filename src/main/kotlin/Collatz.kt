fun collatzSequence(n: Int, m: Int = 3, chains: MutableMap<Int, List<Int>>): Map<Int, List<Int>> {
    require(n > 0) { "Input must be a positive integer" }

    for (i in 1..n) {
        val result = mutableListOf<Int>()
        var current = i
        while (current != 1) {
            current = if (current % 2 == 0) current / 2 else m * current + 1
            if (chains[current] == null) {
                result.add(current)
            } else {
                result.add(-current)
                break
            }
        }
        chains[i] = result
        for (j in 0..<result.size) {
            if (result[j] > 0 && chains[result[j]] == null) {
                chains[result[j]] = result.subList(j + 1, result.size)
            }
        }
    }
    return chains
}

fun main(args: Array<String>) {
    var argList = mutableListOf(*args)
    if (argList.isEmpty()) {
        print("Enter starting point: ")
        val in1 = readlnOrNull()
        if (in1 != null) argList.add(in1)
        if (argList.isEmpty()) {
            println("Usage: run with a positive integer, e.g. ./gradlew run --args=7")
            return
        }
    }

    val input = argList[0].toIntOrNull()
    if (input == null || input <= 0) {
        println("Please provide a valid positive integer.")
        return
    }
    val m = if (argList.size < 2) 3 else argList[1].toIntOrNull() ?: 3

    val seq = collatzSequence(input, m, mutableMapOf())
    println("Collatz sequences for $input:")
    seq.entries.sortedBy { it.key }.forEach { println("${it.key} => ${it.value.joinToString(", ")}") }
}
