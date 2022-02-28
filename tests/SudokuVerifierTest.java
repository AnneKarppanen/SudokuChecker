import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String tc1 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
String tc2 = "41369825632158947958724316825437169791586432346912758289643571573291684164875293";
String tc3 = "4173698256321589479587243168254371697915864323469127582896435715732916841648752933";
String tc4 = "417360825632158947958724316825437169791586432346912758289643571573291684164875293";
String tc5 = "41736982563215894795872431682543716979158643234691275828964357157329168416487529-3";
String tc6 = "4173698256321589479587243168254371697915864323469127582896435715732916841648752-9";
String tc7 = "4173698256321589479587.02431682543716979158643234691275828964357157329168416487529";
String tc8 = "41736982563215894795.187243168254371697915864323469127582896435715732916841648752";
String tc9 = "41736982563215894795872431682543716979158643234691A758289643571573291684164875293";
String tc10 = "4173698256321589479587243168254371697”1586432346912758289643571573291684164875293";
String tc11 = "41736982563215894795872431682543716979158é432346912758289643571573291684164875293";
String tc12 = "41736982563215894795872431682543716979158643234691275828964357 573291684164875293";
String tc13 = "447369825632158947958724316825437169791586432346912758289643571573291684164875293";
String tc14 = "417369825632158947958724316825437169791586432346912758289643591573291684164875273";
String tc15 = "417369825632158947958724316825437169791586432346912758289643571753291684164875293";
String tc16 = "";
String tc17 = "417369825\n32158947958724316825437169791586432346912758289643571573291684164875293"; 

SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(tc1);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	} 
	
	@Test
	public void testStringLength() {
		int a = v.verify(tc2);
		assertEquals("incorrect String length", -1, a);
		
		a = v.verify(tc3);
		assertEquals("incorrect String length", -1, a);
		
		a = v.verify(tc16);
		assertEquals("incorrect String length (empty)", -1, a);
	}
	
	@Test
	public void testDoesNotAcceptSolutionWithIntegerOutOfRange() {
		int a = v.verify(tc4);
		assertEquals("incorrect String with Integer out of range (0)", -1, a);
		
		a = v.verify(tc5);
		assertEquals("incorrect String with Integer out of range (negative) / incorrect String length", -1, a);
		
		a = v.verify(tc6);
		assertEquals("incorrect String with Integer out of range (negative)", 1, a);
		
	}
	
	@Test
	public void testDoesNotAcceptSolutionWithDouble() {
		int a  = v.verify(tc7);
		assertEquals("incorrect String with double/ incorrect String length", -1, a);
		
		a = v.verify(tc8);
		assertEquals("incorrect String with double", 1, a);
	}
	
	@Test
	public void testDoesNotAcceptSolutionWithNonNumeralCharacter() {
		int a = v.verify(tc9);
		assertEquals("incorrect string with letter", 1, a);
		
		a = v.verify(tc10);
		assertEquals("incorrect string with quotation mark", 1, a);
		
		a = v.verify(tc11);
		assertEquals("incorrect string with special unicode character", 1, a);
		
		a = v.verify(tc12);
		assertEquals("incorrect string with space", 1, a);
		
		a = v.verify(tc17);
		assertEquals("incorrect string with line break", 1, a);
	}
	
	@Test
	public void testDoesNotAcceptSolutionThatBreaksRules1() {
		int a = v.verify(tc13);
		assertEquals("incorrect solution with number duplicate in subgrid", -2, a);
		
		a = v.verify(tc14);
		assertEquals("incorrect solution with number duplicate in row", -3, a);
		
		a = v.verify(tc15);
		assertEquals("incorrect solution with number duplicate in column", -4, a);
		
	}
	
}
