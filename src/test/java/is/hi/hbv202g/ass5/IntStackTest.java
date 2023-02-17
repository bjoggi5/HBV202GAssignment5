package is.hi.hbv202g.ass5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntStackTest {
    private IntStack stack;

    @Before
    public void constructorStackTestObjects() {
        stack= new IntStack();
    }

    @Test
    public void testNewStackIsNotFull() {
        assertFalse(stack.isFull());
    }

    @Test
    public void testFullStackIsFull() {
        int capacity = stack.getCapacity();
        for (int i = 0; i < capacity; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }

    @Test
    public void testFullStackIsAlmostFull() {
        int capacity = stack.getCapacity();
        for (int i = 1; i < capacity; i++) {
            stack.push(i);
        }
        assertFalse(stack.isFull());
    }

    @Test
    public void testPopReturnsPushedValue() {
        int value = 1;
        stack.push(value);
        assertEquals(value, stack.pop());
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testEmptyStackException() {
        stack.pop();
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testFullStackException() {
        int capacity = stack.getCapacity();
        for (int i = 0; i < capacity; i++) {
            stack.push(i);
        }
        stack.push(100);
    }

    @Test
    public void testIsEmptyIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

}
