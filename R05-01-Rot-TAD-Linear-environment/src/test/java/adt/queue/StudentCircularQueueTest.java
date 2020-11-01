package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentCircularQueueTest {

    private CircularQueue<Integer> circularQueue1;
    private CircularQueue<Integer> circularQueue2;
    private CircularQueue<Integer> circularQueue3;

    @Before
    public void setUp() throws QueueOverflowException {

        getImplementations();

        //Fila Circular com 3 elementos não cheia
        circularQueue1.enqueue(1);
        circularQueue1.enqueue(2);
        circularQueue1.enqueue(3);

        // Fila Circular com 2 elementos de tamanho 2. Fila cheia.
        circularQueue2.enqueue(1);
        circularQueue2.enqueue(2);
    }

    private void getImplementations() {
        // TODO O aluno deve ajustar aqui para instanciar sua implementação
        circularQueue1 = new CircularQueue<>(4);
        circularQueue2 = new CircularQueue<>(2);
        circularQueue3 = new CircularQueue<>(0);
    }

    // MÉTODOS DE TESTE QUEUE CIRCULAR

    @Test
    public void testHeadCircular() {
        assertEquals(Integer.valueOf(1), circularQueue1.head());
    }

    @Test
    public void testIsEmpty(){
        assertFalse(circularQueue1.isEmpty());
    }

    @Test
    public void testIsFull(){
        assertTrue(circularQueue2.isFull());
    }

    @Test
    public void testQueueZeroSize(){
        assertTrue(circularQueue3.isFull());
        assertTrue(circularQueue3.isEmpty());
    }


    @Test
    public void testEnqueueCircular() {
        try {
            circularQueue1.enqueue(10);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testEnqueueCircularComTailNoFimDoArray() {
        try {
            circularQueue1.enqueue(10);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(Integer.valueOf(1), circularQueue1.dequeue());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            circularQueue1.enqueue(12);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueCircularFull() throws QueueOverflowException{
        try {
            circularQueue1.enqueue(10);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(Integer.valueOf(1), circularQueue1.dequeue());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            circularQueue1.enqueue(12);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        circularQueue1.enqueue(14);
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueCircularComErro() throws QueueOverflowException {
        circularQueue2.enqueue(5); // vai depender do tamanho que a fila
        // foi iniciada!!!
    }

    @Test
    public void testDequeueCircular() {
        try {
            assertEquals(Integer.valueOf(1),circularQueue1.dequeue());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = QueueUnderflowException.class)
    public void testDequeueCircularEmpty() throws QueueUnderflowException{
        try {
            circularQueue1.enqueue(10);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(Integer.valueOf(1), circularQueue1.dequeue());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            circularQueue1.enqueue(12);
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(Integer.valueOf(2), circularQueue1.dequeue());
        assertEquals(Integer.valueOf(3), circularQueue1.dequeue());
        assertEquals(Integer.valueOf(10), circularQueue1.dequeue());
        assertEquals(Integer.valueOf(12), circularQueue1.dequeue());
        assertEquals(Integer.valueOf(1), circularQueue1.dequeue());

    }

    @Test(expected = QueueUnderflowException.class)
    public void testDequeueCircularComErro() throws QueueUnderflowException {
        assertEquals(Integer.valueOf(1), circularQueue3.dequeue()); // vai depender do
        // tamanho que a fial
        // foi iniciada!!!
    }

}