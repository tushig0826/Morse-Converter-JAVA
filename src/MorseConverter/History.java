package MorseConverter;

import java.io.*;

public class History {
	public static void saveHistory(String history, Object object) throws IOException {
		FileOutputStream file = new FileOutputStream(history);
		BufferedOutputStream output = new BufferedOutputStream(file);
		ObjectOutputStream output1 = new ObjectOutputStream(output);
		output1.writeObject(object);
		output1.close();
	}
	public static Object loadHistory(String history) throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(history);
		BufferedInputStream tmp = new BufferedInputStream(file);
		ObjectInputStream input = new ObjectInputStream(tmp);
		Object object = input.readObject();
		input.close();
		return object;
	}

}
