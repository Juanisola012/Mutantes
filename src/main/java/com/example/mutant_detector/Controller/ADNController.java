package com.example.mutant_detector.Controller;

import com.example.mutant_detector.Servicio.ADNService;
import com.example.mutant_detector.model.ADN;
import com.example.mutant_detector.request.DNARequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mutant")
public class ADNController {

    private final ADNService adnService;

    public ADNController(ADNService adnService) {
        this.adnService = adnService;
    }

    @PostMapping
    public ResponseEntity<Void> isMutant(@RequestBody DNARequest dnaRequest) {
        boolean mutant = adnService.isMutant(dnaRequest.getMutantDNA());
        return mutant ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }


}
