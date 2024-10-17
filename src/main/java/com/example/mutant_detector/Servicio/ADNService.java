package com.example.mutant_detector.Servicio;

import com.example.mutant_detector.Repositorio.ADNRepository;
import com.example.mutant_detector.model.ADN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ADNService {
    @Autowired
    private ADNRepository adnRepository;

    public boolean isMutant(String[] adn){
        return false;
    }
    public void saveADN(ADN adn){
        adnRepository.save(adn);
    }
}
