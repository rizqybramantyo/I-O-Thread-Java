package App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DataPegawai {
	
	private File file;
	
	public DataPegawai(File file) {
		this.file = file;
	}
	public boolean DeleteData(String id, String name, String job) {
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			String data = id + "," + name + "," +job;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
