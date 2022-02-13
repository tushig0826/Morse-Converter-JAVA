package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import MorseConverter.MorseSound;
class SoundTest {

	@Test
	void testSound() {
		String a = ".";
		String b = "_";
		String c = " ";
		
		MorseSound ms = new MorseSound();
		ms.playMorse(a);
		ms.playMorse(b);
		ms.playMorse(c);
	}

	

}
