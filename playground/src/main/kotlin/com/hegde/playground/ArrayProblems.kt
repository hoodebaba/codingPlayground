package com.hegde.playground

class ArrayProblems {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val missingInts: MutableList<Int> = arrayListOf()
        val numArray: IntArray = IntArray(nums.size)
        for (num in nums) {
            numArray[num - 1]++
        }
        for ((index, num) in numArray.withIndex()) {
            if (num == 0) {
                missingInts.add(index + 1)
            }
        }
        return missingInts
    }

    fun sortedSquares(nums: IntArray): IntArray {
        nums.forEachIndexed { index, i ->
            if (i < 0) {
                nums[index] *= -1
            }
            nums[index]*= nums[index]
        }
        nums.sort()
        return nums
    }
}