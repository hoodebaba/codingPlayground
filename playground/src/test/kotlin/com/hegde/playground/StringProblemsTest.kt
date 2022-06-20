package com.hegde.playground

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.Arrays

internal class StringProblemsTest {

    @Test
    fun isPalindrome() {
        Assertions.assertTrue(com.hegde.playground.isPalindrome("abba"))
        Assertions.assertFalse(com.hegde.playground.isPalindrome("acd"))
        Assertions.assertFalse(com.hegde.playground.isPalindrome("abbxa"))
        Assertions.assertTrue(com.hegde.playground.isPalindrome("abbaabba"))
    }

    @Test
    fun isPalindromeWithAlgo() {
        Assertions.assertTrue(com.hegde.playground.isPalindromeWithAlgo("abba"))
        Assertions.assertFalse(com.hegde.playground.isPalindromeWithAlgo("acd"))
        Assertions.assertFalse(com.hegde.playground.isPalindromeWithAlgo("abbxa"))
        Assertions.assertTrue(com.hegde.playground.isPalindromeWithAlgo("abbaabba"))
    }

    @Test
    fun test() {
        //        val words = arrayOf("abcwa","baz","foo","bar","xtfn","abcdef")
        val words = arrayOf("a","ab","abc","d","cd","bcd","abcd")
        println(words[0].toCharArray().distinct().plus(words[1].toCharArray().distinct()).groupBy { it }.filterValues { it.size > 1 })
        words.sortBy { it.length }
        println(words.contentToString())
        println("abc".substring(1 until 2))
    }

    @Test
    fun allPossibleSubStrings_test() {
        println(allPossibleSubStrings("abc"))
        println(allPossibleSubStrings_DynamicProgramming("abc", mutableSetOf()))
    }
}