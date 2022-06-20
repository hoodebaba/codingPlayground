package com.hegde.playground

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
                var product = words[i].length * words[j].length
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
                var product = words[i].length * words[j].length
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