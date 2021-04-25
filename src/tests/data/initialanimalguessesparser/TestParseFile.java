package tests.data.initialanimalguessesparser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import data.fileparsers.InitialAnimalGuessesParser;

class TestParseFile {

	@Test
	public void shouldNotParseFileThatIsNotFound() {
		InitialAnimalGuessesParser parser = new InitialAnimalGuessesParser();
		assertThrows(FileNotFoundException.class, () -> {
			parser.parseFile("this is not a valid file path");
		});
	}
	
	@Test
	public void shouldParseFoundFile() throws FileNotFoundException {
		InitialAnimalGuessesParser parser = new InitialAnimalGuessesParser();
		parser.parseFile("src\\tests\\data\\initialanimalguessesparser\\MockTestFile");
		assertEquals("[Lion, Dog, Robin, Snake]", parser.getGuesses().toString());
	}

}
