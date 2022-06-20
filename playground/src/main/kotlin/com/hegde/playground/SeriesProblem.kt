package com.hegde.playground

fun fibonacci(n: Int): Int {
    val first = 1
    val second = 1
    var lastValue = 1
    var lasttoLastValue = 1

    if (n == 1 || n == 2)
        return 1

    for(i in 3..n) {
        var x = lastValue
        lastValue = lasttoLastValue + lastValue
        lasttoLastValue = x
    }
    return lastValue
}

fun fibonacciRecursive(n: Int): Int {
    if (n == 1 || n == 2)
        return 1
    return fibonacciRecursive(n-1) + fibonacciRecursive(n-2)
}