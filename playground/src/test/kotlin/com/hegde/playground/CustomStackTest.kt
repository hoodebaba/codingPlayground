package com.hegde.playground

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CustomStackTest {

    @Test
    fun `given a empty stack push a value and verify the size`() {
        val stack = CustomStack()
        stack.push(1);
        assertEquals( 1, stack.size)
        assertEquals(1, stack.getMin())
    }

    @Test
    fun `given a stack with one value pop a first value and verify the size`() {
        val stack = CustomStack()
        stack.push(1);
        assertEquals(stack.size, 1)
        val popedValue = stack.pop();
        assertEquals(popedValue, 1)
        assertEquals(stack.size, 0)
        assertEquals(stack.getMin(), null)
    }

    @Test
    fun `given a stack with multiple value, peek the top value and the size should remain same`() {
        val stack = CustomStack()
        stack.push(1)
        stack.push(5)
        stack.push(3)
        stack.push(0)

        assertEquals(stack.size, 4)
        val peekedValue = stack.peek();
        assertEquals(peekedValue, 0)
        assertEquals(stack.size, 4)
        assertEquals(stack.getMin(), 0)
    }

    @Test
    fun `given a stack with multiple value and multiple operation,should return correct min`() {
        val stack = CustomStack()
        stack.push(1)
        assertEquals( 1, stack.size)
        assertEquals(1, stack.getMin())

        stack.push(5)
        assertEquals( 2, stack.size)
        assertEquals(1, stack.getMin())

        stack.push(3)
        assertEquals( 3, stack.size)
        assertEquals(1, stack.getMin())

        stack.push(0)
        assertEquals( 4, stack.size)
        assertEquals(0, stack.getMin())


        stack.push(1)
        assertEquals( 5, stack.size)
        assertEquals(0, stack.getMin())

        stack.pop()
        assertEquals( 4, stack.size)
        assertEquals(0, stack.getMin())

        stack.pop()
        assertEquals( 3, stack.size)
        assertEquals(1, stack.getMin())
    }

    @Test
    fun `given a stack with multiple value and multiple operation,should return correct min second`() {
        val stack = CustomStack()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals( 3, stack.size)
        assertEquals(1, stack.getMin())

        stack.pop()
        stack.push(0)
        stack.push(4)
        assertEquals( 4, stack.size)
        assertEquals(0, stack.getMin())

        stack.pop()
        stack.pop()
        stack.push(5)
        assertEquals( 3, stack.size)
        assertEquals(1, stack.getMin())
    }
}