package com.example.mutant_detector.Controller;

import com.example.mutant_detector.Servicio.ADNService;
import com.example.mutant_detector.model.ADN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class ADNController {
    @Autowired
    private ADNService adnService;
    @PostMapping
    public ResponseEntity<?> detectMutant(@RequestBody ADN adn) {
        boolean isMutant = adnService.isMutant(adn.getSequence());
        adnService.saveADN(adn);//Guardar la secuencia de ADN en la base
        if (isMutant){
            return ResponseEntity.ok().build(); //200 OK
        }else {
            return ResponseEntity.status(403).build(); //403 Forbidden
        }
    }


}
