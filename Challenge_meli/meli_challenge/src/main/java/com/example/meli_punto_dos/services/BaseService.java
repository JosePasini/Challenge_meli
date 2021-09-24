package com.example.meli_punto_dos.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BaseService<E, Long> {
    public List<E> findAll() throws Exception;
    public E findById(Long id) throws Exception;
    public E save(E entity) throws Exception;

}
