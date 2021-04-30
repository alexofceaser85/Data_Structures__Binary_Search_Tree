package tests.viewmodel.initialanimalguess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import data.filepaths.FilePaths;
import viewmodel.InitialAnimalGuessViewModel;

class TestConstructor {

	@Test
	public void shouldInitializeValidValues() throws FileNotFoundException {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel guesses = new InitialAnimalGuessViewModel();
		guesses.populateAnimalGuesses(FilePaths.TEST_FILE_FOR_INITAL_GUESS_VIEW_MODEL + "\\TestConstructorValidValuesMockTestFile");
		assertEquals("[bird, dog, cat]", guesses.getAnimalGuesses().toString());
	}

}
