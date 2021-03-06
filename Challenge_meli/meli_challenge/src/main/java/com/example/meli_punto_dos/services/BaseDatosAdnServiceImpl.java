package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.repositories.BaseDatosAdnRepository;
import com.example.meli_punto_dos.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
            // Si no existe ninguna base de datos, la instanciamos, solo una vez.
            //if (baseDatosAdnRepository.findById(1L).isEmpty()){   ESTE ES EL ORIGINAL
            if (baseDatosAdnRepository.findById(1L).isPresent()){
                BaseDatosAdn baseDatosAdn = new BaseDatosAdn();
                baseDatosAdn.getListaAdn_Humanos().add(adn);
                this.baseDatosAdnRepository.save(baseDatosAdn);
                return baseDatosAdn;
            } else {
                Optional<BaseDatosAdn> baseDatosAdnOptional = this.baseDatosAdnRepository.findById(1L);
                BaseDatosAdn baseDatosAdn = baseDatosAdnOptional.get();
                baseDatosAdn.getListaAdn_Humanos().add(adn);
                this.baseDatosAdnRepository.save(baseDatosAdn);
                return baseDatosAdn;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public BaseDatosAdn saveMutantAdn(Adn adn) throws Exception{
        try {
            //if (baseDatosAdnRepository.findById(1L).isEmpty()){
                if (baseDatosAdnRepository.findById(1L).isPresent()){
                BaseDatosAdn baseDatosAdn = new BaseDatosAdn();
                baseDatosAdn.getListaAdn_Mutantes().add(adn);
                this.baseDatosAdnRepository.save(baseDatosAdn);
                return baseDatosAdn;
            } else {
                Optional<BaseDatosAdn> baseDatosAdnOptional = this.baseDatosAdnRepository.findById(1L);
                BaseDatosAdn baseDatosAdn = baseDatosAdnOptional.get();
                baseDatosAdn.getListaAdn_Mutantes().add(adn);
                this.baseDatosAdnRepository.save(baseDatosAdn);
                return baseDatosAdn;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    @Transactional
    public Integer cantidad_humanos() throws Exception{
        try{
            return this.baseDatosAdnRepository.cantidad_humanos();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Integer cantidad_mutantes() throws Exception{
        try{
            return this.baseDatosAdnRepository.cantidad_mutantes();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }





}
