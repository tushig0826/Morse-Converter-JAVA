package MorseConverter;
//import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
//import MorseConverter.History;

public class BinaryTree implements Serializable {
	private char character;
	private int key;
	private BinaryTree left;
	private BinaryTree right;
	public static BinaryTree start = null;


	public static ArrayList<MorseLibrary> characters(){
		ArrayList<MorseLibrary> characters = new ArrayList<MorseLibrary>();
		characters.add(new MorseLibrary('a', ".-")) ;
		characters.add(new MorseLibrary('b', "-..."));
		characters.add(new MorseLibrary('c', "-.-."));
		characters.add(new MorseLibrary('d', "-.."));
		characters.add(new MorseLibrary('e', "."));
		characters.add(new MorseLibrary('f', "..-."));
		characters.add(new MorseLibrary('g', "--."));
		characters.add(new MorseLibrary('h', "...."));
		characters.add(new MorseLibrary('i', ".."));
		characters.add(new MorseLibrary('j', ".---"));
		characters.add(new MorseLibrary('k', "-.-"));
		characters.add(new MorseLibrary('l', ".-.."));
		characters.add(new MorseLibrary('m', "--"));
		characters.add(new MorseLibrary('n', "-."));
		characters.add(new MorseLibrary('o', "---"));
		characters.add(new MorseLibrary('p', ".--."));
		characters.add(new MorseLibrary('q', "--.-"));
		characters.add(new MorseLibrary('r', ".-."));
		characters.add(new MorseLibrary('s', "..."));
		characters.add(new MorseLibrary('t', "-"));
		characters.add(new MorseLibrary('u', "..-"));
		characters.add(new MorseLibrary('v', "...-"));
		characters.add(new MorseLibrary('w', ".--"));
		characters.add(new MorseLibrary('x', "-..-"));
		characters.add(new MorseLibrary('y', "-.--"));
		characters.add(new MorseLibrary('z', "--.."));
		characters.add(new MorseLibrary('0', "-----"));
		characters.add(new MorseLibrary('1', ".----"));
		characters.add(new MorseLibrary('2', "..---"));
		characters.add(new MorseLibrary('3', "...--"));
		characters.add(new MorseLibrary('4', "....-"));
		characters.add(new MorseLibrary('5', "....."));
		characters.add(new MorseLibrary('6', "-...."));
		characters.add(new MorseLibrary('7', "--..."));
		characters.add(new MorseLibrary('8', "---.."));
		characters.add(new MorseLibrary('9', "----."));
		characters.add(new MorseLibrary(':', "--..."));
		characters.add(new MorseLibrary(',', "--..--"));
		characters.add(new MorseLibrary('(', "-.--."));
		characters.add(new MorseLibrary(')', "-.--.-"));
		characters.add(new MorseLibrary('!', "-.-.--"));
		characters.add(new MorseLibrary('/', "-..-."));
		characters.add(new MorseLibrary('=', "-...-"));
		characters.add(new MorseLibrary('-', "-....-"));
		characters.add(new MorseLibrary('@', ".--.-."));
		characters.add(new MorseLibrary('+', ".-.-."));
		characters.add(new MorseLibrary('.', ".-.-.-"));
		return characters;
	}
	public static BinaryTree Node(char item, int key)
	{
		BinaryTree tmp = new BinaryTree();
		tmp.character = item;
		tmp.key = key;
		tmp.left = null;
		tmp.right = null;
		
		return tmp;
	}
	public static BinaryTree AddNode(BinaryTree start, char value, int key)
	{
		if (start == null)
		{
			return Node(value, key);
		}
		if (key < start.key)
		{
			start.left = AddNode(start.left, value, key);
		}
		else if(key > start.key)
		{
			start.right = AddNode(start.right, value, key);
		}
		return start;
	}
	
	public BinaryTree(){}
	
	static char GetText(String str, BinaryTree start)
	{
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == '|')
			{
				break;
			}
			if(str.charAt(i) == '-')
			{
				start = start.left;
			}
			if(str.charAt(i) == '.')
			{
				start = start.right;
			}
			if (start == null)
			{
				System.out.print("Invalid Code!");
			}
		}
		return start.character;
	}
	public static String Decode(String morse, BinaryTree start)
	{
		if(morse.length() == 0)
		{
			String error = "Invalid! The text box is empty!";
			return error;
		}
		else {
		String output = "";
		String[] temp = morse.split(" ");
		
		for(int i = 0; i < temp.length; i++)
		{
			output = output + GetText(temp[i], start);
		}
		
		try {
			History.saveHistory("history.txt", morse);
			History.saveHistory("history.txt", output);
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
		return output;
		}
	}
	public static String Code(String text)
	{
		if(text.length() == 0)
		{
			String error = "Invalid! The text box is empty!";
			return error;
		}
		else {
		String output = "";
		for(int i = 0; i < text.length(); i++)
		{
			
			for(int k = 0; k < characters().size(); k++)
			{
				
				if(text.charAt(i) == characters().get(k).getCharacters())
				{
					
					String morse = characters().get(k).getMorse();
					output = output + " " + morse;
					
				}
			}
		}
		try {
			History.saveHistory("history.txt", text);
			History.saveHistory("history.txt", output);
			MorseSound.saveMorse("sound.txt", output);
		} catch(IOException e) {
			e.printStackTrace();
		} 
		return output;
		}
	}
	public void statistics()
	{
		System.out.println("Printing the Dictionary:");
		for(int i=0; i<characters().size();i++) {
			System.out.println(  characters().get(i).getCharacters());
		}
		
	}
}


