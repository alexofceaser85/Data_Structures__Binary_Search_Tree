package tests.viewmodel.initialanimalguess;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import viewmodel.InitialAnimalGuessViewModel;

class TestConstructor {

	@Test
	public void shouldNotAllowNullAnimalGuesses() {
		assertThrows(IllegalArgumentException.class, () -> {
			new InitialAnimalGuessViewModel(null);
		});
	}
	
	@Test
	public void shouldInitializeValidValues() {
		ArrayList<String> theGuesses = new ArrayList<String>();
		theGuesses.add("bird");
		theGuesses.add("dog");
		theGuesses.add("cat");
		InitialAnimalGuessViewModel guesses = new InitialAnimalGuessViewModel(theGuesses);
		assertEquals("[bird, dog, cat]", guesses.getAnimalGuesses().toString());
	}

}
