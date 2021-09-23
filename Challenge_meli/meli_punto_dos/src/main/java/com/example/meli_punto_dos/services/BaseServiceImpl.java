package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.repositories.BaseRepository;
import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.swing.JOptionPane.showMessageDialog;

public abstract class BaseServiceImpl<E, Long> implements BaseService<E, Long>{

    protected BaseRepository<E, Long> baseRepository;

    public BaseServiceImpl(BaseRepository<E, Long> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception{
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(Long id) throws Exception{
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception{
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
