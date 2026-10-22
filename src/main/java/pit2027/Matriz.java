package pit2027;

/**
 * Representa una matriz rectangular de números reales.
 */
public class Matriz {
    private double[][] datos;
    private int filas;
    private int columnas;

    public Matriz(double[][] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("La matriz debe tener al menos una fila");
        }
        columnas = 0;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == null) {
                throw new IllegalArgumentException("Las filas no pueden ser null");
            }
            if (valores[i].length > columnas) {
                columnas = valores[i].length;
            }
        }
        if (columnas == 0) {
            throw new IllegalArgumentException("La matriz debe tener al menos una columna");
        }
        filas = valores.length;
        datos = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < valores[i].length; j++) {
                datos[i][j] = valores[i][j];
            }
        }
    }

    public int[] getDimension() {
        return new int[] { filas, columnas };
    }

    public double getElemento(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IllegalArgumentException("Argumento fuera de rango");
        }
        return datos[fila][columna];
    }

    /**
     * Suma esta matriz con otra.
     * @param otra matriz a sumar.
     * @return matriz suma, o null si otra es null o las dimensiones no coinciden.
     */
    public Matriz suma(Matriz otra) {
        if (otra == null || otra.filas != this.filas || otra.columnas != this.columnas) {
            return null;
        }
        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = this.datos[i][j] + otra.datos[i][j];
            }
        }
        return new Matriz(resultado);
    }

    /**
     * Suma dos matrices (versión estática).
     * @param a primera matriz.
     * @param b segunda matriz.
     * @return matriz suma, o null si alguna es null o las dimensiones no coinciden.
     */
    public static Matriz suma(Matriz a, Matriz b) {
        if (a == null || b == null) {
            return null;
        }
        return a.suma(b);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            resultado.append("[");
            for (int j = 0; j < columnas; j++) {
                resultado.append(datos[i][j]);
                if (j < columnas - 1) {
                    resultado.append(", ");
                }
            }
            resultado.append("]");
            if (i < filas - 1) {
                resultado.append(System.lineSeparator());
            }
        }
        return resultado.toString();
    }
}