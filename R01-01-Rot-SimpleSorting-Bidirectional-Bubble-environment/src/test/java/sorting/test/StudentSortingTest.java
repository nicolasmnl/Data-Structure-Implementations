package sorting.test;

import java.text.Bidi;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorOrdenado;
	private Integer[] vetorUnitario;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorOrdenado(new Integer[]{1, 5, 6, 12, 23, 28, 30});
		populaVetorUnitario(new Integer[]{4});
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new BidirectionalBubbleSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorOrdenado(Integer[] arrayPadrao){
		this.vetorOrdenado = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnitario(Integer[] arrayPadrao){
		this.vetorUnitario = Arrays.copyOf(arrayPadrao,arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1,0,array.length);
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTest2(Integer[] array){
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, 0, (array.length/2) - 1);
		Arrays.sort(copy1,0,copy1.length/2);
		Assert.assertArrayEquals(copy1, array);
	}
	public void genericTest3(Integer[] array){
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, array.length/2, array.length - 1);
		Arrays.sort(copy1,array.length/2, array.length);
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTest4(Integer[] array){
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, array.length/2, array.length - 1);
		Arrays.sort(copy1,array.length/2, array.length);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSort06(){ genericTest(vetorOrdenado);}

	@Test
	public void testSort07(){genericTest(vetorUnitario);}

	//Sort the first half of the array
	@Test
	public void testSortMetadeInicial(){
		genericTest2(vetorTamPar);
		genericTest2(vetorTamImpar);
		genericTest2(vetorVazio);
		genericTest2(vetorValoresIguais);
		genericTest2(vetorValoresRepetidos);
	}

	//Sort the final half of the array
	@Test
	public void testSortMetadeFinal(){
		genericTest3(vetorTamPar);
		genericTest3(vetorTamImpar);
		genericTest3(vetorVazio);
		genericTest3(vetorValoresIguais);
		genericTest3(vetorValoresRepetidos);
	}
	@Test
	public void testSort08() {
		genericTestWithIndexs(vetorTamPar, 2, 5);
		genericTestWithIndexs(vetorTamImpar, 0, 5);
		genericTestWithIndexs(vetorTamImpar, 3, 6);
		genericTestWithIndexs(vetorTamImpar, 2, 4);
		genericTestWithIndexs(vetorTamPar, 4, 4);
		genericTestWithIndexs(vetorTamPar, 4, 8);
		genericTestWithIndexs(vetorValoresRepetidos, 3, 4);
	}
	@Test
	public void testSort09() {
		/**
		 * If parameters are invalid, like leftIndex < 0 or rigthIndex >= arr.length, it should do nothing with array
		 */
		Integer[] copy = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		implementation.sort(vetorTamPar, -1, 5);
		Assert.assertArrayEquals(vetorTamPar, copy);
	}
	private void genericTestWithIndexs(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy = {};
		if (array.length > 0) {
			copy = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		}
		implementation.sort(vetorTamPar, leftIndex, rightIndex);
		Arrays.sort(copy, leftIndex, rightIndex + 1);
		Assert.assertArrayEquals(copy, vetorTamPar);
	}










	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}