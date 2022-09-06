package pokemon;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;
public class TestJUnit {
	File pokemons = new File("src/data/pokemon.csv");
	CsvReader pokeReader = new CsvReader(pokemons);
	HashSet<Character> listOfPokemon = pokeReader.getCharacterSet();
	Pokemon tester = new Pokemon();

	
	@Test
	public void testPositiveGetHitPointList() throws IOException
	{
		pokeReader.readFile(pokemons);
		int countOfHp = tester.getHitPointList(25, listOfPokemon).size();
		assertEquals(11, countOfHp);
	}
	
	@Test
	public void testNegativeGetHitPointList() throws IOException
	{
		pokeReader.readFile(pokemons);
		int countOfHp = tester.getHitPointList(50, listOfPokemon).size();
		assertEquals(11, countOfHp);
	}
	
	@Test
	public void testPosituveGetIsLegendaryCount() throws IOException
	{
		pokeReader.readFile(pokemons);
		int countOfLegendary = tester.getIsLegendaryCount(listOfPokemon);
		assertEquals(70, countOfLegendary);
	}
	
	@Test
	public void testNegativeGetIsLegendaryCount() throws IOException
	{
		pokeReader.readFile(pokemons);
		int countOfLegendary = tester.getIsLegendaryCount(listOfPokemon);
		assertEquals(5, countOfLegendary);	
	}
	
	@Test
	public void testPositiveGetCharacterByFirstLetter() throws IOException
	{
		pokeReader.readFile(pokemons);
		int countOfInitials = tester.getCharacterByFirstLetter('c', listOfPokemon).size();
		assertEquals(63, countOfInitials);
	}
	
	@Test
	public void testNegativeGetCharacterByFirstLetter() throws IOException
	{
		pokeReader.readFile(pokemons);
		int countOfInitials = tester.getCharacterByFirstLetter('A', listOfPokemon).size();
		assertEquals(30, countOfInitials);
	}
}
