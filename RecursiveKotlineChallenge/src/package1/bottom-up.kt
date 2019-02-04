package package1;

import java.lang.Math.max

fun main(args: Array<String>) {


    val startTime = System.currentTimeMillis()
    val n = 10
    print(n)
    //val prices = listOf(1, 2, 5, 7, 9)
    val prices = package2.randomList(n)
    println(prices)
    val res = package2.bottomUpCutRod(prices, n)
    println(res)
    val endTime = System.currentTimeMillis()
    val duration = (endTime - startTime)
    println(duration)
    println()
}


fun bottomUpCutRod(prices: List<Int>, n: Int): Int {
    val saved = IntArray(n + 1)
    saved[0] = 0
    for (j in 1..n) {
        var q = -1
        for (i in 0 until j) {
            q = max(q, prices[i] + saved[j - (i + 1)])
        }
        saved[j] = q
    }
    return saved[n]
}

fun randomList(n: Int): List<Int> {
    var list = mutableListOf<Int>()
    for (i in 1..n) {
        list.add((1 until n).random())
    }
    return list
}