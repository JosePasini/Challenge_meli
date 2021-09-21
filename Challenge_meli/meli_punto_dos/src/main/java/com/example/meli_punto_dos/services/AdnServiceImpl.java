package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.repositories.AdnRepository;
import com.example.meli_punto_dos.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdnServiceImpl extends BaseServiceImpl<Adn, Long> implements AdnService {

    @Autowired
    private AdnRepository adnRepository;

    public AdnServiceImpl(BaseRepository<Adn, Long> baseRepository) {
        super(baseRepository);
    }


}
