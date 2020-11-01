package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	protected DoubleLinkedList<Integer> lista4;
	protected DoubleLinkedList<Integer> listaUnitária;
	protected DoubleLinkedList<Integer> listaVazia;
	protected DoubleLinkedList<Integer> listaTamPar;
	protected DoubleLinkedList<Integer> listaTamImpar;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista4.insert(1);

		listaUnitária.insert(12);

		listaTamPar.insert(2);
		listaTamPar.insert(8);
		listaTamPar.insert(5);
		listaTamPar.insert(28);
		listaTamPar.insert(-8);
		listaTamPar.insert(-1);

		listaTamImpar.insert(1);
		listaTamImpar.insert(17);
		listaTamImpar.insert(9);
		listaTamImpar.insert(-7);
		listaTamImpar.insert(51);


	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new SingleLinkedListImpl<>();
		lista4 = new RecursiveDoubleLinkedListImpl<>();
		listaUnitária = new RecursiveDoubleLinkedListImpl<>();
		listaVazia = new RecursiveDoubleLinkedListImpl<>();
		listaTamPar = new RecursiveDoubleLinkedListImpl<>();
		listaTamImpar = new RecursiveDoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveListaUnitaria(){
		assertEquals(1,listaUnitária.size());
		listaUnitária.remove(12);
		assertEquals(0,listaUnitária.size());
		assertArrayEquals(new Integer[]{}, listaUnitária.toArray());
		listaUnitária.insert(14);
		assertEquals(1, listaUnitária.size());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3,2 }, lista1.toArray());
		listaTamPar.removeLast();
		Assert.assertArrayEquals(new Integer[] { 2,8,5,28,-8 }, listaTamPar.toArray());
		listaTamImpar.removeLast();
		Assert.assertArrayEquals(new Integer[] { 1,17,9,-7 }, listaTamImpar.toArray());
	}
}