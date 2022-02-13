package MorseConverter;

public class MorseLibrary {
	private char character;
	private String Morse;
	
	public MorseLibrary(char character, String Morse) 
	{
		this.character = character;
		this.Morse = Morse;
	}
	public char getCharacters() {return character;}
	public void setCharacters(char character) {this.character = character;}
	public String getMorse() {return Morse;}
	public void setMorse(String Morse) {this.Morse = Morse;}
}

