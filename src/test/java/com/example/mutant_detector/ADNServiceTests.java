package com.example.mutant_detector;

import com.example.mutant_detector.Servicio.ADNService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ADNServiceTests {

	private final ADNService adnService = new ADNService();

	@Test
	public void testMutant() {
		String[] mutantDNA = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCTA",
				"TCACTG"
		};
		assertTrue(adnService.isMutant(mutantDNA));
	}

	@Test
	public void testHuman() {
		String[] humanDNA = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAAG",
				"CCCCTA",
				"TCACTG"
		};
		assertFalse(adnService.isMutant(humanDNA));
	}
}
