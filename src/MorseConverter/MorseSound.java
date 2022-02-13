package MorseConverter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MorseSound {
	public void dotSound()
	{
		try {
			Clip dot = AudioSystem.getClip();
			dot.open(AudioSystem.getAudioInputStream(new File("dotSound.wav")));
			dot.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	
	}
	public void dashSound()
	{
		try {
			Clip dash = AudioSystem.getClip();
			dash.open(AudioSystem.getAudioInputStream(new File("dashSound.wav")));
			dash.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void noSound()
	{
		//FileInputStream wavInput = new FileInputStream()
		try {
			Clip silent = AudioSystem.getClip();
			silent.open(AudioSystem.getAudioInputStream(new File("silent.wav")));
			silent.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	
	}

	public void playMorse(String morse)
	{
		for (int i = 0; i < morse.length(); i++)
		{
			if (morse.charAt(i) == '.')					
			{
				dotSound();
			}
			else if (morse.charAt(i) == '-')				
			{
				dashSound();
			}
			else
			{
				noSound();				
			}
		}
	}
		public static void saveMorse(String morse, Object object) throws IOException {
			FileOutputStream file = new FileOutputStream(morse);
			BufferedOutputStream output = new BufferedOutputStream(file);
			ObjectOutputStream output1 = new ObjectOutputStream(output);
			output1.writeObject(object);
			output1.close();
		}
		public static Object loadMorse(String morse) throws IOException, ClassNotFoundException {
			FileInputStream file = new FileInputStream(morse);
			BufferedInputStream tmp = new BufferedInputStream(file);
			ObjectInputStream input = new ObjectInputStream(tmp);
			Object object = input.readObject();
			input.close();
			return object;
		}
}

