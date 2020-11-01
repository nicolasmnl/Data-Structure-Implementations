package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;
	protected LinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new SingleLinkedListImpl<>();
		lista2 = new SingleLinkedListImpl<>();
		lista3 = new SingleLinkedListImpl<>();

	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		assertEquals(2, (int) lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertNotEquals(3, (int) lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testEntireSingleLinkedListImpl() {
		assertTrue(lista3.isEmpty());
		Assert.assertEquals(lista3.size(), 0);
		Assert.assertNull(lista3.search(1));
		Assert.assertArrayEquals(new Integer[] { }, lista3.toArray());

		lista3.remove(null);
		lista3.insert(1);
		lista3.remove(2);

		Assert.assertArrayEquals(new Integer[] { 1 }, lista3.toArray());

		Assert.assertFalse(lista3.isEmpty());
		Assert.assertEquals(lista3.size(), 1);
		Assert.assertEquals(1, (int) lista3.search(1));

		lista3.remove(1);

		lista3.remove(null);
		Assert.assertNull(lista3.search(1));
		Assert.assertArrayEquals(new Integer[] { }, lista3.toArray());

		assertTrue(lista3.isEmpty());
		Assert.assertNull(lista3.search(1));
		Assert.assertEquals(lista3.size(), 0);

		lista3.insert(2);
		lista3.insert(4);
		lista3.insert(12);
		lista3.insert(-8);
		Assert.assertArrayEquals(new Integer[] {2,4,12,-8}, lista3.toArray());
		lista3.remove(4);
		lista3.remove(12);
		lista3.remove(-8);

		lista3.remove(null);
		Assert.assertArrayEquals(new Integer[] { 2 }, lista3.toArray());
		Assert.assertFalse(lista3.isEmpty());

		lista3.insert(3);

		lista3.remove(5);
		Assert.assertArrayEquals(new Integer[] { 2, 3 }, lista3.toArray());
		Assert.assertFalse(lista3.isEmpty());

		lista3.insert(4);

		lista3.remove(null);
		Assert.assertArrayEquals(new Integer[] { 2, 3, 4 }, lista3.toArray());
		Assert.assertFalse(lista3.isEmpty());

		Assert.assertEquals(lista3.size(), 3);
		Assert.assertEquals(2, (int) lista3.search(2));
		Assert.assertEquals(3, (int) lista3.search(3));
		Assert.assertEquals(4, (int) lista3.search(4));

		lista3.remove(3);

		lista3.remove(null);
		Assert.assertNull(lista3.search(3));
		Assert.assertArrayEquals(new Integer[] { 2, 4 }, lista3.toArray());

		Assert.assertFalse(lista3.isEmpty());
		Assert.assertNull(lista3.search(3));
		Assert.assertEquals(lista3.size(), 2);

		lista3.remove(4);

		lista3.remove(-7);
		Assert.assertNull(lista3.search(4));
		Assert.assertFalse(lista3.isEmpty());
		Assert.assertArrayEquals(new Integer[] { 2 }, lista3.toArray());
		Assert.assertEquals(lista3.size(), 1);

		lista3.remove(2);

		lista3.remove(11);
		Assert.assertNull(lista3.search(2));
		assertTrue(lista3.isEmpty());
		Assert.assertArrayEquals(new Integer[] { }, lista3.toArray());
		Assert.assertEquals(lista3.size(), 0);
	}
}