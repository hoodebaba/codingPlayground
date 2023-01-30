package com.hegde.playground

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ArrayProblemsTest {

    @Test
    fun findWords_test() {
        Assertions.assertArrayEquals(arrayOf("Alaska","Dad"), ArrayProblems().findWords(arrayOf("Hello","Alaska","Dad","Peace")))
    }
}