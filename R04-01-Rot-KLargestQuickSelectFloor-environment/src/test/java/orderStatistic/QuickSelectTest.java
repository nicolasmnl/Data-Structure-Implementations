package orderStatistic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSelectTest {

    QuickSelect<Integer> implementation;

    private Integer[] vetorTamPar = { 30, 28, 7, 29, 11, 26, 4, 22, 23,31 };
    private Integer[] vetorTamImpar = { 6, 41, 32, 7, 26, 4, 37, 49,11, 18, 36 };;
    private Integer[] vetorVazio = {};
    private Integer[] vetorValoresIguais ={ 6, 6, 6, 6, 6, 6 } ;
    private Integer[] vetorUnitario = {3};
    private Integer[] vetorValoresNegativos = {-7,-9,-1,-24,-2,-57};
    private Integer[] vetorComZerosENumeros = {0,3,0,2,27,0,-12,1,-10,47,13,24,5,8};

    @Before
    public void setUp(){
        implementation = new QuickSelect<>();
    }

    @Test
    public void testQuickSelect1(){
        assertEquals(4,implementation.quickSelect(vetorTamPar, 1));
        assertEquals(31,implementation.quickSelect(vetorTamPar, vetorTamPar.length));
        assertNull(implementation.quickSelect(vetorTamPar,20));
        assertNull(implementation.quickSelect(vetorTamPar,0));

    }

    @Test
    public void testQuickSelect2(){
        assertEquals(4,implementation.quickSelect(vetorTamImpar, 1));
        assertEquals(49,implementation.quickSelect(vetorTamImpar, vetorTamImpar.length));
        assertNull(implementation.quickSelect(vetorTamImpar,20));
        assertNull(implementation.quickSelect(vetorTamImpar,0));

    }

    @Test
    public void testQuickSelect3(){
        assertNull(implementation.quickSelect(vetorVazio, 10));
    }

    @Test
    public void testQuickSelect4(){
        assertEquals(3,implementation.quickSelect(vetorUnitario,1));
        assertNull(implementation.quickSelect(vetorUnitario, 10));
    }

    @Test
    public void testQuickSelect5(){
        assertEquals(6, implementation.quickSelect(vetorValoresIguais, 3));
        assertEquals(6, implementation.quickSelect(vetorValoresIguais, 1));
        assertNull(implementation.quickSelect(vetorValoresIguais, -1));

    }

    @Test
    public void testQuickSelect6(){
        assertEquals(-57,implementation.quickSelect(vetorValoresNegativos,1));
        assertNull(implementation.quickSelect(vetorValoresNegativos, vetorValoresNegativos.length + 1));
    }
}