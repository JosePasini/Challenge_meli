package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.repositories.BaseDatosAdnRepository;
import com.example.meli_punto_dos.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BaseDatosAdnServiceImpl extends BaseServiceImpl<BaseDatosAdn, Long> implements BaseDatosAdnService {

    @Autowired
    private BaseDatosAdnRepository baseDatosAdnRepository;


    public BaseDatosAdnServiceImpl(BaseRepository<BaseDatosAdn, Long> baseDatosAdnRepository){
        super(baseDatosAdnRepository);
    }



    @Transactional
    public BaseDatosAdn saveHumanAdn(Adn adn) throws Exception{
        try {
            BaseDatosAdn bd = new BaseDatosAdn();
            bd.getListaAdn_Humanos().add(adn);
            this.baseDatosAdnRepository.save(bd);
            return bd;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public BaseDatosAdn saveMutantAdn(Adn adn) throws Exception{
        try {
            BaseDatosAdn bd = new BaseDatosAdn();
            bd.getListaAdn_Mutantes().add(adn);
            this.baseDatosAdnRepository.save(bd);
            return bd;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


}
