package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MainWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "Test Data3";
		File file = new File("D:/Writer/out.txt");
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// untuk mengganti isi
			//			fileWriter.write(data);
			//			fileWriter.close();
			// untuk menambah baris baru
			writer.newLine();
			writer.append(data);
			writer.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
