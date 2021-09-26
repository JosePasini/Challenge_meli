package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.entities.AdnCadena;
import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.repositories.AdnRepository;
import com.example.meli_punto_dos.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class AdnServiceImpl extends BaseServiceImpl<Adn, Long> implements AdnService {

    @Autowired
    private AdnRepository adnRepository;

    public AdnServiceImpl(BaseRepository<Adn, Long> baseRepository) {
        super(baseRepository);
    }

    // Lista auxiliar donde van las cadenas de adn
    private List<String> lista_adn_final;

    // Contador para ver si el programa se rompe por mal ingreso de los datos.
    private Integer defectos = 0;

    @Override
    public AdnCadena mutant(AdnCadena lista_adn) {
        lista_adn_final = lista_adn.getAdn_cadena();
        return lista_adn;
    }

    public List<String> retorna_lista(AdnCadena lista_adn) {
        lista_adn_final = lista_adn.getAdn_cadena();
        return lista_adn_final;
    }

    public List<String> mostrarListaAdn(){
        return lista_adn_final;
    }


    public boolean isMutant(List<String> dna_list) throws Exception{
        boolean bandera = false;
        int contadorMutante = 0;

        defectos = 0;

        String[] dna = dna_list.toArray(new String[0]);


        //     ~~~    RESTRICCIONES    ~~~

        // Verifico que todas las cadenas sean iguales
        for (int i = 0; i < dna.length-1; i++) {
            if (dna[i].length() != dna[i+1].length()){
                defectos++;
                return false;
            }
        }
        // Verifico que las cadenas sean iguales a la longitud de la matriz
        if (dna[0].length() != lista_adn_final.size()) {
            defectos++;
            return false;
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
                //Verifico que no haya algun caracter o letra incorrecta
                if(     a.charAt(j) == 'A' || a.charAt(j) == 'C' || a.charAt(j) == 'G' ||a.charAt(j) == 'T'
                        || a.charAt(j) == 'a' || a.charAt(j) == 'c' || a.charAt(j) == 'g' ||a.charAt(j) == 't'
                ) {
                    matriz[i][j] = a.charAt(j);
                } else {
                    defectos++;
                    return false;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                try{
                    // verifico Columnas
                    if ((i + 4) <= matriz.length) {
                        if(matriz[i][j] == matriz[(i+1)][j]) {
                            bandera = verificarColumna(matriz, i, j, matriz[i][j]);
                            if (bandera) contadorMutante++;
                        }
                    }
                    // verifico Filas
                    if (((j+4) <= matriz[0].length)){
                        if (matriz[i][j] == matriz[(i)][j+1]) {
                            bandera = verificarFila(matriz, i, j, matriz[i][j]);
                            if (bandera) {
                                contadorMutante++;
                                j += 4;
                            }
                        }
                    }
    //########################################################################################
    //########################################################################################
                    // Diagonal arriba
                    if (i < j) {
                        if (((i + 4) <= matriz.length) && ((j + 4) <= matriz[0].length)){
                            if (matriz[i][j] == matriz[(i+1)][j+1]) {
                                bandera = verificarOblicua(matriz, i, j, matriz[i][j]);
                                if (bandera) contadorMutante++;
                            }
                        }
                    }
                    // Diagonal abajo
                    if (i > j) {
                        // Verifica diagonal
                        if (((i + 4) <= matriz.length) && ((j + 4) <= matriz[0].length)){
                            if (matriz[i][j] == matriz[(i+1)][j+1]) {
                                bandera = verificarOblicua(matriz, i, j, matriz[i][j]);
                                if (bandera) contadorMutante++;
                            }
                        }
                    }
                    // Diagonal principal
                    if (i == j) {
                        if (((i + 4) <= matriz.length) && ((j + 4) <= matriz[0].length)){
                            if (matriz[i][j] == matriz[(i+1)][j+1]) {
                                bandera = verificarOblicua(matriz, i, j, matriz[i][j]);
                                if (bandera) contadorMutante++;
                            }
                        }
                    }
                } catch (Exception e){
                    throw new Exception(e.getMessage());
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

    public String verificarLista(){
        if (!this.lista_adn_final.isEmpty()){
            return "Lista NO VACIA";
        } else {
            return "Lista VACIA weeeey";
        }
    }

    public boolean defectos(){
        if (this.defectos == 0) return true;
        return false;
    }

    // Método para ver si puedo guardar el ADN en la base de datos, todos prototipos
    // hasta que alguno funcione
    @Transactional
    public Adn saveMutant(AdnCadena adnCadena) throws Exception{
        try{
            Adn entity = new Adn();
            List<String> lista = adnCadena.getAdn_cadena();
            String aux_adn = Arrays.deepToString(lista.toArray());
            entity.setAdn_string(aux_adn);

            //entity.setBaseDatosAdn();
            Adn adn = this.adnRepository.save(entity);
            return adn;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Adn saveHuman(AdnCadena adnCadena) throws Exception{
        try{
            Adn entity = new Adn();
            List<String> lista = adnCadena.getAdn_cadena();
            String aux_adn = Arrays.deepToString(lista.toArray());
            entity.setAdn_string(aux_adn);
            Adn adn = this.adnRepository.save(entity);
            return adn;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
