package com.example.meli_punto_dos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository <E, Long> extends JpaRepository<E, Long> {

}
