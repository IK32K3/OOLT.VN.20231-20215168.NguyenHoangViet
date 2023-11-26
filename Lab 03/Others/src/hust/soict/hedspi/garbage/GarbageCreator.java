package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
	public static void main(String[] args) throws java.io.IOException{
		String filename = "test.exe";
		byte[] inputBytes = {0};
		long start, end;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		start = System.currentTimeMillis();
		String outputString = "";
		for(byte b : inputBytes) {
			outputString += (char) b;	
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
}
