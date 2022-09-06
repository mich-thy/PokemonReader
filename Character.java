package pokemon;

public class Character implements Comparable {
	private int hp;
	private String name;
	private int is_legendary;
	
	public Character(String dataLine)
	{
		String[] characterInfo = dataLine.split(",");
		name = characterInfo[characterInfo.length - 11];
		hp = Integer.parseInt(characterInfo[characterInfo.length - 13]);
		is_legendary = Integer.parseInt(characterInfo[characterInfo.length - 1]);
	}
	public String getName()
	{
		return name;
	}
	public int getHp()
	{
		return hp;
	}
	public int getLegendary()
	{
		return is_legendary;
	}
	public int compareTo(Object obj)
	{
		Character that = (Character)obj;
		int result = this.name.compareTo(that.name);
		if (result == 0)
		{
			if (this.hp < that.hp) {
				result = -1;
			}
			else if (this.hp > that.hp) {
				result = 1;
			}
			else {
				result = 0;
			}
		}
		return result;
	}
	public static void main(String[] args) 
	{
		String data = "\"['Oblivious', 'Own Tempo', 'Regenerator']\",2,2,1,2,1,0.5,0.5,1,2,2,1,0.5,1,1,0.5,1,0.5,0.5,75,5120,70,590,75,Hermit Crab Pokémon,180,1000000,1.6,95,Yadoranヤドラン,Slowbro,50,80,130,80,30,water,psychic,78.5,1,0";
		Character tester = new Character(data);
		System.out.println(tester.getName());
		System.out.println(tester.getHp());
		System.out.println(tester.getLegendary());
		char ch = 'c';
		String st = String.valueOf(ch);
		System.out.println(st);
		String str = "candy";
		System.out.println(st.substring(0,1));

		System.out.println(st.equals(str));
	}
}
