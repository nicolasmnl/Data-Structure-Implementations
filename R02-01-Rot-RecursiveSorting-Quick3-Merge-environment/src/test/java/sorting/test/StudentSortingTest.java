package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorUnitario;
	private Integer[] vetorValoresNegativos;


	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorUnitario(new Integer[] {3});
		populaVetorNumerosNegativos(new Integer[] {-7,-9,-1,-24,-2,-57});
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
		this.implementation = new QuickSortMedianOfThree<>();

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

	public void populaVetorUnitario(Integer[] arrayPadrao){
		this.vetorUnitario = Arrays.copyOf(arrayPadrao,arrayPadrao.length);
	}

	private void populaVetorNumerosNegativos(Integer[] arrayPadrao) {
		this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	private void genericTestWithIndexs(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy = {};
		if (array.length > 0) {
			copy = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy, leftIndex, rightIndex + 1);
		Assert.assertArrayEquals(copy, array);
	}

	private void genericTestWithIncorrectIndexs(Integer[] array, int leftIndex, int rightIndex) {

		Integer[] copy = Arrays.copyOf(array, array.length);
		implementation.sort(array, leftIndex, rightIndex + 1);
		Assert.assertArrayEquals(copy, array);

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
	public void testSortFirstHalf(){
		genericTestWithIndexs(vetorTamPar,0,(vetorTamPar.length/2) - 1);
		genericTestWithIndexs(vetorTamPar,4,4);
		genericTestWithIndexs(vetorTamImpar,0,(vetorTamImpar.length/2) - 1);
		genericTestWithIndexs(vetorVazio,0,(vetorVazio.length/2) - 1);
		genericTestWithIndexs(vetorValoresIguais,0,(vetorValoresIguais.length/2) - 1);
		genericTestWithIndexs(vetorValoresRepetidos,0,(vetorValoresRepetidos.length/2) - 1);
		genericTestWithIndexs(vetorValoresNegativos,0,(vetorValoresNegativos.length/2) - 1);
	}

	@Test
	public void testSortSecondHalf(){
		genericTestWithIndexs(vetorTamPar, vetorTamPar.length/2, vetorTamPar.length - 1);
		genericTestWithIndexs(vetorTamImpar,vetorTamImpar.length/2,(vetorTamImpar.length) - 1);
		genericTestWithIndexs(vetorVazio,vetorVazio.length/2,(vetorVazio.length) - 1);
		genericTestWithIndexs(vetorValoresIguais,vetorValoresIguais.length/2,(vetorValoresIguais.length) - 1);
		genericTestWithIndexs(vetorValoresRepetidos,vetorValoresRepetidos.length/2,(vetorValoresRepetidos.length) - 1);
	}

	@Test
	public void testSortUnitaryVector(){
		genericTestWithIndexs(vetorUnitario, 0, vetorUnitario.length - 1);
	}

	@Test
	public void testSortIncorretIndex(){
		genericTestWithIncorrectIndexs(vetorTamPar,-1,50);
		genericTestWithIncorrectIndexs(vetorTamImpar,0, vetorTamImpar.length);
		genericTestWithIncorrectIndexs(vetorTamImpar,-10, vetorTamImpar.length -1);

	}
	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}