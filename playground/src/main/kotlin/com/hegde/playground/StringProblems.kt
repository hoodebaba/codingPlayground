package com.hegde.playground

import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

fun isPalindrome(value: String): Boolean {
    val toTest = value.lowercase().replace(Regex("\\s"), "").replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()
    return toTest == toTest.reversed()
}

fun isPalindromeWithAlgo(value: String): Boolean {

    val toCharArray = value.toCharArray()
    for (i in 0 until toCharArray.size.div(2)) {
        if(toCharArray[i] != toCharArray[toCharArray.size - 1 - i]) {
            return false
        }
    }

    return true
}

fun maxProduct(words: Array<String>): Int {
    var maxProduct: Int = 0
    for (i in words.indices) {
        for (j in i until words.size) {
            if (words[i].toCharArray().distinct().plus(words[j].toCharArray().distinct()).groupBy { it }.filterValues { it.size > 1 }.isEmpty()) {
                val product = words[i].length * words[j].length
                maxProduct = if (product > maxProduct) product else maxProduct
            }
        }
    }
    return maxProduct
}

fun maxProductAlternate(words: Array<String>): Int {
    var maxProduct: Int = 0
    words.sortBy { it.length }
    for (i in words.indices.reversed()) {
        for (j in i downTo  0) {
            if (words[i].toCharArray().distinct().plus(words[j].toCharArray().distinct()).groupBy { it }.filterValues { it.size > 1 }.isEmpty()) {
                val product = words[i].length * words[j].length
                maxProduct = if (product > maxProduct) product else maxProduct
            }
        }
    }
    return maxProduct
}

fun longestPalindrome(s: String): String {
    return allPossibleSubStrings(s).sortedBy { it.length }.reversed().first { isPalindrome(it) }
}

fun allPossibleSubStrings(s: String): kotlin.collections.List<String> {
    if (s.length == 1)
        return mutableListOf(s)
    return allPossibleSubStrings(s.substring(0 until s.length-1)).plus(allPossibleSubStrings(s.substring(1 until s.length))).plus(s)
}

fun allPossibleSubStrings_DynamicProgramming(s: String, lists: kotlin.collections.Set<String>): kotlin.collections.List<String> {
    if (lists.contains(s))
        return mutableListOf(s)
    if (s.length == 1)
        return mutableListOf(s)
    lists.plus(s)
    return allPossibleSubStrings_DynamicProgramming(s.substring(0 until s.length-1), lists).plus(allPossibleSubStrings_DynamicProgramming(s.substring(1 until s.length), lists)).plus(s)
}

fun isPalindromeRecursive(input: String): Boolean {
    if (input.isEmpty() || input.length == 1)
        return true

    if (input.length == 2) {
        return (input.toCharArray().first() == input.toCharArray().last())
    }

    return (input.toCharArray().first() == input.toCharArray().last())
            && isPalindromeRecursive(input.substring(1, input.length - 1)
    )


}


private val standardRomanToInt =
    mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

fun romanToInt(s: String): Int {
    var intValue = 0;
    var i = 0

    while (i < s.length) {

        if (isLastChar(i, s)) {
            intValue += standardRomanToInt[s.get(i)] ?: 0
            i += 1;
            continue
        }

        if (isFour(s, i)) {
            intValue += 4
            i += 2;
            continue
        }
        if (isNine(s, i)) {
            intValue += 9
            i += 2;
            continue
        }

        if (isFourty(s, i)) {
            intValue += 40
            i += 2;
            continue
        }
        if (isNinety(s, i)) {
            intValue += 90
            i += 2;
            continue
        }


        if (isFourHundred(s, i)) {
            intValue += 400
            i += 2;
            continue
        }
        if (isNineHundred(s, i)) {
            intValue += 900
            i += 2;
            continue
        }


        intValue += standardRomanToInt[s.get(i)] ?: 0
        i += 1
    }
    return intValue
}

private fun isNineHundred(s: String, i: Int) = s.get(i) == 'C' && s.get(i + 1) == 'M'
private fun isFourHundred(s: String, i: Int) = s.get(i) == 'C' && s.get(i + 1) == 'D'
private fun isNinety(s: String, i: Int) = s.get(i) == 'X' && s.get(i + 1) == 'C'
private fun isFourty(s: String, i: Int) = s.get(i) == 'X' && s.get(i + 1) == 'L'
private fun isNine(s: String, i: Int) = s.get(i) == 'I' && s.get(i + 1) == 'X'
private fun isFour(s: String, i: Int) = s.get(i) == 'I' && s.get(i + 1) == 'V'
private fun isLastChar(i: Int, s: String) = i == s.length - 1

private val standardIntToRoman =
    mapOf(1 to 'I', 5 to 'V', 10 to 'X', 50 to 'L', 100 to 'C', 500 to 'D', 1000 to 'M')

