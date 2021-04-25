package viewmodel;

import java.util.ArrayList;
import java.util.Random;

import errormessages.ErrorMessages;

/**
 * The view model for the initial animal guesses
 * 
 * @author Alex DeCesare
 * @version 25-April-2021
 */

public class InitialAnimalGuessViewModel {

	private ArrayList<String> animalGuesses;
	
	/**
	 * The constructor for the initial animal guesses
	 * 
	 * @precondition animalGuesses != null
	 * @postcondition this.animalGuesses == animalGuesses
	 * 
	 * @param animalGuesses the animal guess data
	 */
	
	public InitialAnimalGuessViewModel(ArrayList<String> animalGuesses) {
		
		if (animalGuesses == null) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_ADD_NEW_INITIAL_ANIMAL_GUESS_WITH_NULL_GUESSES);
		}
		
		this.animalGuesses = animalGuesses;
	}
	
	/**
	 * Gets the animal guesses
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the animal guesses
	 */
	
	public ArrayList<String> getAnimalGuesses() {
		return this.animalGuesses;
	}
	
	/**
	 * Pick random guess
	 * 
	 * @precondition minimumIndex >= 0 && maximumIndex < this.animalGuesses.size()
	 * @postcondition none
	 * 
	 * @param minimumIndex the minimum index to find random for
	 * @param maximumIndex the maximum index to find random for
	 * 
	 * @return randomGuess the random guess
	 */
	
	public String pickRandom(int minimumIndex, int maximumIndex) {
		
		if (minimumIndex < 0) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_PICK_RANDOM_WITH_MINIMUM_INDEX_BELOW_ZERO);
		}
		if (maximumIndex > this.animalGuesses.size()) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_PICK_RANDOM_WITH_MAXIMUM_INDEX_ABOVE_OR_EQUAL_TO_ARRAY_SIZE);
		}
		if (minimumIndex >= maximumIndex) {
			throw new IllegalArgumentException(ErrorMessages.CANNOT_PICK_RANDOM_WITH_MINIMUM_INDEX_ABOVE_OR_EQUAL_TO_MAXIMUM);
		}
		
		Random randomNumber = new Random();
		int randomIndex = randomNumber.nextInt(maximumIndex - minimumIndex) + minimumIndex; 
		return this.animalGuesses.get(randomIndex);
	}
	
}
