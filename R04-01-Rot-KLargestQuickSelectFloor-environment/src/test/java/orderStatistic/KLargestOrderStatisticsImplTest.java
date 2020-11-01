package orderStatistic;

import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class KLargestOrderStatisticsImplTest {

    private KLargestOrderStatisticsImpl<Integer> kLargestOrderStatistics;

    private Integer[] vetorTamPar = { 30, 28, 7, 29, 11, 26, 4, 22, 23,31 };
    private Integer[] vetorTamImpar = { 6, 41, 32, 7, 26, 4, 37, 49,11, 18, 36 };;
    private Integer[] vetorVazio = {};
    private Integer[] vetorValoresIguais ={ 6, 6, 6, 6, 6, 6 } ;
    private Integer[] vetorUnitario = {3};
    private Integer[] vetorValoresNegativos = {-7,-9,-1,-24,-2,-57};
    private Integer[] vetorComZerosENumeros = {0,3,0,2,27,0,-12,1,-10,47,13,24,5,8};


    @Before
    public void setUp(){
        kLargestOrderStatistics = new KLargestOrderStatisticsImpl<>();
    }

    @Test
    public void testOrderStatistics1(){
        assertEquals(4,kLargestOrderStatistics.orderStatistics(vetorTamPar, 1));
        assertEquals(31,kLargestOrderStatistics.orderStatistics(vetorTamPar, vetorTamPar.length));
        assertNull(kLargestOrderStatistics.orderStatistics(vetorTamPar,20));
        assertNull(kLargestOrderStatistics.orderStatistics(vetorTamPar,0));

    }

    @Test
    public void testOrderStatistics2(){
        assertEquals(4,kLargestOrderStatistics.orderStatistics(vetorTamImpar, 1));
        assertEquals(49,kLargestOrderStatistics.orderStatistics(vetorTamImpar, vetorTamImpar.length));
        assertNull(kLargestOrderStatistics.orderStatistics(vetorTamImpar,vetorTamImpar.length + 1));
        assertNull(kLargestOrderStatistics.orderStatistics(vetorTamImpar,0));

    }

    @Test
    public void testOrderStatistics3(){
        assertNull(kLargestOrderStatistics.orderStatistics(vetorVazio, 10));
    }

    @Test
    public void testOrderStatistics4(){
        assertEquals(3,kLargestOrderStatistics.orderStatistics(vetorUnitario,1));
        assertNull(kLargestOrderStatistics.orderStatistics(vetorUnitario, 10));
    }

    @Test
    public void testgetKLargest1(){
        assertArrayEquals(new Integer[]{29,30,31}, kLargestOrderStatistics.getKLargest(vetorTamPar,3));
        assertArrayEquals(new Integer[]{26,28,29,30,31}, kLargestOrderStatistics.getKLargest(vetorTamPar,5));
        assertArrayEquals(new Integer[]{31}, kLargestOrderStatistics.getKLargest(vetorTamPar,1));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorTamPar,0));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorTamPar,10000));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorTamPar,-3));
    }

    @Test
    public void testgetKLargest2(){
        assertArrayEquals(new Integer[]{37,41,49}, kLargestOrderStatistics.getKLargest(vetorTamImpar,3));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorTamImpar,0));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorTamImpar,20));
    }
    @Test
    public void testgetKLargest3(){
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorVazio,5));
    }
    @Test
    public void testgetKLargest4(){
        assertArrayEquals(new Integer[]{6,6,6}, kLargestOrderStatistics.getKLargest(vetorValoresIguais,3));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresIguais,0));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresIguais,20));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresIguais,-50));
    }
    @Test
    public void testgetKLargest5(){
        assertArrayEquals(new Integer[]{-7,-2,-1}, kLargestOrderStatistics.getKLargest(vetorValoresNegativos,3));
        assertArrayEquals(new Integer[]{-1}, kLargestOrderStatistics.getKLargest(vetorValoresNegativos,1));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresNegativos,0));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresNegativos,20));
    }
    @Test
    public void testgetKLargest6(){
        assertArrayEquals(new Integer[]{47}, kLargestOrderStatistics.getKLargest(vetorComZerosENumeros,1));
        assertArrayEquals(new Integer[]{47}, kLargestOrderStatistics.getKLargest(vetorComZerosENumeros,1));
        assertArrayEquals(new Integer[]{0,1,2,3,5,8,13,24,27,47}, kLargestOrderStatistics.getKLargest(vetorComZerosENumeros,10));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresNegativos,1000));
        assertArrayEquals(new Integer[]{}, kLargestOrderStatistics.getKLargest(vetorValoresNegativos,-2));
    }


}