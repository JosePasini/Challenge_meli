import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACGG"};

        System.out.println("####################################");

        System.out.println(isMutant(dna));

    }

    public static boolean isMutant(String[] dna){
        boolean bandera = false;
        int contadorMutante = 0;

        char matriz[][] = new char[6][6];
        String a = "";

        // Pasando las 5 posiciones del arreglo a Matriz.
        // ¿hay alguna solución mejor? seguro.
        for (int i = 0; i < matriz.length; i++) {
            a = dna[i];
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = a.charAt(j);
            }
        }

        // Dibujando la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

        System.out.println("########################");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                try {

                    // Verifico Columnas
                    if ((i + 4) < matriz.length) {
                        if(matriz[i][j] == matriz[(i+1)][j]) {
                            System.out.println("IDEM COLUMNA, " + matriz[i][j] + " == " + matriz[(i+1)][j] + " , I: " + (i) + " , J: " +(j)  );
                            bandera = verificarColumna(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                            System.out.println("BANDERA COLUMNA: " + bandera);
                        }
                    }

                    // verifico Filas
                    if (((j+4) < matriz[0].length)){
                        if (matriz[i][j] == matriz[(i)][j+1]) {
                            System.out.println("IDEM FILA, " + matriz[i][j] + " == " + matriz[(i)][j+1] + " , I: " + (i) + " , J: " +(j) );
                            bandera = verificarFila(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                            System.out.println("BANDERA FILA: " + bandera);
                        }
                    }

                    // Verifico Diagonal
                    if (((i + 4) < matriz.length) && ((j + 4) < matriz[0].length)){
                        if (matriz[i][j] == matriz[(i+1)][j+1]) {
                            System.out.println("IDEM DIAGONAL: " + matriz[i][j] + " == " + matriz[(i+1)][j+1] + " , I: " + (i) + " , J: " +(j)  );
                            bandera = verificarOblicua(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                            System.out.println("BANDERA DIAGONAL: " + bandera);
                        }
                    }

                } catch (Exception e){
                    System.out.println("WE: " + e.getMessage());
                }
            }
        }

        JOptionPane.showMessageDialog(null, "CONTADOR MUTANTE: " + contadorMutante);

        if (contadorMutante >= 2) {
            return true;
        } else{
            return false;
        }

    }

    static boolean verificarColumna(char[][] matriz, int indice, int jota, char x){
        for (int i = indice; i < (indice+4); i++) {
            if (matriz[i][jota] != x){
                return false;
            }
        }
        return true;
    }
    static boolean verificarFila(char[][] matriz, int indice, int jota, char x){
        for (int i = jota; i < (jota+4); i++) {
            if (matriz[indice][i] != x){
                return false;
            }
        }
        return true;
    }
    static boolean verificarOblicua(char[][] matriz, int indice, int jota, char x){
        for (int i = indice; i < (indice+4); i++) {
            if (matriz[i][jota] != x) return false;
            jota++;
        }
        return true;
    }

}
