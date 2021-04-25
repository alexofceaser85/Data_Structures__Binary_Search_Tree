package tests.viewmodel.initialanimalguess;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import viewmodel.InitialAnimalGuessViewModel;

class TestPickRandom {

	@Test
	public void shouldNotPickRandomIfMinimumIndexIsOneBelowZero() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(-1, 1);
		});
	}
	
	@Test
	public void shouldNotPickRandomIfMinimumIndexIsWellBelowZero() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(-100, 1);
		});
	}
	
	@Test
	public void shouldNotPickRandomIfMaximumIndexIsOneAboveArraySize() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(0, 4);
		});
	}
	
	@Test
	public void shouldNotPickRandomIfMaximumIndexIsWellAboveArraySize() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(0, 100);
		});
	}
	
	@Test
	public void shouldNotRandomWithMinimumIndexOneBelowMaximumIndex() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(1, 0);
		});
	}
	
	@Test
	public void shouldNotRandomWithMinimumIndexWellBelowMaximumIndex() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		theGuesses.add("duck");
		theGuesses.add("lion");
		theGuesses.add("snake");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(5, 0);
		});
	}
	
	@Test
	public void shouldPickLastElementAsRandom() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertEquals("cat", theViewModel.pickRandom(2, 3));
	}
	
	@Test
	public void shouldPickMiddleElementAsRandom() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertEquals("dog", theViewModel.pickRandom(1, 2));
	}

	@Test
	public void shouldPickFirstElementAsRandom() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel(theGuesses);
		
		assertEquals("bird", theViewModel.pickRandom(0, 1));
	}

}
