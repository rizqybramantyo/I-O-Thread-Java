package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class DataManager extends Thread{

	private File file;

	public DataManager(File file) {
		this.file = file;
	}

	public void showData() {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String employeeData;
			while ((employeeData = reader.readLine()) != null) {
				String[] data = employeeData.split(",");
				System.out.println(data[0] + " ");
				System.out.println(data[1] + " ");
				System.out.println(data[2] + " ");
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean AddData(String id, String name, String job) {
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// BufferedReader br = new BufferedReader(input);

			String data = id + "," + name + "," + job;
			writer.append(data);
			writer.newLine();

			writer.close();
		} catch (Exception e) {
			return false;
		}
		return true;
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
