package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<>(4);
		queue2 = new QueueDoubleLinkedListImpl<>(2);
		queue3 = new QueueDoubleLinkedListImpl<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	@Test
	public void testHeadCircular() {
		assertEquals(Integer.valueOf(1), queue1.head());
	}


	@Test
	public void testQueueZeroSize(){
		assertTrue(queue3.isFull());
		assertTrue(queue3.isEmpty());
	}


	@Test
	public void testEnqueueCircular() {
		try {
			queue1.enqueue(10);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEnqueueCircularComTailNoFimDoArray() {
		try {
			queue1.enqueue(10);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(Integer.valueOf(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queue1.enqueue(12);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueCircularFull() throws QueueOverflowException{
		try {
			queue1.enqueue(10);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(Integer.valueOf(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queue1.enqueue(12);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		queue1.enqueue(14);
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueCircularComErro() throws QueueOverflowException {
		queue2.enqueue(5); // vai depender do tamanho que a fila
		// foi iniciada!!!
	}

	@Test
	public void testDequeueCircular() {
		try {
			assertEquals(Integer.valueOf(1),queue2.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueCircularEmpty() throws QueueUnderflowException{
		try {
			queue1.enqueue(10);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(Integer.valueOf(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queue1.enqueue(12);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(Integer.valueOf(2), queue1.dequeue());
		assertEquals(Integer.valueOf(3), queue1.dequeue());
		assertEquals(Integer.valueOf(10), queue1.dequeue());
		assertEquals(Integer.valueOf(12), queue1.dequeue());
		assertEquals(Integer.valueOf(1), queue1.dequeue());

	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueCircularComErro() throws QueueUnderflowException {
		assertEquals(Integer.valueOf(1), queue3.dequeue()); // vai depender do
		// tamanho que a fial
		// foi iniciada!!!
	}
}