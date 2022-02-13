package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import MorseConverter.BinaryTree;

class BinaryTreeTest {

	@Test
	public void testCode() {
		assertEquals(" - ..- ... .... .. --.", BinaryTree.Code("tushig"));
	}
	@Test
	public void testDeode() {
		char characters[] = {' ','t','m','o','#','0','9','#','8',':','g','q','z','#',',','7','n','k','y','(',')','c','#','!','d','x','/','b','=','6','-','e','a','w','j','1','#','p','#','@','r','#','+','.','l','#','&','i','u','#','2','#','?','f','s','v','3','h','4','5'};		
		int keys[] = { 31, 15, 8, 4, 2, 1, 3, 5, 6, 7, 10, 9, 13, 12, 11, 14, 23, 19, 16, 18, 17, 22, 21, 20, 26, 24, 25, 28, 27, 30, 29, 47, 39, 35, 34, 32, 33, 38, 36, 37, 43, 40, 42, 41, 45, 44, 46, 54, 52, 49, 48, 50, 51, 53, 57, 56, 55, 59, 58, 60 };
		
		BinaryTree start = null;
		start = BinaryTree.AddNode(start, characters[0], keys[0]);
	
		for (int i = 1; i < characters.length; i++)
		{
			BinaryTree.AddNode(start, characters[i], keys[i]);
		}
		assertEquals("tushig", BinaryTree.Decode("- ..- ... .... .. --.", start));
	}
	
	@Test
	public void testGetText1() {
		assertNotEquals(" --. ..- ... .... .. -", BinaryTree.Code("tushig"));
		}
	
	@Test
	public void testDeode1() {
		char characters[] = {' ','t','m','o','#','0','9','#','8',':','g','q','z','#',',','7','n','k','y','(',')','c','#','!','d','x','/','b','=','6','-','e','a','w','j','1','#','p','#','@','r','#','+','.','l','#','&','i','u','#','2','#','?','f','s','v','3','h','4','5'};		
		int keys[] = { 31, 15, 8, 4, 2, 1, 3, 5, 6, 7, 10, 9, 13, 12, 11, 14, 23, 19, 16, 18, 17, 22, 21, 20, 26, 24, 25, 28, 27, 30, 29, 47, 39, 35, 34, 32, 33, 38, 36, 37, 43, 40, 42, 41, 45, 44, 46, 54, 52, 49, 48, 50, 51, 53, 57, 56, 55, 59, 58, 60 };
		
		BinaryTree start = null;
		start = BinaryTree.AddNode(start, characters[0], keys[0]);
	
		for (int i = 1; i < characters.length; i++)
		{
			BinaryTree.AddNode(start, characters[i], keys[i]);
		}
		assertNotEquals("testing", BinaryTree.Decode("- ..- ... .... .. --.", start));
	}
}
