package data.fileparsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The file parser for the initial guesses
 * 
 * @author Alex DeCesare
 * @version 25-April-2021
 */

public class InitialAnimalGuessesParser {

	private ArrayList<String> guesses;
	
	/**
	 * The constructor for the initial animal guesses parser
	 * 
	 * @precondition none
	 * @postcondition this.guesses = new ArrayList<String>()
	 */
	
	public InitialAnimalGuessesParser() {
		this.guesses = new ArrayList<String>();
	}
	
	/**
	 * parses the file
	 * 
	 * @precondition none
	 * @postcondition this.guesses.size() == number of rows in file
	 * 
	 * @param filePath the path of the file to parse
	 * 
	 * @throws FileNotFoundException throws if the file is not found
	 */
	
	public void parseFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			this.guesses.add(input.nextLine());
		}
		
		input.close();
	}
	
	/**
	 * Gets the guesses
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the guesses
	 */
	
	public ArrayList<String> getGuesses() {
		return this.guesses;
	}
	
}

