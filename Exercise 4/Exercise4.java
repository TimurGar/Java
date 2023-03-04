/**
 * @author Timur Garifullin
 */

import java.util.Set;
import java.util.HashSet;
public class Exercise4
{
	public static void main(String[] args) 
	{
		// testing method cotains
		Set<Character> aSet = new HashSet<>();
		aSet.add('a');
		aSet.add('e');
		System.out.println("Set cointains a: " + aSet.contains('a'));
		System.out.println("Set cointains t: " + aSet.contains('t'));

		System.out.println();
		String letters = "element";	
		Set<Character> vowels = new HashSet<>();
		Set<Character> consonants = new HashSet<>();

		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		for(int i = 0; i < letters.length(); i++){
			char letter = letters.charAt(i);
			if(vowels.contains(letter) == false){
				consonants.add(letter);
			}
		}
		System.out.println("Number of consonants in the set consonants is " + consonants.size());
		
	}
}