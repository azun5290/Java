package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import binf.Rosalind;

public class RosalindTest {
	@Test
	public void testGetHammingDistance() {
		// fail("Not yet implemented");
	}

	@Test
	public void testFindMaxGCContent() {
		// fail("Not yet implemented");
	}

	@Test
	public void testPrintMendeliandominanceProb() {
		// fail("Not yet implemented");
	}

	@Test
	public void testTranslateRNA() {
		String rna = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
		String prot = "MAMAPRTEINSTRING";
		String result = Rosalind.translateRNA(rna);
		System.out.println("Input sequence =\n" + rna);
		System.out.println("Protein sequence =\n" + prot);
		assertEquals(prot, result);
	}

	@Test
	public void testExactMatches() {
		String t = "GATATATGCATATACTT";
		String s = "ATAT";
		String result = Rosalind.exactMatches(s, t).trim();
		assertEquals("2 4 10", result);
	}

	@Test
	public void testConsensus() {
		String expected = "ATGCAACT\n" + "A: 5 1 0 0 5 5 0 0\n"
				+ "C: 0 0 1 4 2 0 6 1\n" + "G: 1 1 6 3 0 1 0 0\n"
				+ "T: 1 5 0 0 0 1 1 6\n";
		String result = Rosalind.findConsensus("rosalind_cons_test.fasta");
		assertEquals(expected, result);
	}
}