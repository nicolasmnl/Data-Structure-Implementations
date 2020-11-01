package adt.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentQueueUsingStackTest {

    private Queue<Integer> queue4;
    private Queue<Integer> queue5;
    private Queue<Integer> queue6;
    private Queue<Integer> queue7;
    private Queue<Integer> queue8;

    @Before
    public void setUp() throws QueueOverflowException {

        getImplementations();

        //Fila Circular com 3 elementos não cheia

        // Fila Circular com 2 elementos de tamanho 2. Fila cheia.
    }

    private void getImplementations() {
        // TODO O aluno deve ajustar aqui para instanciar sua implementação
        queue4 = new QueueUsingStack<>(6);
        queue5 = new QueueUsingStack<>(3);
        queue6 = new QueueUsingStack<>(1);
        queue7 = new QueueUsingStack<>(0);
        queue8 = new QueueUsingStack<>(7);


    }

    @Test
    public void testEntireQueueUsingStackZero() throws QueueUnderflowException, QueueOverflowException {
        assertTrue(queue7.isEmpty());
        assertTrue(queue7.isFull());
        try {
            queue7.enqueue(1);
        } catch (QueueOverflowException e) {
            assertTrue(queue7.isEmpty());
            assertTrue(queue7.isFull());
        }
        try {
            queue7.dequeue();
        } catch (QueueUnderflowException e) {
            assertTrue(queue7.isEmpty());
            assertTrue(queue7.isFull());
        }
    }

    @Test
    public void testEntireQueueUsingStackOneElement() throws QueueUnderflowException, QueueOverflowException {
        assertTrue(queue6.isEmpty());
        assertFalse(queue6.isFull());
        assertNull(queue6.head());
        queue6.enqueue(1);
        assertEquals((int) queue6.head(), 1);
        try {
            queue6.enqueue(2);
        } catch (QueueOverflowException e) {
            assertFalse(queue6.isEmpty());
            assertTrue(queue6.isFull());
        }
        queue6.dequeue();
        try {
            queue6.dequeue();
        } catch (QueueUnderflowException e) {
            assertTrue(queue6.isEmpty());
            assertFalse(queue6.isFull());
        }
    }

    @Test
    public void testEntireQueueUsingStackOdd3Elements() throws QueueUnderflowException, QueueOverflowException {
        assertFalse(queue5.isFull());
        assertTrue(queue5.isEmpty());
        queue5.enqueue(1);
        assertEquals((int) queue5.head(), 1);
        assertFalse(queue5.isEmpty());
        assertFalse(queue5.isFull());
        queue5.enqueue(2);
        assertEquals((int) queue5.head(), 1);
        assertFalse(queue5.isEmpty());
        assertFalse(queue5.isFull());
        queue5.enqueue(3);
        assertEquals((int) queue5.head(), 1);
        try {
            queue5.enqueue(4);
        } catch (QueueOverflowException e) {
            assertFalse(queue5.isEmpty());
            assertTrue(queue5.isFull());
        }
        assertEquals((int) queue5.head(), 1);
        queue5.dequeue();
        assertEquals((int) queue5.head(), 2);
        assertFalse(queue5.isEmpty());
        assertFalse(queue5.isFull());
        queue5.dequeue();
        assertFalse(queue5.isEmpty());
        assertFalse(queue5.isFull());
        queue5.dequeue();
        try {
            queue5.dequeue();
        } catch (QueueUnderflowException e) {
            assertTrue(queue5.isEmpty());
            assertFalse(queue5.isFull());
        }
        queue5.enqueue(1);
        assertEquals((int) queue5.head(), 1);
        queue5.enqueue(2);
        assertEquals((int) queue5.head(), 1);
        queue5.dequeue();
        assertEquals((int) queue5.head(), 2);
        assertFalse(queue5.isEmpty());
        assertFalse(queue5.isFull());
        queue5.dequeue();
        assertTrue(queue5.isEmpty());
    }

    @Test
    public void testEntireQueueUsingStackEven() throws QueueUnderflowException, QueueOverflowException {
        assertFalse(queue4.isFull());
        assertTrue(queue4.isEmpty());
        queue4.enqueue(1);
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.enqueue(2);
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.enqueue(3);
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.enqueue(4);
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.enqueue(5);
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.enqueue(6);
        try {
            queue4.enqueue(7);
        } catch (QueueOverflowException e) {
            assertTrue(queue4.isFull());
            assertFalse(queue4.isEmpty());
        }
        queue4.dequeue();
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.dequeue();
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.dequeue();
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.dequeue();
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.dequeue();
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.dequeue();
        try {
            queue4.dequeue();
        } catch (QueueUnderflowException e) {
            assertFalse(queue4.isFull());
            assertTrue(queue4.isEmpty());
        }
        queue4.enqueue(1);
        assertEquals((int) queue4.head(), 1);
        queue4.enqueue(2);
        assertEquals((int) queue4.head(), 1);
        queue4.dequeue();
        assertEquals((int) queue4.head(), 2);
        assertFalse(queue4.isEmpty());
        assertFalse(queue4.isFull());
        queue4.dequeue();
        assertTrue(queue4.isEmpty());
    }

    @Test
    public void testEntireQueueUsingStackOdd7Elements() throws QueueUnderflowException, QueueOverflowException {
        assertTrue(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(1);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(2);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(3);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(4);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(5);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(6);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        queue8.enqueue(7);
        try {
            queue8.enqueue(8);
        } catch (QueueOverflowException e) {
            assertFalse(queue8.isEmpty());
            assertTrue(queue8.isFull());
        }
        assertEquals((int) queue8.head(), 1);
        assertEquals((int) queue8.dequeue(), 1);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals((int) queue8.head(), 2);
        assertEquals((int) queue8.dequeue(), 2);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals((int) queue8.head(), 3);
        assertEquals((int) queue8.dequeue(), 3);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals((int) queue8.head(), 4);
        assertEquals((int) queue8.dequeue(), 4);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals((int) queue8.head(), 5);
        assertEquals((int) queue8.dequeue(), 5);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals((int) queue8.head(), 6);
        assertEquals((int) queue8.dequeue(), 6);
        assertFalse(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals((int) queue8.head(), 7);
        assertEquals((int) queue8.dequeue(), 7);
        assertTrue(queue8.isEmpty());
        assertFalse(queue8.isFull());
        assertEquals(queue8.head(), null);
    }



}