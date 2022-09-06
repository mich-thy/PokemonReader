package pokemon;
import java.io.*;
import java.util.*;

public class Pokemon {
	
	
	//Returns a HashSet of pokemons that fall within 0 and the maxHp
	public HashSet<Character> getHitPointList(int maxHP, HashSet<Character> baseSet)
	{
		HashSet<Character> listOfPokemon = new HashSet<Character>();
		for (Character pokemon: baseSet)
		{
			if (pokemon.getHp() >= 0 && pokemon.getHp() <= maxHP)
				listOfPokemon.add(pokemon);
		}
		return listOfPokemon;
	}
	
	//Gets the amount of legendary pokemons
	public int getIsLegendaryCount(HashSet<Character> baseSet)
	{
		int count = 0;
		for (Character pokemon: baseSet)
		{
			if (pokemon.getLegendary() == 1)
				count++;
		}
		return count;
	}
	
	//Gets the pokemons that start with the letter we are searching for
	public TreeSet<Character> getCharacterByFirstLetter(char firstLetter, HashSet<Character> baseSet)
	{
		TreeSet<Character> listOfPokemon = new TreeSet<Character>();
		String initial = String.valueOf(firstLetter);
		initial = initial.toLowerCase();
		for (Character pokemon: baseSet)
		{
			String name = pokemon.getName().substring(0, 1);;
			name = name.toLowerCase();
			if (name.contains(initial))
			{
				listOfPokemon.add(pokemon);	
			}
		}
		return listOfPokemon;
	}
	
	public static void main(String[] args) throws IOException
	{
		File pokemons = new File("src/data/pokemon.csv");
		CsvReader trial = new CsvReader(pokemons);
		HashSet<Character> base = trial.getCharacterSet();
		Pokemon trial2 = new Pokemon();
		
		//determines if the file was read correctly
		System.out.println("Did the file read: " + trial.readFile(pokemons));
		System.out.println(" ");
		
		//prints out all the names of the pokemon with its hp, name, and legendary
		System.out.print("List of pokemon (name, is_Legendary, hp): ");
		for (Character c: base)
			System.out.print(c.getName() + "," + c.getLegendary() + "," + c.getHp() + " ");
		System.out.println(" ");
		
		//Prints out the pokemon that is within the range of hp
		System.out.println(" ");
		System.out.println("Max hit point list: ");
		HashSet<Character> hs = trial2.getHitPointList(25, base);
		for (Character c: hs)
		{
			System.out.print(c.getName() + " hp: " + c.getHp() + ", ");
		}
		System.out.println(" ");
		System.out.println(" ");
		
		//prints out how many legendary pokemon are there
		System.out.println("is_Legendary count: " + trial2.getIsLegendaryCount(base)); 
		System.out.println(" ");
		
		//prints out the list of pokemon that start with "C"
		TreeSet<Character> tr = trial2.getCharacterByFirstLetter('C', base);
		System.out.println("Characters that start with C: ");
		for (Character c: tr )
			System.out.print(c.getName() + ", ");
	}
}
