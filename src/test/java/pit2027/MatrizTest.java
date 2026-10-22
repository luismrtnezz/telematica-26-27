package pit2027;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MatrizTest {
    @Test
    public void constructorMatrizRectangular() {
        double[][] datos = { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 } };
        Matriz m = new Matriz(datos);
        assertArrayEquals(new int[] { 2, 3 }, m.getDimension());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(datos[i][j], m.getElemento(i, j), 1e-9);
            }
        }
    }

    @Test
    public void constructorRellenaConCeros() {
        double[][] datos = { { 1.0, 2.0, 3.0 }, { 4.0, 5.0 }, { 6.0 } };
        Matriz m = new Matriz(datos);
        assertArrayEquals(new int[] { 3, 3 }, m.getDimension());
        assertEquals(4.0, m.getElemento(1, 0), 1e-9);
        assertEquals(5.0, m.getElemento(1, 1), 1e-9);
        assertEquals(0.0, m.getElemento(1, 2), 1e-9);
        assertEquals(6.0, m.getElemento(2, 0), 1e-9);
        assertEquals(0.0, m.getElemento(2, 1), 1e-9);
        assertEquals(0.0, m.getElemento(2, 2), 1e-9);
    }

    @Test
    public void constructorHaceUnaCopiaDeLosDatos() {
        double[][] datos = { { 1.0, 2.0 }, { 3.0, 4.0 } };
        Matriz m = new Matriz(datos);
        datos[0][0] = 100.0;
        assertEquals(1.0, m.getElemento(0, 0), 1e-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorMatrizNull() { new Matriz(null); }

    @Test(expected = IllegalArgumentException.class)
    public void constructorMatrizVacia() { new Matriz(new double[0][0]); }

    @Test(expected = IllegalArgumentException.class)
    public void constructorMatrizConFilasVacias() {
        double[][] datos = { {}, {} };
        new Matriz(datos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorMatrizConFilasNull() {
        double[][] datos = { { 1.0, 2.0 }, null };
        new Matriz(datos);
    }
    
    @Test
    public void sumaMatricesDeMismaDimension() {
        double[][] datosA = { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 } };
        double[][] datosB = { { 10.0, 20.0, 30.0 }, { 40.0, 50.0, 60.0 } };
        Matriz a = new Matriz(datosA);
        Matriz b = new Matriz(datosB);
        Matriz suma = a.suma(b);

        assertNotNull(suma);
        assertArrayEquals(new int[] { 2, 3 }, suma.getDimension());
        assertEquals(11.0, suma.getElemento(0, 0), 1e-9);
        assertEquals(66.0, suma.getElemento(1, 2), 1e-9);
    }

    @Test
    public void sumaConNullDevuelveNull() {
        Matriz m = new Matriz(new double[][] { { 1.0 } });
        assertNull(m.suma(null));
    }

    @Test
    public void sumaConDimensionDiferenteDevuelveNull() {
        Matriz a = new Matriz(new double[][] { { 1.0, 2.0 } });
        Matriz b = new Matriz(new double[][] { { 1.0 } });
        assertNull(a.suma(b));
    }
}