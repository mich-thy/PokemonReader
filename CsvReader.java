package pokemon;
import java.io.*;
import java.util.*;

public class CsvReader {
	//private BufferedReader theBufferedReader;
	private HashSet<Character> pokemonList;
	private File pokemonFile;
	
	public CsvReader (File pokemonFile)
	{
		this.pokemonFile = pokemonFile;
		pokemonList = new HashSet<Character>();
	}
	
	public boolean readFile(File fileName) throws IOException{
		boolean result = false;
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		if (!fileName.exists()){
			result = false;
		}
		else
		{
			try
			{
				String characterInfo = br.readLine();
				characterInfo = br.readLine();
				while (characterInfo != null)
				{
					pokemonList.add(new Character(characterInfo));
					characterInfo = br.readLine();
				}
				result = true;
			}
			catch (IOException error)
			{
				System.out.println("The file error is incorrect" + error.getMessage());
				result = false;
			}
		}
		br.close();
		fr.close();
		return result;
	}
	
	public HashSet<Character> getCharacterSet()
	{
		return pokemonList;
	}
}
