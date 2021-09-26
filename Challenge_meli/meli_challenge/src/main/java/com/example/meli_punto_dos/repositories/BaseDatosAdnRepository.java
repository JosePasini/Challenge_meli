package com.example.meli_punto_dos.repositories;

import com.example.meli_punto_dos.entities.BaseDatosAdn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDatosAdnRepository extends BaseRepository<BaseDatosAdn, Long>{

    @Query(value = "SELECT COUNT(*) FROM base_datos_adn_lista_adn_humanos", nativeQuery = true)
    Integer cantidad_humanos();

    @Query(value = "SELECT COUNT(*) FROM base_datos_adn_lista_adn_mutantes", nativeQuery = true)
    Integer cantidad_mutantes();

}
