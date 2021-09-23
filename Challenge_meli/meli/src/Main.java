
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        final String ADN_FINAL_A = "AAAA";
        final String ADN_FINAL_C = "CCCC";
        final String ADN_FINAL_G = "GGGG";
        final String ADN_FINAL_T = "TTTT";

        //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCCA","TCACGG"};

        String[] dna = {"AGCCCC","CTTfCC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        String[] dna2 = {"ATGCGAa","CAGTGCa","TTATGTa","AGAAGGa","CCCCTAa","TCACTGa", "FDSASDc"};

        System.out.println("####################################");

        List<String> lista = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();

        String a = "AACCAA", b = "CAGTGC", c = "TTATGT", d = "AGAAGG", e = "CCCCTA", f = "TCACGG";

        String a2 = "TTTTTT", b2 = "TTTTTT", c2 = "TTTTTT", d2 = "TTTTTT", e2 = "TTTTTT", f2 = "TTTTs";

        lista = Arrays.asList(a,b,c,d,e,f);
        lista2 = Arrays.asList(a2,b2,c2,d2,e2,f2);


        System.out.println(isMutant(dna));


 /*
        String[] prueba = lista.toArray(lista.toArray(new String[0]));

        for (int i = 0; i < prueba.length; i++) {
            System.out.println(prueba[i]);
        }

        System.out.println("##########  TEST  ---  IS MUTANT  ############");
        System.out.println(testIsMutant(lista));
*/



    }



    public static boolean verificarLetraChar(char[][] matriz){
        boolean bandera = true;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }



        return bandera;
    }

    public static boolean testIsMutant(List<String> dna_list){
        boolean bandera = false;
        int contadorMutante = 0;



        // Pasando la List<> a String[]
        System.out.println("#########################");

        System.out.println("#########################");
        String[] dna = dna_list.toArray(new String[0]);





        System.out.println("######### ARREGLOO #######");

        for (int i = 0; i < dna.length-1; i++) {
            if (dna[i].length() != dna[i + 1].length()) {
                System.out.println("FALSE FALSE FALSE FALSE FALSEEEE");
                return false;
            } else {
                System.out.println("TRUE TRUE TRUE TRUE");
            }
        }

            // Creando una matriz para recorrer los casilleros
        char matriz[][] = new char[dna.length][dna.length];



        //Acá voy a almacenar el String completo.
        String a = "";

        // Pasando las 5 posiciones del arreglo a Matriz.
        // ¿hay alguna solución mejor? seguro.
        for (int i = 0; i < matriz.length; i++) {
            a = dna[i];
            for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = a.charAt(j);
            }
        }

        System.out.println("###################################################");
        System.out.println("####### VERIFICAR CHAR CHAR CHAR LETRA ##########");
        System.out.println("BOOLEAN: " +verificarLetraChar(matriz));
        System.out.println("###################################################");

        System.out.println("######### MATRIZ #######");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                try{
                    // Verifico Columnas
                    if ((i + 4) < matriz.length) {
                        if(matriz[i][j] == matriz[(i+1)][j]) {
                            bandera = verificarColumna(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                        }
                    }

                    // verifico Filas
                    if (((j+4) < matriz[0].length)){
                        if (matriz[i][j] == matriz[(i)][j+1]) {
                            bandera = verificarFila(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                        }
                    }

                    // Verifico Diagonal
                    if (((i + 4) < matriz.length) && ((j + 4) < matriz[0].length)){
                        if (matriz[i][j] == matriz[(i+1)][j+1]) {
                            bandera = verificarOblicua(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                        }
                    }
                } catch (Exception e){
                    // Excepcion
                }

                // Acá estaría terminando
                if (contadorMutante >= 2) {
                    bandera = true;
                } else{
                    bandera = false;
                }

            }
        }

        return bandera;
    }


    // METODO RECIBIENDO EL STRING[] dna  < ----- > SIN LISTA.
    public static boolean isMutant(String[] dna){
        boolean bandera = false;
        int contadorMutante = 0;

        char matriz[][] = new char[dna.length][dna.length];



        String a = "";

        // Pasando las 5 posiciones del arreglo a Matriz.
        // ¿hay alguna solución mejor? seguro.
        for (int i = 0; i < matriz.length; i++) {
            a = dna[i];
            for (int j = 0; j < matriz[0].length; j++) {
                char que_hay = a.charAt(j);
                if(a.charAt(j) == 'A' || a.charAt(j) == 'C' || a.charAt(j) == 'G' ||a.charAt(j) == 'T'){
                    matriz[i][j] = a.charAt(j);

                } else {
                    System.out.println(que_hay);
                    System.out.println("DESIGUAAAAAL :" +a.charAt(j));

                    bandera = false;
                    return bandera;

                }
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

                            bandera = verificarColumna(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;

                            if (bandera) System.out.println("IDEM COLUMNA, " + matriz[i][j] + " == " + matriz[(i+1)][j] + " , I: " + (i) + " , J: " +(j)  );

                            //System.out.println("BANDERA COLUMNA: " + bandera);
                        }
                    }

                    // verifico Filas
                    if (((j+3) < matriz[0].length)){
                        if (matriz[i][j] == matriz[(i)][j+1]) {
                            System.out.println("DADADADA");
                            bandera = verificarFila(matriz, i, j, matriz[i][j]);
                            if (bandera) {
                                contadorMutante++;
                                j += 4;
                            }

                            if (bandera) System.out.println("IDEM FILA, " + matriz[i][j] + " == " + matriz[(i)][j+1] + " , I: " + (i) + " , J: " +(j) );
                            //System.out.println("BANDERA FILA: " + bandera);
                        }
                    }

                    // Verifico Diagonal
                    if (((i + 3) < matriz.length) && ((j + 4) < matriz[0].length)){
                        if (matriz[i][j] == matriz[(i+1)][j+1]) {

                            bandera = verificarOblicua(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;

                            if (bandera) System.out.println("IDEM DIAGONAL: " + matriz[i][j] + " == " + matriz[(i+1)][j+1] + " , I: " + (i) + " , J: " +(j)  );
                            //System.out.println("BANDERA DIAGONAL: " + bandera);
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
