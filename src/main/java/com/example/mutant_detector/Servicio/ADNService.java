package com.example.mutant_detector.Servicio;

import com.example.mutant_detector.Repositorio.ADNRepository;
import com.example.mutant_detector.model.ADN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ADNService {
    @Autowired
    private ADNRepository adnRepository;

    public boolean isMutant(String[] dna) {
        int count = 0;
        int length = dna.length;

        // Contar secuencias horizontales y verticales
        for (int i = 0; i < length; i++) {
            count += countSequences(dna[i]); // Horizontal
            count += countSequences(getVerticalSequence(dna, i)); // Vertical
        }

        // Contar secuencias diagonales
        count += countDiagonalSequences(dna);

        return count > 1; // Más de una secuencia de mutante
    }

    private int countSequences(String sequence) {
        int count = 0;
        int consecutive = 0;
        char lastChar = ' ';

        for (char currentChar : sequence.toCharArray()) {
            if (currentChar == lastChar) {
                consecutive++;
            } else {
                lastChar = currentChar;
                consecutive = 1;
            }
            if (consecutive == 4) {
                count++;
                consecutive = 0; // Reiniciar para evitar contar la misma secuencia
            }
        }
        return count;
    }

    private String getVerticalSequence(String[] dna, int index) {
        StringBuilder vertical = new StringBuilder();
        for (String row : dna) {
            vertical.append(row.charAt(index));
        }
        return vertical.toString();
    }

    private int countDiagonalSequences(String[] dna) {
        int count = 0;
        int length = dna.length;

        // Diagonales de izquierda a derecha
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                count += countDiagonal(dna, i, j, 1, 1); // Diagonal principal
                count += countDiagonal(dna, i, j, 1, -1); // Diagonal secundaria
            }
        }
        return count;
    }

    private int countDiagonal(String[] dna, int row, int col, int rowStep, int colStep) {
        StringBuilder diagonal = new StringBuilder();
        while (row < dna.length && row >= 0 && col < dna.length && col >= 0) {
            diagonal.append(dna[row].charAt(col));
            row += rowStep;
            col += colStep;
        }
        return countSequences(diagonal.toString());
    }
}
