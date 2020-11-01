package binarysearchtest;

import org.junit.Before;
import org.junit.Test;
import problems.FloorBinarySearchImpl;

import static org.junit.Assert.*;

public class FloorBinarySearchImplTest {

    private FloorBinarySearchImpl implementation;
    private Integer[] vetorTamPar = { 30, 28, 7, 29, 11, 26, 4, 22, 23,31 };
    private Integer[] vetorTamImpar = { 6, 41, 32, 7, 26, 4, 37, 49,11, 18, 36 };;
    private Integer[] vetorVazio = {};
    private Integer[] vetorValoresRepetidos = { 4, 9, 3, 4, 0, 5, 1, 4, 9 };
    private Integer[] vetorValoresIguais ={ 6, 6, 6, 6, 6, 6 } ;
    private Integer[] vetorUnitario = {3};
    private Integer[] vetorValoresNegativos = {-7,-9,-1,-24,-2,-57};
    private Integer[] vetorComZeros = {0,0,0};
    private Integer[] vetorComZerosENumeros = {0,3,0,2,27,0,-12,1,-10,47,13,24,5,8};

    @Before
    public void setUp(){
        implementation = new FloorBinarySearchImpl();
    }

    public Integer convert(int n){
        return n;
    }

    @Test
    public void testFloor1(){
        assertEquals(convert(4),implementation.floor(vetorTamPar,5));
        assertEquals(convert(31),implementation.floor(vetorTamPar,32));
        assertEquals(convert(26),implementation.floor(vetorTamPar,26));
        assertNull(implementation.floor(vetorTamPar,2));
    }

    @Test
    public void testFloor2(){
        assertEquals(convert(7),implementation.floor(vetorTamImpar,7));
        assertEquals(convert(4),implementation.floor(vetorTamImpar,5));
        assertNull(implementation.floor(vetorTamImpar, 1));
    }

    @Test
    public void testFloor3(){
        Integer[] arrayVazio = new Integer[] {};
        assertNull(implementation.floor(arrayVazio, 5));
    }

    @Test
    public void testFloor4(){
        assertEquals(convert(9),implementation.floor(vetorValoresRepetidos,10));
        assertEquals(convert(0),implementation.floor(vetorValoresRepetidos,0));
        assertNull(implementation.floor(vetorValoresRepetidos,-2));
    }

    @Test
    public void testFloor5(){
        assertEquals(convert(6),implementation.floor(vetorValoresIguais,50));
        assertEquals(convert(6),implementation.floor(vetorValoresIguais,6));
        assertNull(implementation.floor(vetorValoresIguais,5));
    }
    @Test
    public void testFloor6(){
        assertEquals(convert(3),implementation.floor(vetorUnitario,3));
        assertEquals(convert(3),implementation.floor(vetorUnitario,70));
        assertNull(implementation.floor(vetorUnitario,2));
    }
    @Test
    public void testFloor7(){
        assertEquals(convert(-7),implementation.floor(vetorValoresNegativos,-6));
        assertEquals(convert(-9),implementation.floor(vetorValoresNegativos,-9));
        assertEquals(convert(-24),implementation.floor(vetorValoresNegativos,-15));
        assertNull(implementation.floor(vetorValoresNegativos,-60));
    }
    @Test
    public void testFloor8(){
        assertEquals(convert(0),implementation.floor(vetorComZeros,0));
        assertEquals(convert(0),implementation.floor(vetorComZeros,15));
        assertNull(implementation.floor(vetorComZeros,-1));
    }

    @Test
    public void testFloor9(){
        assertEquals(convert(-12),implementation.floor(vetorComZerosENumeros,-12));
        assertEquals(convert(27),implementation.floor(vetorComZerosENumeros,40));
        assertEquals(convert(47),implementation.floor(vetorComZerosENumeros,1000));
        assertNull(implementation.floor(vetorComZerosENumeros,-13));
    }

}