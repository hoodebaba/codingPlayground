package com.hegde.playground

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SeriesProblemTest {

    @Test
    fun fibonacci_Test() {
        assertEquals(1, fibonacci(1))
        assertEquals(1, fibonacci(2))
        assertEquals(2, fibonacci(3))
        assertEquals(3, fibonacci(4))
        assertEquals(5, fibonacci(5))
    }

    @Test
    fun fibonacciRecursive_Test() {
        assertEquals(1, fibonacciRecursive(1))
        assertEquals(1, fibonacciRecursive(2))
        assertEquals(2, fibonacciRecursive(3))
        assertEquals(3, fibonacciRecursive(4))
        assertEquals(5, fibonacciRecursive(5))
    }
}