fun intToRoman(num: Int): String {
    val stackOfNum = Stack<Int>()
    var digit = num;
    while (digit > 0) {
        stackOfNum.push(digit % 10)
        digit /= 10
    }

    var finalResult = "";
    while (!stackOfNum.isEmpty()) {
        val value = stackOfNum.pop() * Math.pow(10.toDouble(), stackOfNum.size.toDouble()).toInt()
        println(value)

        if (value.toString().length == 4) {
            val firstDigit = value / 1000
            if (firstDigit <= 3)
                finalResult = concatTimes(finalResult, "M", firstDigit)

            if (firstDigit == 4)
                finalResult = finalResult.plus("MP")

            if (firstDigit == 5)
                finalResult = finalResult.plus("P")

            if (firstDigit in 6..8)
                finalResult = concatTimes(finalResult.plus("P"), "M", (firstDigit - 5))
            continue
        }

        if (value.toString().length == 3) {
            val firstDigit = value / 100
            if (firstDigit <= 3)
                finalResult = concatTimes(finalResult, "C", firstDigit)

            if (firstDigit == 4)
                finalResult = finalResult.plus("CD")

            if (firstDigit == 5)
                finalResult = finalResult.plus("D")

            if (firstDigit in 6..8)
                finalResult = concatTimes(finalResult.plus("D"), "C", (firstDigit - 5))

            if (firstDigit == 9)
                finalResult = finalResult.plus("CM")

            if (firstDigit == 10)
                finalResult = finalResult.plus("M")

            continue
        }

        if (value.toString().length == 2) {
            val firstDigit = value / 10
            if (firstDigit <= 3)
                finalResult = concatTimes(finalResult, "X", firstDigit)

            if (firstDigit == 4)
                finalResult = finalResult.plus("XL")

            if (firstDigit == 5)
                finalResult = finalResult.plus("L")

            if (firstDigit in 6..8)
                finalResult = concatTimes(finalResult.plus("L"), "X", (firstDigit - 5))

            if (firstDigit == 9)
                finalResult = finalResult.plus("XC")

            if (firstDigit == 10)
                finalResult = finalResult.plus("C")

            continue
        }

        if (value.toString().length == 1) {
            val firstDigit = value / 1
            if (firstDigit <= 3)
                finalResult = concatTimes(finalResult, "I", firstDigit)

            if (firstDigit == 4)
                finalResult = finalResult.plus("IV")

            if (firstDigit == 5)
                finalResult = finalResult.plus("V")

            if (firstDigit in 6..8)
                finalResult = concatTimes(finalResult.plus("V"), "I", (firstDigit - 5))

            if (firstDigit == 9)
                finalResult = finalResult.plus("IX")

            if (firstDigit == 10)
                finalResult = finalResult.plus("X")

            continue
        }

    }

    return finalResult
}

private fun concatTimes(base:String, appender:String , t:Int): String {
    var plus = base
    for (i in 1..t){
         plus = plus.plus(appender)
    }
    return plus;
}

fun intToRomanAlternate(input: Int):String {
    val intArray = intArrayOf(1,4,5,9,10,40,50,90,100,400,500,900,1000)
    val romans = arrayOf("I","IV","V","IX","X","XL","L","XC","C","CD","D","DM","M")

    var copyOfInput = input
    var final = ""
    while (copyOfInput > 0) {
        for (i in intArray.indices) {
            if (copyOfInput >= intArray[i] && copyOfInput < intArray[i+1]) {
                final+=romans[i]
                copyOfInput-=intArray[i]
            }
        }
    }

    return final
}

fun lengthOfLongestSubstring(input: String): Int {
    val characters: MutableList<Char> = ArrayList()
    var longestLength = 0
    for (i in 0 until input.length) {
        for (ch in Arrays.copyOfRange(input.toCharArray(), i, input.length)) {
            println(ch)
            if (characters.contains(ch)) {
                longestLength = Math.max(characters.size, longestLength)
                characters.clear()
            }
            characters.add(ch)
            println(Arrays.toString(characters.toTypedArray()))
        }
        longestLength = if (longestLength == 0) characters.size else Math.max(characters.size, longestLength)
        characters.clear()
    }
    return longestLength
}

fun lengthOfLongestSubstringAlternate(input: String): Int {
    val characters = input.toCharArray()
    var longestLength = 0
    var i = 0
    var j = 0
    var loopCounter = 0
    while (j < characters.size) {
        loopCounter++
        if (hasDuplicate(Arrays.copyOfRange(characters, i, j + 1))) {
            i++
        }
        longestLength = Math.max(j - i + 1, longestLength)
        j++
    }
    println("loopcounter " + loopCounter + " for length " + input.length)
    return if (longestLength == 0) input.length else longestLength
}

fun hasDuplicate(underTest: CharArray): Boolean {
    return underTest.size != IntStream.range(0, underTest.size).mapToObj { i: Int ->
        underTest[i]
    }.collect(Collectors.toSet()).size
}

fun lengthOfLongestSubstringAlternateOne(input: String): Int {
    val characters = input.toCharArray()
    var i = 0
    var j = 0
    var longestLength = 0
    while (j < characters.size) {
        if (hasDuplicate(Arrays.copyOfRange(characters, i, j + 1))) {
            i++
            longestLength = Math.max(j - i + 1, longestLength)
            continue
        }
        longestLength = Math.max(j - i + 1, longestLength)
        j++
    }
    return if (longestLength == 0) input.length else longestLength
}

