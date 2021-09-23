package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.repositories.BaseDatosAdnRepository;
import com.example.meli_punto_dos.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDatosAdnServiceImpl extends BaseServiceImpl<BaseDatosAdn, Long> implements BaseDatosAdnService {

    @Autowired
    private BaseDatosAdnRepository baseDatosAdnRepository;

    public BaseDatosAdnServiceImpl(BaseRepository<BaseDatosAdn, Long> baseDatosAdnRepository){
        super(baseDatosAdnRepository);
    }

}
