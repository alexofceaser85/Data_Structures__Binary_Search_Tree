package tests.viewmodel.initialanimalguess;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.filepaths.FilePaths;
import viewmodel.InitialAnimalGuessViewModel;

class TestPickRandom {

	@Test
	public void shouldNotPickRandomIfMinimumIndexIsOneBelowZero() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(-1, 1);
		});
	}
	
	@Test
	public void shouldNotPickRandomIfMinimumIndexIsWellBelowZero() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(-100, 1);
		});
	}
	
	@Test
	public void shouldNotPickRandomIfMaximumIndexIsOneAboveArraySize() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(0, 4);
		});
	}
	
	@Test
	public void shouldNotPickRandomIfMaximumIndexIsWellAboveArraySize() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(0, 100);
		});
	}
	
	@Test
	public void shouldNotRandomWithMinimumIndexOneBelowMaximumIndex() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(1, 0);
		});
	}
	
	@Test
	public void shouldNotRandomWithMinimumIndexWellBelowMaximumIndex() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		theGuesses.add("duck");
		theGuesses.add("lion");
		theGuesses.add("snake");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomManyValuesMockTestFile");
		assertThrows(IllegalArgumentException.class, () -> {
			theViewModel.pickRandom(5, 0);
		});
	}
	
	@Test
	public void shouldPickLastElementAsRandom() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertEquals("cat", theViewModel.pickRandom(2, 3));
	}
	
	@Test
	public void shouldPickMiddleElementAsRandom() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertEquals("dog", theViewModel.pickRandom(1, 2));
	}

	@Test
	public void shouldPickFirstElementAsRandom() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel theViewModel = new InitialAnimalGuessViewModel();
		theViewModel.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestPickRandomSomeValuesMockTestFile");
		assertEquals("bird", theViewModel.pickRandom(0, 1));
	}

}
